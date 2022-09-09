package com.example.demo.TpcW.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    public double SC_SUB_TOTAL;
    public double SC_TAX;
    public double SC_SHIP_COST;
    public double SC_TOTAL;
    public List<CartLine> lines;
    public List<String> lines1;

    public Cart(ResultSet rs, double C_DISCOUNT) throws java.sql.SQLException {
        int i;
        int total_items;
        lines = new ArrayList<CartLine>();
        while (rs.next()) {//While there are lines remaining
            CartLine line = new CartLine(rs.getString("i_title"),
                    rs.getDouble("i_cost"),
                    rs.getDouble("i_srp"),
                    rs.getString("i_backing"),
                    rs.getInt("scl_qty"),
                    rs.getInt("scl_i_id"));
            lines.add(line);
        }

        SC_SUB_TOTAL = 0;
        total_items = 0;
        for (i = 0; i < lines.size(); i++) {
            CartLine thisline = lines.get(i);
            SC_SUB_TOTAL += thisline.scl_cost * thisline.scl_qty;
            total_items += thisline.scl_qty;
        }
        SC_SUB_TOTAL = SC_SUB_TOTAL * ((100 - C_DISCOUNT) * .01);
        SC_TAX = SC_SUB_TOTAL * .0825;
        SC_SHIP_COST = 3.00 + (1.00 * total_items);
        SC_TOTAL = SC_SUB_TOTAL + SC_SHIP_COST + SC_TAX;
    }
}
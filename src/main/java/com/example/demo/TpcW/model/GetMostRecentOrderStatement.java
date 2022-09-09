package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetMostRecentOrderStatement {
    Connection con = Database.createCon();

    public Order getMostRecentOrder(String c_uname) {
        Order order = null;
        try {
            int order_id;
            PreparedStatement get_most_recent_order_id = con.prepareStatement("SELECT o_id " +
                    "FROM tpcw_customer, tpcw_orders " +
                    "WHERE tpcw_customer.c_id = tpcw_orders.o_c_id " +
                    "AND c_uname = '" + c_uname + "' " +
                    "AND ROWNUM <= 1 " +
                    "ORDER BY o_date, tpcw_orders.o_id DESC ");
            // Set parameter
            get_most_recent_order_id.setString(1, c_uname);
            ResultSet rs = get_most_recent_order_id.executeQuery();
            if (rs.next()) {
                order_id = rs.getInt("o_id");
            } else {
                rs.close();
                get_most_recent_order_id.close();
                con.commit();
                return null;
            }
            rs.close();
            get_most_recent_order_id.close();

            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return order;
    }

    public Order getMostRecentOrderTest(String c_uname) {
        Order order;
        if (c_uname.equals("{\n" + "\t\"c_uname\":\"Book\"\n" + "}"))
            return order = new Order("Jane", "Austen", "Border", "On way");
        else
            return null;
    }
}

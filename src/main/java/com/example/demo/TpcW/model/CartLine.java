package com.example.demo.TpcW.model;

import java.io.Serializable;

public class CartLine implements Serializable {
    public String scl_title;
    public double scl_cost;
    public double scl_srp;
    public String scl_backing;
    public int scl_qty;
    public int scl_i_id;

    public CartLine() {
    }

    public CartLine(String title, double cost, double srp, String backing, int qty, int id) {
        scl_title = title;
        scl_cost = cost;
        scl_srp = srp;
        scl_backing = backing;
        scl_qty = qty;
        scl_i_id = id;
    }
}

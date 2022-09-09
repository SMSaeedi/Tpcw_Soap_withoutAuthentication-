package com.example.demo.TpcW.model;

import java.io.Serializable;
import java.sql.ResultSet;

public class OrderLine implements Serializable {

    public OrderLine() {
    }

    public OrderLine(ResultSet rs) {
        try {
            ol_i_id = rs.getInt("ol_i_id");
            i_title = rs.getString("i_title");
            i_publisher = rs.getString("i_publisher");
            i_cost = rs.getDouble("i_cost");
            ol_qty = rs.getInt("ol_qty");
            ol_discount = rs.getDouble("ol_discount");
            ol_comments = rs.getString("ol_comments");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int ol_i_id;
    public String i_title;
    public String i_publisher;
    public double i_cost;
    public int ol_qty;
    public double ol_discount;
    public String ol_comments;

    public int getOl_i_id() {
        return ol_i_id;
    }

    public void setOl_i_id(int ol_i_id) {
        this.ol_i_id = ol_i_id;
    }

    public String getI_title() {
        return i_title;
    }

    public void setI_title(String i_title) {
        this.i_title = i_title;
    }

    public String getI_publisher() {
        return i_publisher;
    }

    public void setI_publisher(String i_publisher) {
        this.i_publisher = i_publisher;
    }

    public double getI_cost() {
        return i_cost;
    }

    public void setI_cost(double i_cost) {
        this.i_cost = i_cost;
    }

    public int getOl_qty() {
        return ol_qty;
    }

    public void setOl_qty(int ol_qty) {
        this.ol_qty = ol_qty;
    }

    public double getOl_discount() {
        return ol_discount;
    }

    public void setOl_discount(double ol_discount) {
        this.ol_discount = ol_discount;
    }

    public String getOl_comments() {
        return ol_comments;
    }

    public void setOl_comments(String ol_comments) {
        this.ol_comments = ol_comments;
    }
}
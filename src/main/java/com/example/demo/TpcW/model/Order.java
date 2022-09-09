package com.example.demo.TpcW.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {

    public Order(ResultSet rs) {
        try {
            o_id = rs.getInt("o_id");
            c_fname = rs.getString("c_fname");
            c_lname = rs.getString("c_lname");
            c_passwd = rs.getString("c_passwd");
            c_uname = rs.getString("c_uname");
            c_phone = rs.getString("c_phone");
            c_email = rs.getString("c_email");
            o_date = rs.getDate("o_date");
            o_subtotal = rs.getDouble("o_sub_total");
            o_tax = rs.getDouble("o_tax");
            o_total = rs.getDouble("o_total");
            o_ship_type = rs.getString("o_ship_type");
            o_ship_date = rs.getDate("o_ship_date");
            o_status = rs.getString("o_status");
            cx_type = rs.getString("cx_type");
            bill_addr_street1 = rs.getString("bill_addr_street1");
            bill_addr_street2 = rs.getString("bill_addr_street2");
            bill_addr_state = rs.getString("bill_addr_state");
            bill_addr_zip = rs.getString("bill_addr_zip");
            bill_co_name = rs.getString("bill_co_name");
            ship_addr_street1 = rs.getString("ship_addr_street1");
            ship_addr_street2 = rs.getString("ship_addr_street2");
            ship_addr_state = rs.getString("ship_addr_state");
            ship_addr_zip = rs.getString("ship_addr_zip");
            ship_co_name = rs.getString("ship_co_name");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int o_id;
    public String c_fname;
    public String c_lname;
    public String c_passwd;
    public String c_uname;
    public String c_phone;
    public String c_email;
    public Date o_date;
    public double o_subtotal;
    public double o_tax;
    public double o_total;
    public String o_ship_type;
    public Date o_ship_date;
    public String o_status;
    public String bill_addr_street1;
    public String bill_addr_street2;
    public String bill_addr_state;
    public String bill_addr_zip;
    public String bill_co_name;
    public String ship_addr_street1;
    public String ship_addr_street2;
    public String ship_addr_state;
    public String ship_addr_zip;
    public String ship_co_name;
    public String cx_type;
    public final List<OrderLine> order_lines = null;

    public Order(String c_fname, String c_lname, String o_ship_type, String o_status) {
        this.c_fname = c_fname;
        this.c_lname = c_lname;
        this.o_ship_type = o_ship_type;
        this.o_status = o_status;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getC_fname() {
        return c_fname;
    }

    public void setC_fname(String c_fname) {
        this.c_fname = c_fname;
    }

    public String getC_lname() {
        return c_lname;
    }

    public void setC_lname(String c_lname) {
        this.c_lname = c_lname;
    }

    public String getC_passwd() {
        return c_passwd;
    }

    public void setC_passwd(String c_passwd) {
        this.c_passwd = c_passwd;
    }

    public String getC_uname() {
        return c_uname;
    }

    public void setC_uname(String c_uname) {
        this.c_uname = c_uname;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public String getC_email() {
        return c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    public Date getO_date() {
        return o_date;
    }

    public void setO_date(Date o_date) {
        this.o_date = o_date;
    }

    public double getO_subtotal() {
        return o_subtotal;
    }

    public void setO_subtotal(double o_subtotal) {
        this.o_subtotal = o_subtotal;
    }

    public double getO_tax() {
        return o_tax;
    }

    public void setO_tax(double o_tax) {
        this.o_tax = o_tax;
    }

    public double getO_total() {
        return o_total;
    }

    public void setO_total(double o_total) {
        this.o_total = o_total;
    }

    public String getO_ship_type() {
        return o_ship_type;
    }

    public void setO_ship_type(String o_ship_type) {
        this.o_ship_type = o_ship_type;
    }

    public Date getO_ship_date() {
        return o_ship_date;
    }

    public void setO_ship_date(Date o_ship_date) {
        this.o_ship_date = o_ship_date;
    }

    public String getO_status() {
        return o_status;
    }

    public void setO_status(String o_status) {
        this.o_status = o_status;
    }

    public String getBill_addr_street1() {
        return bill_addr_street1;
    }

    public void setBill_addr_street1(String bill_addr_street1) {
        this.bill_addr_street1 = bill_addr_street1;
    }

    public String getBill_addr_street2() {
        return bill_addr_street2;
    }

    public void setBill_addr_street2(String bill_addr_street2) {
        this.bill_addr_street2 = bill_addr_street2;
    }

    public String getBill_addr_state() {
        return bill_addr_state;
    }

    public void setBill_addr_state(String bill_addr_state) {
        this.bill_addr_state = bill_addr_state;
    }

    public String getBill_addr_zip() {
        return bill_addr_zip;
    }

    public void setBill_addr_zip(String bill_addr_zip) {
        this.bill_addr_zip = bill_addr_zip;
    }

    public String getBill_co_name() {
        return bill_co_name;
    }

    public void setBill_co_name(String bill_co_name) {
        this.bill_co_name = bill_co_name;
    }

    public String getShip_addr_street1() {
        return ship_addr_street1;
    }

    public void setShip_addr_street1(String ship_addr_street1) {
        this.ship_addr_street1 = ship_addr_street1;
    }

    public String getShip_addr_street2() {
        return ship_addr_street2;
    }

    public void setShip_addr_street2(String ship_addr_street2) {
        this.ship_addr_street2 = ship_addr_street2;
    }

    public String getShip_addr_state() {
        return ship_addr_state;
    }

    public void setShip_addr_state(String ship_addr_state) {
        this.ship_addr_state = ship_addr_state;
    }

    public String getShip_addr_zip() {
        return ship_addr_zip;
    }

    public void setShip_addr_zip(String ship_addr_zip) {
        this.ship_addr_zip = ship_addr_zip;
    }

    public String getShip_co_name() {
        return ship_co_name;
    }

    public void setShip_co_name(String ship_co_name) {
        this.ship_co_name = ship_co_name;
    }

    public String getCx_type() {
        return cx_type;
    }

    public void setCx_type(String cx_type) {
        this.cx_type = cx_type;
    }

    public List<OrderLine> getOrder_lines() {
        return order_lines;
    }
}
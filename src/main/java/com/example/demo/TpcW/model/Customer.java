package com.example.demo.TpcW.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;

public class Customer implements Serializable {
    public int c_id;
    public String c_uname;
    public String c_passwd;
    public String c_fname;
    public String c_lname;
    public String c_phone;
    public String c_email;
    public Date c_since;
    public Date c_last_visit;
    public Date c_login;
    public Date c_expiration;
    public double c_discount;
    public double c_balance;
    public double c_ytd_pmt;
    public Date c_birthdate;
    public String c_data;
    public int addr_id;
    public String addr_street1;
    public String addr_street2;
    public String addr_city;
    public String addr_state;
    public String addr_zip;
    public int addr_co_id;
    public String co_name;

    public Customer() {
    }

    public Customer(ResultSet rs) {
        try {
            c_id = rs.getInt("c_id");
            c_uname = rs.getString("c_uname");
            c_passwd = rs.getString("c_passwd");
            c_fname = rs.getString("c_fname");
            c_lname = rs.getString("c_lname");

            c_phone = rs.getString("c_phone");
            c_email = rs.getString("c_email");
            c_since = rs.getDate("c_since");
            c_last_visit = rs.getDate("c_last_login");
            c_login = rs.getDate("c_login");
            c_expiration = rs.getDate("c_expiration");
            c_discount = rs.getDouble("c_discount");
            c_balance = rs.getDouble("c_balance");
            c_ytd_pmt = rs.getDouble("c_ytd_pmt");
            c_birthdate = rs.getDate("c_birthdate");
            c_data = rs.getString("c_data");

            addr_id = rs.getInt("addr_id");
            addr_street1 = rs.getString("addr_street1");
            addr_street2 = rs.getString("addr_street2");
            addr_city = rs.getString("addr_city");
            addr_state = rs.getString("addr_state");
            addr_zip = rs.getString("addr_zip");
            addr_co_id = rs.getInt("addr_co_id");

            co_name = rs.getString("co_name");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
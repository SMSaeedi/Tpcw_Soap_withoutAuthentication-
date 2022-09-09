package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetCustomerStatement {
    Connection con = Database.createCon();

    public Customer getCustomer(String UNAME) {
        Customer cust = null;
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM tpcw_customer, tpcw_address, tpcw_country WHERE tpcw_customer.c_addr_id = tpcw_address.addr_id AND tpcw_address.addr_co_id = tpcw_country.co_id AND tpcw_customer.c_uname = '" + UNAME + "'");
            statement.setString(1, UNAME);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                cust = new Customer(rs);
            } else {
                rs.close();
                statement.close();
                return null;
            }
            statement.close();
            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cust;
    }

    public Customer getCustomerTest(Customer customer) {
        Customer cust = new Customer();
        if (customer.c_uname.equals("Mahsa")) {
            cust.c_lname = "saeedi";
            cust.c_phone = "0998877654";
            cust.c_email = "mahsa.saeedy@gmail.com";
            cust.c_passwd = "***AS***23";
            cust.addr_city = "Tehran";
            cust.addr_state = "10th";
        } else cust = new Customer();

        return cust;
    }
}
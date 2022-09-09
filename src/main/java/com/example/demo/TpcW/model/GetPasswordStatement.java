package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetPasswordStatement {
    Connection con = Database.createCon();

    public String getPassword(String C_UNAME) {
        String passwd = null;

        try {
            // Prepare SQL
            PreparedStatement get_passwd = con.prepareStatement("SELECT c_passwd FROM tpcw_customer WHERE c_uname = '" + C_UNAME + "'");
            // Set parameter
            get_passwd.setString(1, C_UNAME);
            ResultSet rs = get_passwd.executeQuery();
            // Results
            rs.next();
            passwd = rs.getString("c_passwd");
            rs.close();
            get_passwd.close();
            con.commit();
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return passwd;
    }

    public String getPasswordHardCode(String userName) {

        String passwd = "310729";
        return passwd;
    }
}
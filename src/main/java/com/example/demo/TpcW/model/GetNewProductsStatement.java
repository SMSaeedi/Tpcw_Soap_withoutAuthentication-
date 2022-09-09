package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetNewProductsStatement {
    private Connection con = Database.createCon();
    private static List<ShortBook> vec = new ArrayList<ShortBook>();

    public List<ShortBook> getNewProducts(String subject) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT i_id, i_title, a_fname, a_lname " +
                    "FROM item, author " +
                    "WHERE item.i_a_id = author.a_id " +
                    "AND item.i_subject = '" + subject + "' " +
                    "AND ROWNUM <= 50 " +
                    "ORDER BY item.i_pub_date DESC,item.i_title ");

            // Set parameter
            statement.setString(1, subject);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                vec.add(new ShortBook(rs));
            }
            rs.close();
            statement.close();
            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vec;
    }

    public List<ShortBook> getNewProductsHardCode(String title) {
        List<ShortBook> vec = new ArrayList<ShortBook>();

        vec.add(new ShortBook(title));

        return vec;
    }
}
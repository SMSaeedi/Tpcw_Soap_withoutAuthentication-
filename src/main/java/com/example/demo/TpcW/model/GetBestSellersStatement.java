package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetBestSellersStatement {
    Connection con = Database.createCon();

    public List<ShortBook> getBestSellers(String subject) {
        List<ShortBook> books = new ArrayList<ShortBook>();
        try {
            // Prepare SQL
            PreparedStatement statement = con.prepareStatement
                    ("SELECT bestseller.i_id, i_title, a_fname, a_lname, ol_qty " +
                            "FROM tpcw_item, bestseller, tpcw_author WHERE tpcw_item.i_subject = '" + subject + "'" +
                            " AND tpcw_item.i_id = bestseller.i_id AND tpcw_item.i_a_id = tpcw_author.a_id " +
                            " ORDER BY ol_qty DESC FETCH FIRST 50 ROWS ONLY");

            // Set parameter
            ResultSet rs = statement.executeQuery();

            // Results
            while (rs.next()) {
                books.add(new ShortBook(rs));
            }
            rs.close();
            statement.close();
            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return books;
    }

    public List<ShortBook> getBestSellersTest(ShortBook subject) {
        List<ShortBook> vec = new ArrayList<ShortBook>();

        if (subject.i_title.equals("Pride and Prejudice"))
            vec.add(new ShortBook(1, "Pride and Prejudice", "Jane", "Austen"));
        else if (subject.i_title.equals("Sense and Sensibility"))
            vec.add(new ShortBook(2, "Sense and Sensibility", "Jane", "Austen"));
        else if (subject.i_title.equals("Sandition"))
            vec.add(new ShortBook(3, "Sandition", "Jane", "Austen"));
        else if (subject.i_title.equals("Great expectation"))
            vec.add(new ShortBook(4, "Great expectation", "Charles", "Dickens"));
        else if (subject.i_title.equals("Little Dorrit"))
            vec.add(new ShortBook(5, "Little Dorrit", "Charles", "Dickens"));
        else
            vec.add(new ShortBook());

        return vec;
    }
}
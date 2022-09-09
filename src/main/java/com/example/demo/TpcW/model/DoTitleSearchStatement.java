package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoTitleSearchStatement {
    Connection con = Database.createCon();

    public List<Book> doTitleSearch(String search_key) {
        List<Book> vec = new ArrayList<Book>();

        try {
            // Prepare SQL
            PreparedStatement statement = con.prepareStatement("SELECT * FROM tpcw_item, tpcw_author WHERE tpcw_item.i_a_id = tpcw_author.a_id AND tpcw_item.i_title LIKE '" + search_key + "' AND ROWNUM <= 50 ORDER BY tpcw_item.i_title ");
            // Set parameter
            statement.setString(1, search_key + "%");
            ResultSet rs = statement.executeQuery();
            // Results
            while (rs.next()) {
                vec.add(new Book(rs));
            }
            rs.close();
            statement.close();
            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vec;
    }

    public List<Book> doTitleSearchTest(Book search_key) {
        List<Book> vec = new ArrayList<Book>();

        if (search_key.i_title.equals("Pride and Prejudice"))
            vec.add(new Book("Pride and Prejudice", "Jane Austen", "Jane"));
        else if (search_key.i_title.equals("Sense and Sensibility"))
            vec.add(new Book("Sense and Sensibility", "Jane Austen", "Jane"));
        else if (search_key.i_title.equals("Sandition"))
            vec.add(new Book("Sandition", "Jane Austen", "Jane"));
        else if (search_key.i_title.equals("Great expectation"))
            vec.add(new Book("Great expectation", "Charles Dickens", "Charles"));
        else if (search_key.i_title.equals("Little Dorrit"))
            vec.add(new Book("Little Dorrit", "Charles Dickens", "Charles"));
        else
            vec.add(new Book());

        return vec;
    }
}
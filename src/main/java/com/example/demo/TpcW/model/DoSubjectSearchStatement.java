package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoSubjectSearchStatement {
    Connection con = Database.createCon();

    public List<Book> doSubjectSearch(String search_key) {
        List<Book> vec = new ArrayList<Book>();
        try {
            // Prepare SQL
            PreparedStatement statement = con.prepareStatement("SELECT * FROM tpcw_item, tpcw_author WHERE tpcw_item.i_a_id = tpcw_author.a_id AND tpcw_item.i_subject = '" + search_key + "' AND ROWNUM <= 50 ORDER BY tpcw_item.i_title ");
            // Set parameter
            statement.setString(1, search_key);
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

    public List<Book> doSubjectSearchHardCodeTest(Book search_key) {
        List<Book> vec = new ArrayList<Book>();

        if (search_key.i_subject.equals("Drama")) {
            vec.add(new Book("Pride and Prejudice", "Drama", "Jane"));
            vec.add(new Book("Sense and Sensibility", "Drama", "Jane"));
            vec.add(new Book("Sandition", "Drama", "Jane"));
        } else if (search_key.i_subject.equals("Adventure"))
            vec.add(new Book("Great expectation", "Adventure", "Charles"));
        else if (search_key.i_subject.equals("Period Drama"))
            vec.add(new Book("Little Dorrit", "Period Drama", "Charles"));
        else
            vec.add(new Book());

        return vec;
    }
}
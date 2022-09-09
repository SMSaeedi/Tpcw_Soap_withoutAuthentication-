package com.example.demo.TpcW.model;

import java.io.Serializable;
import java.sql.ResultSet;

public class ShortBook implements Serializable {

    public ShortBook() {
    }

    public ShortBook(ResultSet rs) {
        try {
            i_id = rs.getInt("i_id");
            i_title = rs.getString("i_title");
            a_fname = rs.getString("a_fname");
            a_lname = rs.getString("a_lname");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ShortBook(int i_id, String i_title, String a_fname, String a_lname) {
        this.i_id = i_id;
        this.i_title = i_title;
        this.a_fname = a_fname;
        this.a_lname = a_lname;
    }

    public ShortBook(String i_title) {
        this.i_title = i_title;
    }

    public int i_id;
    public String i_title;
    public String a_fname;
    public String a_lname;
}
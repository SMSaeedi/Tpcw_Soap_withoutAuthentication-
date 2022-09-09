package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminUpdateStatement {
    Connection con = Database.createCon();

    public void adminUpdate(AdminUpdateInParams inParams) {
        try {
            PreparedStatement st = con.prepareStatement("UPDATE adminupdate SET image = '" + inParams.getImage()
                    + "', thumbnail ='" + inParams.getThumbnail() + "'");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AdminUpdateOutParams hardCodeData(AdminUpdateInParams inParams) {
        AdminUpdateOutParams update = new AdminUpdateOutParams();

        inParams.setI_id(01);
        inParams.setCost(5000);
        inParams.setImage("pic");
        inParams.setThumbnail("something");

        update.setInParams(inParams);

        return update;
    }
}
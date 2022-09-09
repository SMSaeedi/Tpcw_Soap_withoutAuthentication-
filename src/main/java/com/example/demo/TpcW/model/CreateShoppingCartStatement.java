package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateShoppingCartStatement {
    private static Connection con = Database.createCon();

    public Cart getCart(int SHOPPING_ID) {
        Cart mycart = null;
        try {
            PreparedStatement get_cart = con.prepareStatement("SELECT * " +
                    "FROM tpcw_shopping_cart_line, tpcw_item " +
                    "WHERE scl_i_id = tpcw_item.i_id AND scl_sc_id = '" + SHOPPING_ID + "'");
            get_cart.setInt(1, SHOPPING_ID);
            ResultSet rs = get_cart.executeQuery();
            rs.close();
            get_cart.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mycart;
    }
}
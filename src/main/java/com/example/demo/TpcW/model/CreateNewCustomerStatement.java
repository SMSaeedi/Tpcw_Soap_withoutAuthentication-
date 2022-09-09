package com.example.demo.TpcW.model;

import com.example.demo.dataBaseConfig.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import static com.example.demo.TpcW.model.TPCWUtil.DigSyl;
import static com.example.demo.TpcW.model.TPCWUtil.formatDate;


public class CreateNewCustomerStatement {
    private static Connection con = Database.createCon();

    public Customer createNewCustomer(Customer cust) {
        try {
            cust.c_discount = (int) (Math.random() * 51);
            cust.c_balance = 0.0;
            cust.c_ytd_pmt = 0.0;
            // FIXME - Use SQL CURRENT_TIME to do this
            cust.c_last_visit = new Date(System.currentTimeMillis());
            cust.c_since = new Date(System.currentTimeMillis());
            cust.c_login = new Date(System.currentTimeMillis());
            cust.c_expiration = new Date(System.currentTimeMillis() +
                    7200000);//milliseconds in 2 hours
            Statement insert_customer_row = Database.createMaxStatement(con);
            cust.addr_id = enterAddress(con, cust.addr_street1, cust.addr_street2, cust.addr_city, cust.addr_state, cust.addr_zip, cust.co_name);
            Statement get_max_id = Database.createMaxStatement(con);

            synchronized (Customer.class) {
                ResultSet rs = get_max_id.executeQuery("SELECT max(c_id) FROM tpcw_customer");
                rs.next();
                cust.c_id = rs.getInt(1);
                rs.close();
                cust.c_id += 1;
                cust.c_uname = DigSyl(cust.c_id, 0);
                cust.c_passwd = cust.c_uname.toLowerCase();
                final String sql = "INSERT into tpcw_customer (c_id, c_uname, c_passwd, c_fname, c_lname, c_addr_id, c_phone, c_email, c_since, c_last_login, c_login, c_expiration, c_discount, c_balance, c_ytd_pmt, c_birthdate, c_data) " +
                        " VALUES (" + cust.c_id + ", '" + cust.c_uname + "', '" +
                        cust.c_passwd + "', '" + cust.c_fname + "', '" + cust.c_lname + "', " + cust.addr_id + ", '" + cust.c_phone + "', '" + cust.c_email + "', " + formatDate(cust.c_since) + ", " + formatDate(cust.c_last_visit) + ", " + formatDate(cust.c_login) + ", " + formatDate(cust.c_expiration) + ", " + cust.c_discount + ", " + cust.c_balance + ", " + cust.c_ytd_pmt + ", " + formatDate(cust.c_birthdate) + ", '" + cust.c_data + "')";
                insert_customer_row.executeUpdate(sql);
                con.commit();
                insert_customer_row.close();
            }
            get_max_id.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cust;
    }

    private int enterAddress(Connection con, String street1, String street2, String city, String state, String zip, String country) {
        int addr_id = 0;
        try {
            Statement get_co_id = Database.createMaxStatement(con);
            ResultSet rs = get_co_id.executeQuery("SELECT co_id FROM tpcw_country WHERE co_name = '" + country + "'");
            rs.next();
            int addr_co_id = rs.getInt("co_id");
            rs.close();
            get_co_id.close();

            Statement match_address = Database.createMaxStatement(con);

            rs = match_address.executeQuery("SELECT addr_id FROM tpcw_address " +
                    " WHERE addr_street1 = '" + street1 + "' " +
                    "   AND addr_street2 = '" + street2 + "' " +
                    "   AND addr_city = '" + city + "' " +
                    "   AND addr_state = '" + state + "' " +
                    "   AND addr_zip = '" + zip + "' " +
                    "   AND addr_co_id = " + addr_co_id);

            if (!rs.next()) {
                Statement insert_address_row = Database.createMaxStatement(con);
                Statement get_max_addr_id = Database.createMaxStatement(con);
                synchronized (Address.class) {
                    ResultSet rs2 = get_max_addr_id.executeQuery("SELECT max(addr_id) FROM tpcw_address");
                    rs2.next();
                    addr_id = rs2.getInt(1) + 1;

                    rs2.close();
                    insert_address_row.executeUpdate("INSERT into tpcw_address (addr_id, addr_street1, addr_street2, addr_city, addr_state, addr_zip, addr_co_id) " +
                            "VALUES ('" + addr_id + "', '" + street1 + "', '" + street2 + "', '" + city + "', '" + state + "', '" + zip + "', " + addr_co_id + ")");
                }
                get_max_addr_id.close();
                insert_address_row.close();
            } else {
                addr_id = rs.getInt("addr_id");
            }
            match_address.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return addr_id;
    }
}
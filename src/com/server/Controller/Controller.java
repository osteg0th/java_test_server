package com.server.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    private String url;
    private String user;
    private String password;

    private Connection con;
    private Statement stmt;
    private ResultSet rs;


    public Controller(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String SelectData() throws SQLException {     //TODO rewrite using try-with-resources
        String result = "";
        try {
//            String[] s = {"table1", "id,", "name," ,"surname"};
            String[] s = {"table1", "*"};
            con = DriverManager.getConnection(url, user, password);     // opening database connection to MySQL server
            stmt = con.createStatement();                               // getting Statement object to execute query
//            rs = stmt.executeQuery(DBController.SelectFromDB("id", "name","surname", "table1")); // executing SELECT query
            rs = stmt.executeQuery(DBController.SelectFromDB(s)); // executing SELECT query
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                result += id + " " + name + " " + surname + "\n";
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return result;
    }

}

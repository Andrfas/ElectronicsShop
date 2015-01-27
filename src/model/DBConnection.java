package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Andrey on 25.01.2015.
 */
public class DBConnection {
    private static DBConnection dbConn = null;
    private static Statement statement = null;
    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/ElectronicsShop?" +
                            "user=andrfas&password=59722795");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance() {
        if (dbConn == null) {
            new DBConnection();
        }
        return dbConn;
    }

    public static Statement getStatement() {
        if (dbConn == null) {
            new DBConnection();
        }
        return statement;
    }
}

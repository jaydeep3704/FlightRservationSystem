package com.example.frs;
import java.sql.*;


public class sqlDB {
  private static Connection con;
    public static Connection getConnection()
    {
    try {


        if (con == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightreservation", "root", "jaydeep@3704");

        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return con;
    }
}

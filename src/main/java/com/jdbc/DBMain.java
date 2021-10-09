package com.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * UC1 : Ability to create a payroll service database and have java program connect to database
 *
 * @author : VAISHNAVI VISHWAKARMA.
 * @since : 08.10.2021
 */
public class DBMain {
    public static void main(String[] args) {
        /**
         * Purpose : Use the payroll_service database created in MySQL
         */

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "vrv14";
        Connection connection;

        /**
         * Purpose : Check if the Driver Class is available for the java program
         */

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded.");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        //List all the drivers registered with jdbc
        listDrivers();

        /**
         * Purpose : Check if the database connection to payroll_service mysql DB is established
         */

        try {
            System.out.println("Connecting to database: " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful! " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listDrivers() {

        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = driverList.nextElement();
            System.out.println(driverClass.getClass().getName());
        }
    }
}

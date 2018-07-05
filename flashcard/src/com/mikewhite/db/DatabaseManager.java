package com.mikewhite.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String CONNECTION_STR = "jdbc:mysql://%s:3306/vocab?characterEncoding=UTF-8&user=%s&password=%s";

    private Connection conn;
    private Statement stmt;
    private static DatabaseManager instance;

    private DatabaseManager() {

    }

    public static DatabaseManager getInstance() {
        if (instance == null)
            instance = new DatabaseManager();
        return instance;
    }

    public boolean connect(String host, String user, String pass) {
        try {
            conn = DriverManager.getConnection(String.format(CONNECTION_STR, host, user, pass));
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }

    public ResultSet fetch(String sql) throws SQLException {
        stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void execute(String sql) throws SQLException {
        System.out.println("execute: " + sql);
        stmt.execute(sql);
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

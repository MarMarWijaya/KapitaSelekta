/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author Ardian
 */
public class ConnectionDB {

    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;

    private void connectionInitialitation() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/tugas_ks", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        connectionInitialitation();
        return connection;
    }

    public ResultSet connectDBResultSet(String query) throws SQLException {
        resultSet = null;

        try {
            connectionInitialitation();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }

        return resultSet;
    }

    public void connectDBPreparedStatementInsert(
            String query,
            String transactionID,
            String transactionType,
            int nominal,
            String AccNumDestination,
            String userID) {

        try {
            connectionInitialitation();

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, transactionID);
            preparedStatement.setString(2, transactionType);
            preparedStatement.setInt(3, nominal);
            preparedStatement.setDate(4, startDate);
            preparedStatement.setString(5, AccNumDestination);
            preparedStatement.setString(6, userID);
            preparedStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void connectDBPreparedStatementInsertAccount(
            String query,
            String accountID,
            String name,
            String accNumber,
            String cardNumber,
            String pin,
            int currentBalance,
            String user) {
        try {
            connectionInitialitation();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, accountID);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, accNumber);
            preparedStatement.setString(4, cardNumber);
            preparedStatement.setString(5, pin);
            preparedStatement.setInt(6, currentBalance);
            preparedStatement.setString(7, user);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void connectDBPreparedStatementInsertUser(
            String query, 
            String userID, 
            String name, 
            String phoneNum, 
            String email, 
            String account) 
    {
        try {
            connectionInitialitation();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, phoneNum);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, account);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void connectDBPreparedStatementUpdate(String query, int value1, int value2, String name) {
        try {
            connectionInitialitation();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, value1);
            preparedStatement.setInt(2, value2);
            preparedStatement.setString(3, name);
            preparedStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet connectDBPreparedStatementSingleValue(String query, String value) {
        ResultSet resultSet = null;

        try {
            connectionInitialitation();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, value);

            resultSet = preparedStatement.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

        return resultSet;
    }

    public void queryUpdate(String query) {
        try {
            connectionInitialitation();
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

    }
}

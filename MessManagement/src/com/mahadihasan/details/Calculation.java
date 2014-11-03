package com.mahadihasan.details;

import com.mahadihasan.db.Connect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Calculation {

    static final String DATABASE_URL = "jdbc:mysql://localhost/MessManagement";
    static final String USER = "root";
    static final String PASS = "";
    public Statement statement = null;
    public Connection connection = null;
    public ResultSet resultSet = null;

    public void getConnection() {

        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }

            connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            statement = connection.createStatement();


        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Not Connected");
        }


    }

    public double calculateMealRate() {
        double mealRate = 0;

        try {
            mealRate = (double) (getTotalBazarCost() / getTotalMeals());
        } catch (ArithmeticException exception) {
        }
        return mealRate;

    }

    public int getMembersTotalDeposit(String name) throws SQLException {

        getConnection();

        int membersTotaldeposit = 0;
        String s;
        String sql;

        sql = "SELECT Amount FROM deposit WHERE Name = '" + name + "'";

        try {
            resultSet = statement.executeQuery(sql);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("--------------");


            while (resultSet.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {

                    s = resultSet.getObject(i).toString();
                    System.out.printf("%-8s\t", s);
                    membersTotaldeposit = membersTotaldeposit + Integer.parseInt(s);
                }

                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println("Exception");
        }

        closeDB();
      
        //JOptionPane.showMessageDialog(null, membersTotaldeposit);
        
        System.out.println("Total(Members): " + membersTotaldeposit);

        return membersTotaldeposit;

    }

    public int getMembersTotalMeal(String name) {
        getConnection();

        int membersTotalMeal = 0;

        String s;
        String sql;

        sql = "SELECT Count FROM meal WHERE Name = '" + name + "'";

        try {
            resultSet = statement.executeQuery(sql);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("--------------");


            while (resultSet.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {

                    s = resultSet.getObject(i).toString();
                    System.out.printf("%-8s\t", s);
                    membersTotalMeal = membersTotalMeal + Integer.parseInt(s);
                }

                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println("Exception");
        }


        System.out.println("Total Meal (Member): " + membersTotalMeal);

        closeDB();
        return membersTotalMeal;

    }

    public int getTotalMeals() {
        getConnection();
        String sql;
        //===================
        int totalMeal = 0;
        String s;

        sql = "SELECT Count FROM meal";

        try {
            resultSet = statement.executeQuery(sql);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("--------------");


            while (resultSet.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {

                    s = resultSet.getObject(i).toString();
                    System.out.printf("%-8s\t", s);
                    totalMeal = totalMeal + Integer.parseInt(s);
                }

                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println("Exception");
        }


        System.out.println("Total Meal : " + totalMeal);


        closeDB();
        return totalMeal;
    }

    public int getTotalDeposit() {
        getConnection();
        String sql;
        //===================
        int totalDeposit = 0;
        String s;

        sql = "SELECT Amount FROM deposit";

        try {
            resultSet = statement.executeQuery(sql);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("--------------");


            while (resultSet.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {

                    s = resultSet.getObject(i).toString();
                    System.out.printf("%-8s\t", s);
                    totalDeposit = totalDeposit + Integer.parseInt(s);
                }

                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println("Exception");
        }

        closeDB();
        
        //JOptionPane.showMessageDialog(null, totalDeposit);


        closeDB();
        return totalDeposit;
    }

    public int getTotalBazarCost() {
        getConnection();
        String sql;
        //===================
        int totalBazarCost = 0;
        String s;

        sql = "SELECT Amount FROM bazar";

        try {
            resultSet = statement.executeQuery(sql);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("--------------");


            while (resultSet.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {

                    s = resultSet.getObject(i).toString();
                    System.out.printf("%-8s\t", s);
                    totalBazarCost = totalBazarCost + Integer.parseInt(s);
                }

                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println("Exception");
        }


        System.out.println("Total Bazar Cost : " +totalBazarCost);



        closeDB();
        return totalBazarCost;
    }

    public double denaPaona(String name) {
        
        getConnection();
        
        double balance = 0;
        int totalDeposit;
        int totalMeal;
        double mealRate;
        double totalCost;
        
        AllInfo allInfo = new AllInfo();
        
        try{
            
            totalDeposit = allInfo.getMembersTotalDeposit(name);
            totalMeal = allInfo.getMembersTotalMeal(name);
            mealRate = calculateMealRate();
            totalCost = totalMeal*mealRate;
            
            balance = totalDeposit - totalCost;
            
        }catch(Exception exception) {
            
        }
        
        closeDB();
        
        return balance;
    }
    
    public void closeDB() {
        try {
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
        }
    }
}

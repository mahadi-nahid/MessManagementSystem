package com.mahadihasan.db;

import com.mahadihasan.member.Member;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Connect {

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

    public void saveMemberToDB(Member member) throws SQLException {

        String sql;
        getConnection();

        sql = "INSERT INTO `MessManagement`.`member` (`fName`, `lName`, `nName`, `mob`, `email`)"
                + " VALUES ('" + member.getFirstName() + "', '"
                + member.getLastName() + "', '" + member.getNickName()
                + "', '" + member.getMobileNo() + "', '" + member.getEmail() + "')";



        statement.executeUpdate(sql);
        
        //Meal
        sql = "INSERT INTO `messmanagement`.`meal` (`Name`, `Count`, `Date`) VALUES ('"+member.getNickName()+"', '0', '0');";
        statement.executeUpdate(sql);
        //Deposit
        sql = "INSERT INTO `messmanagement`.`deposit` (`Name`, `Amount`, `Date`) VALUES ('"+member.getNickName()+"', '0', '0');";
        statement.executeUpdate(sql);
        
        closeDB();
    }

    public String[] getMembers() {
        String[] names = new String[10];

        getConnection();
        String sql;
        sql = "SELECT nName FROM member";


        try {
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            int j = 0;
            while (resultSet.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {

                    names[j] = resultSet.getObject(i).toString();
                }
                j++;

            }


        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeDB();
        return names;
    }

    public void upDateBazar(String name, int amount, String date) {

        getConnection();
        String sql;

        //===
        //
        //
        
        sql = "INSERT INTO `messmanagement`.`bazar` (`Name`, `Amount`, `Date`) VALUES ('"+name+"', '"+amount+"', '"+date+"');";
        
        try {
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            
        }
        closeDB();
    }

    public void upDateMeal(String name, int count, String date) {
        getConnection();
        String sql;
        //===================

        //

        //
        sql = "INSERT INTO `messmanagement`.`meal` (`Name`, `Count`, `Date`) VALUES ('"+name+"', '"+count+"', '"+date+"');";
        
        try {
            statement.executeUpdate(sql);
        } catch (Exception exception) {
            
        }
        closeDB();
    }

    public void updateDeposit(String name, int amount, String date) {
        getConnection();
        String sql;
        //===================

       //JOptionPane.showMessageDialog(null, "Connect;;;"+name+"\n"+amount+"\n"+date);
       
       sql = "INSERT INTO `messmanagement`.`deposit` (`Name`, `Amount`, `Date`) "
               + "VALUES ('"+name+"', '"+amount+"', '"+date+"');";
        
        try {
            statement.executeUpdate(sql);
        } catch (Exception exception) {
           
        }
        closeDB();
        
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

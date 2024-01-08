/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Connect {
public static Connection con= null;

    /**
     *
     * @throws SQLException
     */
    public static void connectSQL() throws SQLException{
        try{
            String userName ="sa";
            String passWord="123456";
             String hostName = "localhost";
             String sqlInstanceName = "SQLEXPRESS";
            String database = "Millionaire";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
 
             con = DriverManager.getConnection(connectionURL, userName,
             passWord);
//            String url="jdbc:sqlserver://DESKTOP-T4K7QHS:1433;databaseName=Millionaire;";
//            con=java.sql.DriverManager.getConnection(url,userName,passWord);
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Kết nối CSDL thất bại","Thông báo", 1);
        }
    }
    public ResultSet LoadData(String sql){
     ResultSet result = null;
        try {
            Statement statement = con.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static ResultSet resultSet(String sql) {
        ResultSet rs = null;
        try {
            PreparedStatement statement = query().prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = statement.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
     public void UpdateData(String sql){        
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }   
    public static Connection query() {
        return con;
    }
//    public static void main(String[] args)throws SQLException{
//        Connection conn =connectSQL();
//       
//        System.out.println(conn);
//    }
}  

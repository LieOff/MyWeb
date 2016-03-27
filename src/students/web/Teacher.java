
package students.web;


import java.sql.*;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by Илья on 26.03.2016.
 */
public class Teacher {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/sapr";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

   public String GetTeacherById(int Id){
        String query = "select * from teacher Where ID = '"+Id+"'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){}
       String NameTeach;
       NameTeach = "";
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                NameTeach = rs.getString(3) + " " + rs.getString(2) + " " + rs.getString(4);
             }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return NameTeach;
    }

    public List<String> getAllTeachers() {
        String query = "select * from teacher ";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){}
        List<String> NamesTeach = new ArrayList<String>();
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                NamesTeach.add(rs.getString(3) + " " + rs.getString(2) + " " + rs.getString(4));
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return NamesTeach;

    }
      public List<Integer> GetArtiCalsByTeacher(int Id) {
        String query = "select * from teach_art Where IDTeach='"+Id+"'";
        List<Integer> Artical = new ArrayList<Integer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){}
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Artical.add(rs.getInt(3));
            }

        }catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return Artical;
    }
}

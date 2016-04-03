package students.web;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Илья on 27.03.2016.
 */
public class Articles {

    private static final String url = "jdbc:mysql://localhost:3306/sapr";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public List<Integer> GetTeacherByArtical(int Id){
        String query = "select * from teach_art Where IDArt = '"+Id+"'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){}
        List<Integer> TeachList = new ArrayList<Integer>();
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                TeachList.add(rs.getInt(2));
              }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) {  }
            try { stmt.close(); } catch(SQLException se) { }
            try { rs.close(); } catch(SQLException se) { }
        }
        return TeachList;

    }
    public List<String> GetArticalsById(int Id){
        String query = "select * from articles Where ID = '"+Id+"'";
        return ReturnSql(query);
    }
    private List<String> ReturnSql(String query){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){}
        List<String> NameAndDesc = new ArrayList<String>();
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            while (rs.next()) {
                NameAndDesc.add(rs.getString(1));
                NameAndDesc.add(rs.getString(2));
                NameAndDesc.add(rs.getString(3));
                NameAndDesc.add(dateFormat.format(rs.getDate(4)));
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) {  }
            try { stmt.close(); } catch(SQLException se) { }
            try { rs.close(); } catch(SQLException se) { }
        }
        return NameAndDesc;
    }

    public List<String> GetAllArticals() {
        String query = "select * from articles";
        return ReturnSql(query);
    }
}

package com.youxigu.ee.dbunit.testdbunit3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月11日 上午10:35:55
*/
public class Dbunit {
	public static Connection getConnection() throws SQLException {
	    Connection con = null;
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youxigu", "root", "root");
	    return con;
	  }
	 
	  public static void close(Connection con) {
	    try {
	      if (con != null)
	        con.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	 
	  public static void close(PreparedStatement ps) {
	    try {
	      if (ps != null)
	        ps.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	 
	  public static void close(ResultSet rs) {
	    try {
	      if (rs != null)
	        rs.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
}

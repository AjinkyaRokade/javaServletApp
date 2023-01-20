package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.User;
import com.utils.DbUtils;

public class UserManager {

	private Connection con;
	
	public UserManager() {
		this.con=DbUtils.getCon();
	}
	
	public int adduser(User user) throws SQLException {
		
		PreparedStatement pst=con.prepareStatement("insert into users values(default,?,?,?,?)");
		
		pst.setString(1, user.getCustName());
		pst.setString(2, user.getCity());
		pst.setString(3, user.getEmail());
		pst.setString(4, user.getPassword());
		
		int a=pst.executeUpdate();
		return a;
		
		
	}
	
	public List<User> getAllUsers() throws SQLException{
		List<User> list=new ArrayList<User>();
		Statement stmt=con.createStatement();
		ResultSet set = stmt.executeQuery("Select * from users");
		while(set.next()) {
			list.add(new User(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5)));
		}
		
		return list;
		
		
	}
	
	
	public User validateUser(String userName, String pwd) throws SQLException {
		 
		System.out.println("-----inside validateUser method-----"+userName+"   "+pwd);
		//add parameter
		PreparedStatement stmt=con.prepareStatement("select * from users where email=? and password=?");
		 stmt.setString(1, userName);
		 stmt.setString(2, pwd);
		 
		ResultSet rset= stmt.executeQuery();
		 User user=null;
		while(rset.next())
		{
			user=new User(rset.getInt("userid"),
					      rset.getString("custName"),  
					      rset.getString("city"),
					      rset.getString("email"),
					      rset.getString("password"));
		}		
		return user;
	}

	
}

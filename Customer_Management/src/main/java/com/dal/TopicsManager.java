package com.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.topic;
import com.utils.DbUtils;

public class TopicsManager {
	
	private Connection con;
	
	public TopicsManager() {
		con=DbUtils.getCon();
	}
	
	
	public List<topic> getAllTopics() throws SQLException{
		
		List<topic> list=new ArrayList<topic>();
		Statement stmt=con.createStatement();
		ResultSet set = stmt.executeQuery("Select * from topics");
		
		while(set.next()) {
			
			list.add(new topic(set.getInt(1), set.getString(2)));
		}
		return list;
	}
}

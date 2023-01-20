package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.tutorial;
import com.utils.DbUtils;

public class TutorialsManager {
	
	private Connection con;
	
	public TutorialsManager() {
		con=DbUtils.getCon();
	}
	
	
	public List<tutorial> getById(int id) throws SQLException {
		List<tutorial> list=new ArrayList<tutorial>();
		
		PreparedStatement pst=con.prepareStatement("select * from tutorials where topic_id="+id+"");
		ResultSet set = pst.executeQuery();
		
		while(set.next()) {
			
			list.add(new tutorial(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5), set.getString(6), set.getInt(7)));
		}
		return list;
	}
	
	public List<tutorial> getByTutId(int id) throws SQLException {
		List<tutorial> list=new ArrayList<tutorial>();
		
		PreparedStatement pst=con.prepareStatement("select * from tutorials where id="+id+"");
		ResultSet set = pst.executeQuery();
		
		while(set.next()) {
			
			list.add(new tutorial(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5), set.getString(6), set.getInt(7)));
		}
		return list;
	}


}

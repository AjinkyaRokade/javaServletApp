package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dal.TopicsManager;
import com.pojo.User;
import com.pojo.topic;

@WebServlet("/topics")
public class topics extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TopicsManager tm;
	@Override
	public void init() throws ServletException {
		 tm=new TopicsManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession();
		if(hs!= null) {
			pw.write("<h1 style=\"text-align: center;\">Hii "+((User)hs.getAttribute("user")).getCustName()+"</h1><h3 style=\"text-align: center;\">Select from following topics</h3>");
			try {
				pw.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
						+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\r\n"
						+ "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
				pw.write("<form style=\"text-align:center\" action='tutorials'>");
				List<topic> list=tm.getAllTopics();
				list.forEach(topic->pw.write("<button class='btn btn-primary' style='width:150px' type='submit' id="+topic.getId()+" name='topic' value="+topic.getId()+">"+topic.getName()+"</button><br/><br/><br/>"));
				pw.write("</form>");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
			pw.write("<h1>Access Denied Login First</h1>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	public void destroy() {
		
	}

}

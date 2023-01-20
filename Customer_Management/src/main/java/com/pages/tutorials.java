package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dal.TutorialsManager;
import com.pojo.User;
import com.pojo.topic;
import com.pojo.tutorial;

@WebServlet("/tutorials")
public class tutorials extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TutorialsManager tm;

	@Override
	public void destroy() {
	
	}

	@Override
	public void init() throws ServletException {
		tm=new TutorialsManager();	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		HttpSession hs=request.getSession();
		if(hs!= null) {
			try {
				
				pw.write("<h1 style=\"text-align:center\">Tutorials Available</h1>");
				List<tutorial> tuts = tm.getById(Integer.parseInt(request.getParameter("topic")));
				pw.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
						+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\r\n"
						+ "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
				pw.write("<form style=\"text-align:center\" action='tutorials' method='post'>");
			
				tuts.forEach(tut->pw.write("<button class='btn btn-primary' style='width:150px' type='submit' id="+tut.getName()+" name='tutorial' value="+tut.getId()+">"+tut.getName()+"</button><br/><br/><br/>"));
				pw.write("</form>");
			
			
		}
			catch (Exception e) {
		e.printStackTrace();
	}
		}else
			pw.write("<Access Denied Please Log in>");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		HttpSession hs=request.getSession();
		if(hs!= null) {
			try {
				pw.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
						+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\r\n"
						+ "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
				pw.write("<h1 style=\"text-align:center\">Tutorials Information</h1><table style='margin:auto; width:700px;' class='table table-striped' >");
				
				List<tutorial> tuts = tm.getByTutId(Integer.parseInt(request.getParameter("tutorial")));
				tuts.forEach(tut->pw.write("<tr><td>Id</td><td><h3>"+tut.getId()+"</h3></td></tr><tr><td>Name</td><td><h3>"+tut.getName()+"</h3></td>"
						+ "</tr><tr><td>Author</td><td><h3>"+tut.getAuthor()+"</h3></tr><tr></td><td>Publish Date</td><td><h3>"+tut.getPublish_date()+""
								+ "</h3></tr><tr></td><td>Content</td><td><h3>"+tut.getContents()+"</h3></td></tr><tr><td>"
										+ "<a href='tutorials?topic="+tut.getTopic_id()+"'><button  class='btn btn-success'>Back</button>"
												+ "</a></td><td><a href='user'><button  class='btn btn-success'>Logout</button></a></td></tr>"));
				
				pw.write("</table>");
			}catch (Exception e) {
				e.printStackTrace();
			
	}
		}
		else
			pw.write("<Access Denied Please Log in>");
}
}

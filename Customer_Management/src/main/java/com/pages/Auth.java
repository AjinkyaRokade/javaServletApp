package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.UserManager;
import com.pojo.User;
import com.utils.DbUtils;


@WebServlet("/registerserv")
public class Auth extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	UserManager usm;
    public Auth() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		try {
			DbUtils.openConnection();
			usm=new UserManager();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
	}
	
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<table><tr><th>Id</th><th>Name</th><th>City</th><th>Email</th></tr>");
		try {
			List<User> users=usm.getAllUsers();
			
			users.forEach(user->pw.write("<tr><td>"+user.getUserid()+"</td><td>"+user.getCustName()+"</td><td>"+user.getCity()+"</td><td>"+user.getEmail()+"</td><td><a href=\"user/"+user.getUserid()+"\"><button type=\"button\" class=\"btn btn-success\" \">Update</button></a>\r\n"
					+ "</td></tr>"));
			
			pw.write ("</table>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user=new User(request.getParameter("name"), request.getParameter("city"),request.getParameter("email"), request.getParameter("pass"));
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
			try {
				if(usm.adduser(user)>0) {
				pw.write("<script>alert(\"Registered successfully\")</script>");
				response.sendRedirect("/Customer_Management");
				}
				else
					pw.write("<h3>User could not be registered</h3>");

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}

//	@Override
//	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("In put method");
//	}
//	


}

package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dal.UserManager;
import com.pojo.User;
import com.utils.DbUtils;

@WebServlet(value="/user", loadOnStartup = 1)
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private UserManager usm;

	@Override
	public void init() throws ServletException {
		try
		 {
		DbUtils.openConnection();
		usm=new UserManager();
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pr=response.getWriter();
		HttpSession hs=request.getSession();
		System.out.println("Why the hell");
		hs.invalidate();
		pr.write("<h1>You have been Successfully logged out</h1>");
		pr.write("<h1>"+hs.getAttribute("user")+"</h1>");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		try(PrintWriter pr=response.getWriter();)
		{

		String username=request.getParameter("email");
		
		//get pwd
		String pwd=request.getParameter("pass");
		
		//call userDao.validUser method for validation
		User userObj=usm.validateUser(username, pwd);
		if(userObj!=null)
		{
			HttpSession hs=request.getSession();
//			hs.setMaxInactiveInterval(10);
			hs.setAttribute("user", userObj);
			response.sendRedirect("topics");
		}
		else
		{
		
			response.sendRedirect("index.html");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

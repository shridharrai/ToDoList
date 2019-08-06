package com.brainmentors.todolist.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brainmentors.todolist.dao.ToDoDAO;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private String isCookiePresent(
			HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		if(cookies!=null && cookies.length>0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(
						"favcolor")) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		String color = isCookiePresent(request);
		try {
			String msg = ToDoDAO.login(
					userid, password);
			if(msg == null) {
				System.out.println(
						"Invalid userid or password");
			}
			else {
				System.out.println("Welcome "+msg);
				HttpSession session = 
						request.getSession(true);
				System.out.println(session.getId());
				session.setAttribute("uid", userid);
				if(color!=null) {
					session.setAttribute("color", color);
				}
				else {
					color = "yellow";
					Cookie cookie = new Cookie("favcolor", color);
					cookie.setMaxAge(365*24*60*60);
					response.addCookie(cookie);
					session.setAttribute("color", color);
				}
				response.sendRedirect("index.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

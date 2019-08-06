package com.brainmentors.todolist.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brainmentors.todolist.helper.ToDoList;
import com.brainmentors.todolist.helper.ToDoListOperations;

/**
 * Servlet implementation class ToDoListController
 */
@WebServlet("/todo")
public class ToDoListController extends HttpServlet {
	ToDoListOperations opr;
	public void init() {
		opr = new ToDoListOperations();
		System.out.println("init called");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside ToDoController post");
		String btn = request.getParameter("searchitbtn");
		if(btn!=null && btn.equals("SearchIt")) {
			System.out.println("Inside loop");
			RequestDispatcher rd = request.getRequestDispatcher("searchctrl");
			rd.forward(request, response);
			return;
		}
		System.out.println("Outside loop");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		String date = request.getParameter("enddate");
		System.out.println("date is "+date);
//		date.format(Locale.ENGLISH, date, null);
//		 DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern) 
		LocalDate d = LocalDate.parse(date);
		ToDoList obj = new ToDoList(Integer.parseInt(id),name,desc,d);
		opr.add(obj);
		System.out.println("I am in post "+id+" name "+name+" desc "+desc+" date "+d);
		System.out.println(obj);
		request.setAttribute("mydata", opr.list);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}

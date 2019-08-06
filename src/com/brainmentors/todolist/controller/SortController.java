package com.brainmentors.todolist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brainmentors.todolist.helper.ToDoListOperations;

/**
 * Servlet implementation class SortController
 */
@WebServlet("/sort")
public class SortController extends HttpServlet {
	ToDoListOperations opr = new ToDoListOperations();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		opr.sort();
		request.setAttribute("mydata", ToDoListOperations.list);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	

}

<%@page import="com.brainmentors.todolist.helper.ToDoList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todolist</title>
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<style>
.size {
width: 72px;
height: 72px;
}
.hide {
display: none;
}
</style>
<script>
function showSearch() {
	document.getElementById("box").classList.
	toggle('hide');
}
</script>
</head>
<body bgcolor='<%=session.getAttribute("color")%>'>
<div class='container'>
<%
if(session.getAttribute("uid")==null) {
	response.sendRedirect("login.html");
}
%>
<h2>Welcome <%=session.getAttribute("uid") %></h2>
<a href="logout">Logout</a>
<h1 class='alert-info text-center'>TodoList App</h1>
<form action="todo" method="post">
<div class='form-group'>
<label>Id</label>
<input name="id" class='form-control' type='text'
 placeholder='Type Task Name'>
</div>
<div class='form-group'>
<label>Name</label>
<input name="name" class='form-control' type='text'
 placeholder='Type Task Name'>
</div>
<div class='form-group'>
<label>Desc</label>
<textarea name="desc" class='form-control'
  placeholder='Type Task Desc' rows='10' cols='30'>
</textarea>
</div>
<div class='form-group'>
<label>EndDate</label>
<input name="enddate" class='form-control' 
type='date'>

</div>
<div class='form-group'>
<button type='submit' class='btn btn-primary'>Add</button>
<button class='btn btn-danger'>Delete</button>
<button type="button" class='btn btn-info'
 onclick="showSearch()">Search</button>
<div class="hide" id="box">
<form action="">
<input name="sid" type="text" placeholder="Type id">
<button name="searchitbtn" value="SearchIt">
Search it</button>
</form>
</div>
<button class='btn btn-warning'>Update</button>
<a href="sort" class='btn btn-success'>Sort</a>
<button class='btn btn-dark'>Finish</button>
<button class='btn btn-secondary'>Pending</button>
</div>
<table class="table table-bordered">
<thead class="thead-dark">
<tr>
<th>Id</th>
<th>Name</th>
<th>Desc</th>
<th>Date</th>
<th>Operations</th>
</tr>
</thead>
<tbody>
<%
ArrayList<ToDoList>list = 
(ArrayList<ToDoList>)request.getAttribute("mydata");
if(list!=null){
	for(ToDoList obj : list) {
		%>
		<tr>
		<td><%=obj.getId() %></td>
		<td><%=obj.getName() %></td>
		<td><%=obj.getDesc() %></td>
		<td><%=obj.getDate() %></td>
		<td><a href="delete?id=<%= obj.getId() %>">
		<img class="size" alt="Image not loaded"
		  src="images/deleteicon.png"></a>
		</tr>
		<%
	}
} %>
</tbody> 
</table>
</form>
</div>
</body>
</html>
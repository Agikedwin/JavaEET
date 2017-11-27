<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta charset="UTF-8">
         <meta http-equiv="X-UA-Compatible" content="IE=edge" />
         <meta http-equiv="pragram" content="no-cache" />
         <meta http-equiv="Cache-Control" content="no-cache" />
         <meta http-equiv="Expires" content="Sat, 01 Dec 2018 00:00:00 GMT" />
        
        <title>Boot Application | Home</title>
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/css/styles.css" rel="stylesheet">
        
     
<!--[if lt IE 9]>
  <script src="static/js/html5shiv.js"></script>
  <script src="static/js/respond.min.js"></script>
<![endif]-->
</head>

<body>
<c:choose>

<c:when test="${auth != 'MODE_NO'}">

<div role="navigation">
<div class="navbar navbar-inverse ">
<a href="/home" class="navbar-brand">Home</a>

<div class="navbar-collapse collapse">
<ul class="nav navbar-nav">

<li><a href="newuser">Add Users</a></li>
<li><a href="allusers">View Users</a></li>
<li><a href="newtask">New Tasks</a></li>
<li><a href="alltasks">All Tasks</a></li>
</ul>
</div>

</div>
</div>

</c:when>

</c:choose>


<c:choose>

<c:when test="${mode == 'MODE_HOME'}">
<div class="container " id="homeDiv">
<div class="jumbotron text-center" >
<h1>Welcome to Agik Tasks  App</h1>
</div>
<div class="jumbotron " >
<ul>
<li>List of all finshed tasks</li>
<li>List of all unfinshed tasks</li>
<li>List of all suspended  tasks</li>

</ul>

</div>

</div>
</c:when>

<c:when test="${mode == 'MODE_TASKS'}">

<div class="container text-center " id="taskDiv">
<h3>My Tasks</h3>
<hr>
<div class="table-responsive">
<table class="table table-striped table-bordered text-left">
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Description</th>
<th>Date Created</th>
<th>Finished</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>

<c:forEach var="task" items="${tasks}">
<tr>
<td>${task.id}</td>
<td>${task.name}</td>
<td>${task.description}</td>
<td><fmt:formatDate pattern="yyyy-mm-dd-HH:mm:ss"  value="${task.date_created}"/></td>
<td>${task.finished}</td>

<td><a href="updatetask?id=${task.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
<td><a href="deletetask?id=${task.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>

</c:forEach>

</tbody>
</table>
</div>
</div>
</c:when>



<%-- 
<c:when test="${mode != 'MODE_NEW' && mode != 'MODE_UPDATE'}">
<div class="container text-center">
<h6>Operation Successfully finished</h6>
</div>

</c:when>
 --%>



<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">



<div class="container text-center">
<h3>Manage Tasks</h3>
<hr>
<form class="form-horizontal" method="POST" action="savetask">
<input type="hidden" name="id" value="${task.id }">
<div class="form-group">
<label class="control-label col-md-3">Name</label>
<div class="col-md-5">
<input type="text" class="form-control" name="name" value="${task.name }">
</div>
</div>

<div class="form-group">
<label class="control-label col-md-3">Description</label>
<div class="col-md-5">
<input type="text" class="form-control" name="description" value="${task.description }">
</div>
</div>

<div class="form-group">
<label class="control-label col-md-3">Finished</label>
<div class="col-md-5">
<input type="radio" class="col-sm-1" name="finished" value="true">
<div class="col-sm-1">Yes</div>
<input type="radio" class="col-sm-1" name="finished" value="true">
<div class="col-sm-1">No</div>
</div>
</div>
<div class="form-group">
<input type="submit" class="btn btn-primary" value="save" />

</div>
</form>
</div>
</c:when>

<c:when test="${mode == 'MODE_NEWUSER' }">

<div class="container text-center">
<h3>ADD USER | EDIT NEW USER</h3>
<hr>
<form class="form-horizontal" method="POST" action="saveuser">
<input type="hidden" name="userid" value="${user.userid}">
<div class="form-group">
<label class="control-label col-md-3">First Name</label>
<div class="col-md-5">
<input type="text" class="form-control" name="firstname" value="${user.firstname }">
</div>
</div>

<div class="form-group">
<label class="control-label col-md-3">Last Name</label>
<div class="col-md-5">
<input type="text" class="form-control" name="lastname" value="${user.lastname }">
</div>
</div>

<div class="form-group">
<label class="control-label col-md-3">Gender</label>
<div class="col-md-5">
<input type="radio" class="col-sm-1" name="gender" value="male">
<div class="col-sm-1">Male</div>
<input type="radio" class="col-sm-1" name="gender" value="female">
<div class="col-sm-1">Female</div>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-3">User Name</label>
<div class="col-md-5">
<input type="text" class="form-control" name="username" value="${user.username }">
</div>
</div>

<div class="form-group">
<label class="control-label col-md-3">Password</label>
<div class="col-md-5">
<input type="text" class="form-control" name="password" value="${user.password }">
</div>
</div>

<div class="form-group">
<input type="submit" class="btn btn-primary" value="save" />

</div>
</form>
</div>

</c:when>


<c:when test="${mode == 'MODE_ALLUSERS'}">

<div class="container text-center " id="viewUsersDiv">
<h3>My Tasks</h3>
<hr>
<div class="table-responsive">
<table class="table table-striped table-bordered text-left">
<thead>
<tr>
<th>User Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Gender</th>
<th>Username</th>
<th>Password</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>

<c:forEach var="user" items="${users}">
<tr>
<td>${user.userid}</td>
<td>${user.firstname}</td>
<td>${user.lastname}</td>
<%-- <td><fmt:formatDate pattern="yyyy-mm-dd-HH:mm:ss"  value="${task.date_created}"/></td> --%>
<td>${user.gender}</td>
<td>${user.username}</td>
<td>${user.password}</td>

 <td><a href="updatetask?id=${user.userid}"><span class="glyphicon glyphicon-pencil"></span></a></td>
<td><a href="deletetask?id=${user.userid}"><span class="glyphicon glyphicon-trash"></span></a></td> 
</tr>

</c:forEach>

</tbody>
</table>
</div>
</div>


</c:when>

<c:when test="${mode == 'MODE_LOGIN'}">


<div class="container text-center">
<h3>Login Page</h3>
<hr>
<form class="form-horizontal" method="POST" action="login"><%-- 
<input type="hidden" name="id" value="${user.id }"> --%>
<div class="form-group">
<label class="control-label col-md-3">User Name</label>
<div class="col-md-5">
<input type="text" class="form-control" name="username" value="${user.username }">
</div>
</div>

<div class="form-group">
<label class="control-label col-md-3">Password</label>
<div class="col-md-5">
<input type="text" class="form-control" name="description" value="${user.password }">
</div>
</div>


<div class="form-group">
<input type="submit" class="btn btn-primary" value="Login" />

</div>
</form>
</div>

</c:when>


</c:choose>


<script src="static/js/jquery-3.2.1.js"></script>
 <script src="static/js/bootstrap.min.js"></script>
 <script src="static/js/bootstrap.js"></script>
</body>
   
 </html>
    
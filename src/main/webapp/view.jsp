<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Add Courses</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
    	<img src="images/logo1.png" height="50px">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.html" style="color: white; font-size: 17px;">Add Course</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="" style="color: white; font-size: 17px;">View Course</a>
        </li>
      </ul>
     
    </div>
  </div>
</nav>



<h4>Course Management</h4>
<div class="container">
<table class="table">
  <thead style="color: white;">
    <tr bgcolor="#120671">
      <th scope="col">Sr No |</th>
      <th scope="col">Name|</th>
      <th scope="col">Category |</th>
      <th scope="col">Duration |</th>
      <th scope="col">Fee |</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <div class="red"></div>
  <tbody>
  
  <c:forEach items="${courses}" var="course">
  
      <tr bgcolor="#bffef4">
      <td scope="col"><c:out value="${course.courseID} "/></td>
      <td scope="col"><c:out value="${course.courseName} "/></td>
      <td scope="col"><c:out value="${course.fees} "/></td>
      <td scope="col"><c:out value="${course.catagory} "/></td>
      <td scope="col"><c:out value="${course.duration} "/></td>
      <td scope="col">
        <a href="#"><i class="fa fa-trash" aria-hidden="true"></i></a>
        <a href="#"><i class="fa fa-eye" aria-hidden="true"></i></a>
        <a href="#"><i class="fa fa-edit" aria-hidden="true"></i></a>
      </td>
    </tr>
    </c:forEach>
    
  </tbody>
</table>
</div>



</body>
</html>
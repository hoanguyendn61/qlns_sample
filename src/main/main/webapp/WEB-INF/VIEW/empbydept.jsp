<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sách nhân viên theo phòng ban</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous"> 
</head>
<body class="flex">
	<div class="h-auto inline-block mx-auto relative">
		<h2 class="text-3xl text-center my-2">Display List Of Employees</h2>
		<table class="table-auto mx-auto">
        	<thead>
	        	<tr>
	                <th>IDNV</th>
	                <th>Name</th>
	                <th>Address</th>
	                <th>IDPB</th>
	            </tr>
        	</thead>
            <tbody>
            	<c:forEach var="emp" items="${empList}" >
	            <tr>
	             	<td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getIdnv()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getName()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getAddress()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getIdPb()}</td>
	            </tr>
	           </c:forEach>
            </tbody>
    	</table>
    	<button onclick="window.history.back()" class="bg-white px-2 border border-blue-500 rounded text-blue-600 font-bold mt-2 absolute right-1">Back</button>
	</div>
</body>
</html>
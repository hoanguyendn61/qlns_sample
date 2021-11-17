<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous"> 
<title>Xóa thông tin nhiều nhân viên</title>
</head>
<body class="flex">
	<div class="h-auto inline-block mx-auto mb-8 mt-4">
		<a href="<%=request.getContextPath()%>/homepage" class="bg-white px-2 py-2 border border-blue-500 rounded text-blue-600 font-bold">Homepage</a>
		<h2 class="text-3xl mb-4 mt-4">List Of Employees</h2>
		<form action="<%=request.getContextPath()%>/rmEmp" method="post">
		<table class="table-auto mx-auto">
        	<thead>
	        	<tr>
	                <th>IDNV</th>
	                <th>Name</th>
	                <th>Address</th>
	                <th>IDPB</th>
	                <th>Chọn</th>
	            </tr>
        	</thead>
            <tbody>
            	<c:forEach var="emp" items="${empList}" >
	            <tr>
	             	<td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getIdnv()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getName()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getAddress()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getIdPb()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium text-center"><input type="checkbox" name="IDNVs" value="${emp.getIdnv()}"></td>
	            </tr>
	           </c:forEach>
            </tbody>
    	</table>
    	<input type="submit" value="Delete" class="font-bold px-2 py-1 bg-blue-500 rounded text-white float-right mt-2">
    	</form>
	</div>
</body>
</html>
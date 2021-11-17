<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sách phòng ban</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous"> 
</head>
<body class="flex">
	<div class="h-auto inline-block mx-auto relative">
		<h2 class="text-3xl text-left my-2">Display List Of Departments</h2>
		<table class="table-auto mx-auto">
        	<thead>
	        	<tr>
	                <th>IDPB</th>
	                <th>Tên PB</th>
	                <th>Mô tả</th>
	                <th>Xem nhân viên</th>
	            </tr>
        	</thead>
            <tbody>
            	<c:forEach var="dp" items="${dpList}" >
	            <tr>
	             	<td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${dp.getIdpb()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${dp.getNamepb()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${dp.getDesc()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium text-center"><a href="<%=request.getContextPath()%>/empbydeptlist?idpb=${dp.getIdpb()}" class="bg-blue-200 rounded px-2 py-1">CLICK</a></td>
	            </tr>
	           </c:forEach>
            </tbody>
    	</table>
    	<button onclick="window.history.back()" class="bg-white px-2 border border-blue-500 rounded text-blue-600 font-bold mt-2 absolute right-1">Back</button>
	</div>
</body>
</html>
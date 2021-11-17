<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous"> 
<title>Cập nhập thông tin phòng ban</title>
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
	                <th></th>
	            </tr>
        	</thead>
            <tbody>
            	<c:forEach var="dp" items="${dpList}" >
	            <tr>
	             	<td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${dp.getIdpb()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${dp.getNamepb()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${dp.getDesc()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium text-center"><a href="<%=request.getContextPath()%>/updateDept?idpb=${dp.getIdpb()}" class="bg-blue-200 rounded px-2 py-1">UPDATE</a></td>
	            </tr>
	           </c:forEach>
            </tbody>
    	</table>
    	<button onclick="window.history.back()" class="bg-white px-2 border border-blue-500 rounded text-blue-600 font-bold mt-2 absolute right-1">Back</button>
	</div>
</body>
</html>
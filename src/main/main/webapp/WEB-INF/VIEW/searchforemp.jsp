<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tìm kiếm nhân viên</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous"referrerpolicy="no-referrer" />
</head>
<body class="flex">
	<div class="mt-3 w-1/4 mr-auto ml-auto relative">
		<form action="<%=request.getContextPath()%>/searchforemp" method="post" class="px-2 flex items-center border-1 bg-white shadow-sm rounded-full">
			<select name="field">
			  <option value="IDNV">IDNV</option>
			  <option value="Hoten" selected>Tên</option>
			  <option value="IDPB">IDPB</option>
			  <option value="Diachi">Địa chỉ</option>
			</select>
			<input class="rounded-l-sm w-full py-2 px-6 text-gray-700 leading-tight focus:outline-none" name="search"
			type="text"placeholder="Search">
			<div class="p-2">
				<button
				type="submit"
				class="bg-blue-500 text-white rounded-full p-2 hover:bg-blue-400 focus:outline-none w-12 h-12 flex items-center justify-center">
				<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<button onclick="window.history.back()" class="bg-white px-2 border border-blue-500 rounded text-blue-600 font-bold mt-2 absolute right-1">Back</button>
		<c:if test="${empSearch != null}">
  			<table class="table-auto mx-auto mt-8">
        	<thead>
	        	<tr>
	                <th>IDNV</th>
	                <th>Name</th>
	                <th>Address</th>
	                <th>IDPB</th>
	            </tr>
        	</thead>
            <tbody>
            	<c:forEach var="emp" items="${empSearch}" >
	            <tr>
	             	<td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getIdnv()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getName()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getAddress()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getIdPb()}</td>
	            </tr>
	           </c:forEach>
            </tbody>
    		</table>
		</c:if>
	</div>
</body>
</html>
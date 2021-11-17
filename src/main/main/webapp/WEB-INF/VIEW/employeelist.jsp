<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sách nhân viên</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous"> 
</head>
<body class="flex">
	<c:if test="${not empty param.alert}"> 
		<script>
	        alert("Mã nhân viên đã tồn tại");
    	</script>
	</c:if>
	<div class="h-auto inline-block mx-auto mb-8">
		<c:if test="${guest == null && emp == null}">
			<h1 class="text-3xl mb-4 mt-8">Employee Information Form</h1>
			<form action="<%=request.getContextPath()%>/insertEmp" method="post">
				<div class="flex justify-start">
					<div class="my-4 text-left mr-8 w-24">
			            <label for="idnv" class="text-gray-900">IDNV:</label>
			            <input type="text" name="idnv" class="border block w-full p-2 mt-2 rounded" placeholder="Enter IDNV">
		        	</div>
					<div class="my-4 text-left ml-2">
			            <label for="idpb" class="text-gray-900">IDPB:</label>
			            <select name="idpb" class="border block w-full p-2 mt-2 rounded">
				            	<c:forEach var="dept" items="${deptList}" >
				            		<option value="${dept.getIdpb()}">${dept.getIdpb()}</option>
				            	</c:forEach>
						</select>
		        	</div>
				</div>
				<div class="flex justify-start">
		        	<div class="my-4 text-left mr-8 w-2/6">
			            <label for="name" class="text-gray-900">Name:</label>
			            <input type="text" name="name" class="border block w-full p-2 mt-2 rounded" placeholder="Enter Name">
			        </div>
			        <div class="my-4 text-left w-2/5">
			            <label for="address" class="text-gray-900">Address:</label>
			            <input type="text" name="address" class="border block w-full p-2 mt-2 rounded" placeholder="Enter Address">
			        </div>
				</div>
		        <div class="float-right"> 
		        	<input type="submit" value="Submit" class="bg-blue-500 border-2 border-solid border-blue-500 text-white px-10 py-2 mt-2 inline-block rounded">
					<input type="reset" value="Reset" class="bg-white border-2 border-solid border-blue-500 text-blue-500 px-5 py-2 mt-2 inline-block rounded">
					
		        </div>
			</form>
		</c:if>
		
		<c:if test="${guest == null && emp != null}">
			<h1 class="text-3xl mb-4 mt-8">Employee Information Form</h1>
			<form action="<%=request.getContextPath()%>/updateEmp" method="post">
				<div class="flex justify-start">
					<div class="my-4 text-left mr-8 w-24">
			            <label for="idnv" class="text-gray-900">IDNV:</label>
			            <input type="text" name="idnv" class="border block w-full p-2 mt-2 rounded" value="${emp.getIdnv()}" readonly>
		        	</div>
					<div class="my-4 text-left ml-2">
			            <label for="idpb" class="text-gray-900">IDPB:</label>
			            <select name="idpb" class="border block w-full p-2 mt-2 rounded">
				            	<c:forEach var="dept" items="${deptList}" >
				            		<option value="${dept.getIdpb()}">${dept.getIdpb()}</option>
				            	</c:forEach>
						</select>
		        	</div>
				</div>
				<div class="flex justify-start">
		        	<div class="my-4 text-left mr-8 w-2/6">
			            <label for="name" class="text-gray-900">Name:</label>
			            <input type="text" name="name" class="border block w-full p-2 mt-2 rounded" value="${emp.getName()}">
			        </div>
			        <div class="my-4 text-left w-2/5">
			            <label for="address" class="text-gray-900">Address:</label>
			            <input type="text" name="address" class="border block w-full p-2 mt-2 rounded" value="${emp.getAddress()}">
			        </div>
				</div>
		        <div class="float-right"> 
		        	<input type="submit" value="Submit" class="bg-blue-500 border-2 border-solid border-blue-500 text-white px-10 py-2 mt-2 inline-block rounded">
					<input type="reset" value="Reset" class="bg-white border-2 border-solid border-blue-500 text-blue-500 px-5 py-2 mt-2 inline-block rounded">
		        </div>
			</form>
		</c:if>
		
		<h2 class="text-3xl mb-4 mt-16">List Of Employees</h2>
		<form action="<%=request.getContextPath()%>/rmEmp" method="post">
		<table class="table-auto mx-auto">
        	<thead>
	        	<tr>
	                <th>IDNV</th>
	                <th>Name</th>
	                <th>Address</th>
	                <th>IDPB</th>
	                <th></th>
	                <th></th>
	                <th><input type="submit" value="Delete" class="font-bold px-2 bg-blue-500 rounded text-white"></th>
	            </tr>
        	</thead>
            <tbody>
            	<c:forEach var="emp" items="${empList}" >
	            <tr>
	             	<td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getIdnv()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getName()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getAddress()}</td>
	                <td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium">${emp.getIdPb()}</td>
	                <c:if test="${guest == null}">
	                	<td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium text-center"><a href="<%=request.getContextPath()%>/updateEmp?idnv=${emp.getIdnv()}" class="bg-green-200 rounded px-2 py-1">UPDATE</a></td>
	                	<td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium text-center"><a href="<%=request.getContextPath()%>/rmEmp?idnv=${emp.getIdnv()}" class="bg-red-200 rounded px-2 py-1">DELETE</a></td>
	                	<td class="border border-blue-500 px-4 py-2 text-light-blue-600 font-medium text-center"><input type="checkbox" name="IDNVs" value="${emp.getIdnv()}"></td>
	                </c:if>
	            </tr>
	           </c:forEach>
            </tbody>
    	</table>
    	</form>
    	<button onclick="window.history.back()" class="bg-white px-2 border border-blue-500 rounded text-blue-600 font-bold mt-2 float-right">Back</button>
	</div>
</body>
</html>
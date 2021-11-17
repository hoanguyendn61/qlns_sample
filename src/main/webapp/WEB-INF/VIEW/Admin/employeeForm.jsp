<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous"> 
<title>Form nhập liệu nhân viên</title>
</head>
<body class="flex">
	<div class="h-auto inline-block mx-auto mb-8 mt-4">
		<a href="<%=request.getContextPath()%>/homepage" class="bg-white px-2 py-2 border border-blue-500 rounded text-blue-600 font-bold">Homepage</a>
		<c:if test="${emp == null}">
			<h1 class="text-3xl mb-4 mt-4">Employee Information Form</h1>
			<form action="<%=request.getContextPath()%>/insertEmp" method="post">
				<div class="grid grid-rows-4 grid-flow-col gap-2">
				  <div class="text-left items-center flex">
				  	 <label for="idnv" class="text-gray-900">Mã nhân viên:</label>
				  </div>
				   <div class="text-left items-center flex">
				   	<label for="name" class="text-gray-900">Họ và tên:</label>
				  	
				  </div>
				  <div class="text-left items-center flex">
				  	<label for="idpb" class="text-gray-900">Mã phòng ban:</label>
				  </div>
				  <div class="text-left items-center flex">
				  	<label for="address" class="text-gray-900">Địa chỉ:</label>
				  </div>
				  <div class="text-left items-center flex">
				  		<input type="text" name="idnv" class="border block w-24 p-2 rounded" placeholder="Enter IDNV">
				  </div>
				  <div class="text-left items-center flex">
				  	<input type="text" name="name" class="border block w-full p-2 rounded" placeholder="Enter Name">
				  </div>
				  <div class="text-left items-center flex">
				  	<select name="idpb" class="border block w-24 p-2 mt-2 rounded">
 				        <c:forEach var="dept" items="${deptList}">
 				            <option value="${dept.getIdpb()}">${dept.getIdpb()}</option>
				        </c:forEach>
 					</select>
				  </div>
				  <div class="text-left items-center flex">
				  	<input type="text" name="address" class="border block w-full p-2 rounded" placeholder="Enter Address">
				  </div>
				</div>
				<div class="float-right"> 
		        	<input type="submit" value="Submit" class="bg-blue-500 border-2 border-solid border-blue-500 text-white px-10 py-2 mt-2 inline-block rounded">
					<input type="reset" value="Reset" class="bg-white border-2 border-solid border-blue-500 text-blue-500 px-5 py-2 mt-2 inline-block rounded">
		        </div>
			</form>
		</c:if>
		<c:if test="${not empty param.alert}">  
 			<script> 
 	       		alert("Mã nhân viên đã tồn tại"); 
     		</script> 
 		</c:if>
		<c:if test="${emp != null}">
			<h1 class="text-3xl mb-4 mt-8">Employee Information Form</h1>
			<form action="<%=request.getContextPath()%>/updateEmp" method="post">
				<div class="grid grid-rows-4 grid-flow-col gap-2">
				  <div class="text-left items-center flex">
				  	 <label for="idnv" class="text-gray-900">Mã nhân viên:</label>
				  </div>
				   <div class="text-left items-center flex">
				   	<label for="name" class="text-gray-900">Họ và tên:</label>
				  </div>
				  <div class="text-left items-center flex">
				  	<label for="idpb" class="text-gray-900">Mã phòng ban:</label>
				  </div>
				  <div class="text-left items-center flex">
				  	<label for="address" class="text-gray-900">Địa chỉ:</label>
				  </div>
				  <div class="text-left items-center flex">
				  		<input type="text" name="idnv" class="border block w-24 p-2 rounded" placeholder="Enter IDNV" value="${emp.getIdnv() }">
				  </div>
				  <div class="text-left items-center flex">
				  	<input type="text" name="name" class="border block w-full p-2 rounded" placeholder="Enter Name" value="${emp.getName() }">
				  </div>
				  <div class="text-left items-center flex">
				  	<select name="idpb" class="border block w-24 p-2 mt-2 rounded">
 				        <c:forEach var="dept" items="${deptList}">
 				            <option value="${dept.getIdpb()}">${dept.getIdpb()}</option>
				        </c:forEach>
 					</select>
				  </div>
				  <div class="text-left items-center flex">
				  	<input type="text" name="address" class="border block w-full p-2 rounded" placeholder="Enter Address" value="${emp.getAddress()}">
				  </div>
				</div>
		        <div class="float-right"> 
		        	<input type="submit" value="Submit" class="bg-blue-500 border-2 border-solid border-blue-500 text-white px-10 py-2 mt-2 inline-block rounded">
					<input type="reset" value="Reset" class="bg-white border-2 border-solid border-blue-500 text-blue-500 px-5 py-2 mt-2 inline-block rounded">
		        </div>
			</form>
		</c:if>
	</div>
</body>
</html>
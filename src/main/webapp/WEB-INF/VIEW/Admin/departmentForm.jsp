<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous"> 
<title>Form nhập liệu phòng ban</title>
</head>
<body class="flex">
	<div class="h-auto inline-block mx-auto mb-8 mt-4">
		<a href="<%=request.getContextPath()%>/homepage" class="bg-white px-2 py-2 border border-blue-500 rounded text-blue-600 font-bold">Homepage</a>
		<h1 class="text-3xl mb-4 mt-4">Department Information Form</h1>
		<form action="<%=request.getContextPath()%>/updateDept" method="post">
			<div class="grid grid-rows-3 grid-flow-col gap-2">
				  <div class="text-left items-center flex">
				  	 <label for="idpb" class="text-gray-900">Mã phòng ban:</label>
				  </div>
				   <div class="text-left items-center flex">
				  	<label for="Tenpb" class="text-gray-900">Tên phòng ban:</label>
				  </div>
				  <div class="text-left items-center flex">
				  	<label for="Mota" class="text-gray-900">Mô tả:</label>
				  </div>
				  <div class="text-left items-center flex">
				  	<input type="text" name="IDPB" class="border block w-full p-2 rounded" placeholder="Enter IDPB" value="${dept.getIdpb()}">
				  </div>
				  <div class="text-left items-center flex">
				  	<input type="text" name="Tenpb" class="border block w-full p-2 rounded" placeholder="Enter Name" value="${dept.getNamepb()}">
				  </div>
				  <div class="text-left items-center flex">
				  	<input type="text" name="Mota" class="border block w-full p-2 rounded" placeholder="Enter Description" value="${dept.getDesc()}">
				  </div>
			</div>
			<div class="float-right"> 
		        <input type="submit" value="Submit" class="bg-blue-500 border-2 border-solid border-blue-500 text-white px-10 py-2 mt-2 inline-block rounded">
				<input type="reset" value="Reset" class="bg-white border-2 border-solid border-blue-500 text-blue-500 px-5 py-2 mt-2 inline-block rounded">
		    </div>
		</form>
	</div>
</body>
</html>
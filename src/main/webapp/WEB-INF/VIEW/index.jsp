<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body  class="bg-gray-600">
	<div class="bg-white rounded p-10 text-center shadow-md w-1/3 mx-auto mt-20">
	<form action="<%=request.getContextPath()%>/login" method="post">
		<div class="my-4 text-left">
            <label for="username" class="text-gray-900">Username:</label>
            <input type="text" name="username" class="border block w-full p-2 mt-2 rounded" placeholder="Enter Username">
        </div>
		<div class="my-4 text-left">
            <label for="password" class="text-gray-900">Password:</label>
            <input type="password" name="password" class="border block w-full p-2 mt-2 rounded" placeholder="Enter Password">
        </div>
        
		<input type="submit" value="Login" class="bg-blue-500 border-2 border-solid border-blue-500 text-white px-10 py-2 mt-2 inline-block rounded">
		<input type="reset" value="Reset" class="bg-white border-2 border-solid border-blue-500 text-blue-500 px-6 py-2 mt-2 inline-block rounded">
	</form>
	<h4 class="mt-4 text-blue-400 hover:text-blue-800"><a href="<%=request.getContextPath()%>/login?guest=1">Truy cập với tư cách khách</a></h4>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous"> 
<title>Trang chủ</title>
</head>
<body>
	<div class="w-1/2 grid grid-rows-1 gap-1 justify-items-center m-auto">
        <div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
            <a href="<%=request.getContextPath()%>/employeelist" class="font-bold">XEM NHÂN VIÊN</a>
        </div>
        <c:if test="${guest == null}">
        	<div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
            	<a href="<%=request.getContextPath()%>/insertEmp" class="font-bold">THÊM NHÂN VIÊN</a>
        	</div>
        	<div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
            	<a href="<%=request.getContextPath()%>/updateEmp" class="font-bold">CẬP NHẬT THÔNG TIN NHÂN VIÊN</a>
        	</div>
        </c:if>
        <div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
            <a href="<%=request.getContextPath()%>/departmentlist" class="font-bold">XEM PHÒNG BAN</a>
        </div>
        <c:if test="${guest == null}">
        	<div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
            	<a href="<%=request.getContextPath()%>/updateDept" class="font-bold">CẬP NHẬT THÔNG TIN PHÒNG BAN</a>
        	</div>
        </c:if>
        
        <div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
            <a href="<%=request.getContextPath()%>/searchforemp" class="font-bold">TÌM KIẾM</a>
        </div>
        <c:if test="${guest == null}">
        	<div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
           		<a href="<%=request.getContextPath()%>/rmEmp" class="font-bold">XÓA THÔNG TIN NHÂN VIÊN</a>
        	</div>
        </c:if>
        <c:if test="${guest == null}">
        	<div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
           		<a href="<%=request.getContextPath()%>/rmEmp?multiple=1" class="font-bold">XÓA TẤT CẢ NHÂN VIÊN</a>
        	</div>
        </c:if>
    </div>
</body>
</html>
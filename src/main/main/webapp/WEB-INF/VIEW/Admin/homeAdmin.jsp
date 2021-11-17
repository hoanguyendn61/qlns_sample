<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw==" crossorigin="anonymous"> 
    <link rel="stylesheet" href="style.css">
    <title>Homepage</title>
</head>
<body class="">
    <div class="w-1/2 grid grid-rows-1 gap-1 justify-items-center m-auto">
        <div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
            <a href="<%=request.getContextPath()%>/employeelist" class="font-bold">QUẢN LÝ NHÂN VIÊN</a>
        </div>
        <div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
            <a href="<%=request.getContextPath()%>/departmentlist" class="font-bold">XEM PHÒNG BAN</a>
        </div>
        <div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400">
            <a href="<%=request.getContextPath()%>/searchforemp" class="font-bold">TÌM KIẾM</a>
        </div>
<!--         <div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400"> -->
<!--             <a href="#" class="font-bold">CẬP NHẬT THÔNG TIN PHÒNG BAN</a> -->
<!--         </div> -->
<!--         <div class="bg-blue-300 p-3 rounded-2xl m-2 hover:bg-blue-400"> -->
<!--             <a href="#" class="font-bold">XÓA NHÂN VIÊN</a> -->
<!--         </div> -->
    </div>
    <script src="script.js"></script>
</body>
</html>
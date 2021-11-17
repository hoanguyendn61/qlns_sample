# qlns_sample
A Simple Dynamic Web Project Sample for CNWEB and LAP TRINH MANG
<br>
Tomcat v10.10
*******************
**QUẢN LÝ NHÂN SỰ**
*******************
Xây dựng một ứng dụng web bằng JSP, SERVLET theo mô hình MVC
+ Tạo cơ sở dữ liệu có tên: DULIEU
+ Tạo các bảng: admin(username, password), nhanvien(IDNV, Hoten, IDPB, Diachi), phongban(IDPB, Tenpb, Mota)

Xây dựng ứng dụng cung cấp các chức năng của hệ thống như sau:
- 3.1 Cho phép liệt kê tất cả nhân viên của bảng nhanvien
- 3.2 Cho phép xem thông tin bảng phongban và liệt kê các nhân viên theo từng phòng ban
- 3.3 Cho phép tìm kiếm thông tin theo các tiêu chí của bảng nhanvien
- 3.4 Chèn thông tin của bảng nhanvien
- 3.5 Cho phép cập nhật thông tin của bảng phongban
- 3.6 Xoá thông tin của bảng nhanvien
- 3.7 Xoá nhiều nhân viên của bảng nhanvien

**Chú ý:** Thiết kế lại giao diện chương trình và phân quyền cho hai đối tượng người dùng
trong chương trình:
* Guest : xem và tìm kiếm thông tin
* Admin: xem, tìm kiếm, chèn, sửa, xoá thông tin

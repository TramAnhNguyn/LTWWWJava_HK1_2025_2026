<%--
  Created by IntelliJ IDEA.
  User: tranh
  Date: 23/09/2025
  Time: 10:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
  <title>Trang Điện Thoại</title>
</head>
<body>
<h2>Danh sách Điện Thoại</h2>
<table border="1" cellpadding="8" cellspacing="0">
  <tr>
    <th>Mã ĐT</th>
    <th>Tên ĐT</th>
    <th>Năm SX</th>
    <th>Cấu hình</th>
    <th>Nhà cung cấp</th>
    <th>Hình ảnh</th>
  </tr>
  <c:forEach var="dt" items="${danhSachDienThoai}">
    <tr>
      <td>${dt.maDT}</td>
      <td>${dt.tenDT}</td>
      <td>${dt.namSX}</td>
      <td>${dt.cauHinh}</td>
      <td>${dt.maNCC}</td>
      <td><img src="${dt.hinhAnh}" alt="Ảnh" width="80"></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>


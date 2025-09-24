<%--
  Created by IntelliJ IDEA.
  User: tranh
  Date: 23/09/2025
  Time: 10:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Trang Nhà Cung Cấp </title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #999;
            padding: 8px 12px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2 style="text-align: center;">Danh sách Nhà Cung Cấp</h2>

<table>
    <thead>
    <tr>
        <th>Mã NCC</th>
        <th>Tên NCC</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ncc" items="${danhSachNhaCungCap}">
        <tr>
            <td>${ncc.maNCC}</td>
            <td>${ncc.tenNCC}</td>
            <td>${ncc.diaChi}</td>
            <td>${ncc.soDienThoai}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<footer style="text-align: center; margin-top: 30px; border-top: 1px solid #ccc; padding-top: 10px;">
    <h1>Nguyen Le Tram Anh - 22716521 - Lop: DHKTPM18CTT</h1>

</footer>

</body>
</html>

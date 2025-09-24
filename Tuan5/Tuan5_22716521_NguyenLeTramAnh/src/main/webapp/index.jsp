<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            margin: 0;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }
        header {
            display: flex;
            justify-content: center; /* căn giữa logo */
            align-items: center;
            padding: 10px 20px;
            border-bottom: 1px solid #ccc;
        }
        header img {
            height: 60px;
        }
        .nav-buttons {
            margin: 20px 0;
            display: flex;
            justify-content: center;
            gap: 15px; /* khoảng cách giữa các button */
        }
        .nav-buttons button {
            padding: 8px 16px;
            border: none;
            background: none;
            color: dodgerblue;
            font-size: 14px;
            cursor: pointer;
        }
        .nav-buttons button:hover {
            text-decoration: underline;
        }
        footer {
            text-align: center;
            margin-top: auto;
            border-top: 1px solid #ccc;
            padding-top: 10px;
        }
    </style>
</head>
<body>

<header>
    <img src="img/pageImg.png" alt="Logo"/>
</header>

<!-- Menu button trong body -->
<div class="nav-buttons">
    <button onclick="window.location.href='${pageContext.request.contextPath}/nhacungcap'">
        Danh sách điện thoại
    </button>
    <button>Thêm mới sản phẩm</button>
    <button>Chức năng sản phẩm</button>
</div>

<!-- Nội dung chính -->
<main style="flex: 1; display: flex; justify-content: center; align-items: center;">
    <h2>Chào mừng đến trang quản lý sản phẩm</h2>
</main>

<footer>
    <h1>Nguyen Le Tram Anh - 22716521 - Lop: DHKTPM18CTT</h1>
</footer>

</body>
</html>

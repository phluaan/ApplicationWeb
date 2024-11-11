<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Danh sách Cafe</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f5f5f5;
    }
    .container {
        margin-top: 20px;
    }
    table {
        background-color: #fff;
        border-radius: 5px;
        overflow: hidden;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    th {
        background-color: #343a40;
        color: #fff;
    }
    select {
        width: 200px;
        margin-bottom: 15px;
    }
    .btn-link {
        color: #007bff;
        text-decoration: none;
    }
    .btn-link:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<div class="container">
    <h2 class="text-center mb-4">Danh Sách Cafe Nhập Khẩu</h2>

    <form action="/22110372_DoPhuLuan/ds" method="get" id="loc" class="mb-3">
        <div class="input-group">
            <select name="locid" class="form-select" onchange="submitForm()">
                <option value="Tất cả">Tất cả</option>
                <c:forEach var="loainc" items="${ncNhapKhau}">
                    <option value="${loainc.nuocNK_id}" ${loainc.nuocNK_id == kq ? 'selected' : ''}>${loainc.tenNuoc}</option>
                </c:forEach>
            </select>
        </div>
    </form>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Mã loại Cafe</th>
                <th>Tên Cafe</th>
                <th>Nước nhập khẩu</th>
                <th>Giá bán/kg</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${list}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item.maLoaiCF}</td>
                    <td>${item.tenCF}</td>
                    <td>${item.nuocNhapKhau.tenNuoc}</td>
                    <td>${item.giaban}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/sua?maLoaiCF=${item.maLoaiCF}" class="btn-link">Sửa</a> /
                        <a href="${pageContext.request.contextPath}/xoa?maLoaiCF=${item.maLoaiCF}" class="btn-link text-danger" onclick="return deleteConf()">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function deleteConf(){
        return confirm("Bạn có chắc muốn xóa?");
    }
    function submitForm() {
        document.getElementById("loc").submit();
    }
</script>
</body>
</html>

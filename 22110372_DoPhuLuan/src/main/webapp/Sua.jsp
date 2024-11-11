<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa Cafe</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa;
    }
    .form-container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .btn-custom {
        width: 100px;
    }
</style>
</head>
<body>

<div class="container form-container">
    <h2 class="text-center mb-4">Chỉnh sửa Cafe</h2>

    <form action="/22110372_DoPhuLuan/sua" method="post" onsubmit="return isInputEmpty()">
        <div class="mb-3">
            <label for="maCafe" class="form-label">Mã loại Cafe</label>
            <input type="text" id="maCafe" name="maLoaiCF" class="form-control" value="${item.maLoaiCF}">
        </div>

        <div class="mb-3">
            <label for="tenCF" class="form-label">Tên Cafe</label>
            <input type="text" id="tenCF" name="tenCF" class="form-control" value="${item.tenCF}">
        </div>

        <div class="mb-3">
            <label for="nuocnhapkhauId" class="form-label">Nước nhập khẩu</label>
            <select name="nuocnhapkhauId" id="nuocnhapkhauId" class="form-select">
                <c:forEach var="ncNK" items="${list}">
                    <option value="${ncNK.nuocNK_id}" ${ncNK.nuocNK_id == item.nuocNhapKhau.nuocNK_id ? 'selected' : ''}>${ncNK.tenNuoc}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="giaban" class="form-label">Giá bán/kg</label>
            <input type="text" id="giaban" name="giaban" class="form-control" value="${item.giaban}">
        </div>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary btn-custom">Lưu</button>
            <a href="/22110372_DoPhuLuan/ds" class="btn btn-secondary btn-custom">Hủy</a>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function isInputEmpty() {
        const macf = document.getElementById('maCafe').value.trim();
        const giaBan = document.getElementById('giaban').value.trim();
        const tencf = document.getElementById('tenCF').value.trim();
        if (macf === "" || giaBan === "" || tencf === "") {
            alert("Vui lòng nhập đầy đủ thông tin!");
            return false;
        }
        return true;
    }
</script>
</body>
</html>

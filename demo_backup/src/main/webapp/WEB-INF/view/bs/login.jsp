<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BootStrap</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <style>
        td {
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="container-fluid mt-3 p-3 bg-primary text-white text-center">
        <h1>My BootStrap Page</h1>
        <p>Form</p>
    </div>
    <div class="container mt-3">
        <div class="row">
            <div class="col-5">
                <h2 class="mb-4">회원 가입</h2>
                <form action="/demo/bs/login3" method="post">
                    <table class="table table-borderless">
                        <tr>
                            <td style="width: 30%;"><label class="col-form-label">User ID</label></td>
                            <td style="width: 70%;"><input type="text" name="uid" class="form-control"
                                    placeholder="Enter the user ID"></td>
                        </tr>
                        <tr>
                            <td><label class="col-form-label">패스워드</label></td>
                            <td><input type="password" name="pwd" class="form-control" placeholder="Enter the password">
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-form-label">패스워드</label></td>
                            <td><input type="password" name="rePwd" class="form-control" placeholder="Re-type the password">
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 30%;"><label class="col-form-label">Name</label></td>
                            <td style="width: 70%;"><input type="text" name="name" class="form-control"
                                    placeholder="Enter your name"></td>
                        </tr>
                        <tr>
                            <td style="width: 30%;"><label class="col-form-label">Email address</label></td>
                            <td style="width: 70%;"><input type="text" name="email" class="form-control"
                                    placeholder="Enter your email address"></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button type="submit" class="btn btn-primary">로그인</button>
                                <button type="submit" class="btn btn-secondary">취소</button>
                            </td>
                            
                        </tr>
                    </table>
                </form>
            </div>
            <div class="col-2"></div>
        </div>
    </div>
</body>

</html>
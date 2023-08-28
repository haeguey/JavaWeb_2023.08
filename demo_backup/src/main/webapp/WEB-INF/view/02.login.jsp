<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <h3>로그인 with a table</h3>
    <form action="/demo/login" method="post">
        <table>
            <tr>
                <td style="text-align: left;">ID:</td>
                <td><input type="text" name="uid"></td>
            </tr>
            <tr>
                <td style="text-align: left;">Password:</td>
                <td><input type="text" name="pwd"></td>
            </tr>
            <tr>
                <td colspan=2>
                    <input type="submit" value="확인">
                    <input type="reset" value="취소">  
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
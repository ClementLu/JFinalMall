<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
    <form action="#(ctx)/action/registerHandler" method="post">
    
        <table style="margin: 0 auto; width: 300px;">
            <tr>
                <td colspan="2">用户注册</td>
            </tr>

            <tr>
                <td>用户名</td>
                <td><input type="text" name="name" id="email" /></td>
            </tr>

            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email" id="email" /></td>
            </tr>

            <tr>
                <td>密码</td>
                <td><input 
                    type="password"  
                    value="" 
                    style="width:180px" 
                    name="password" 
                    class="inputxt"
                    id="password" 
                    required/></td>
            </tr>

            <tr>
                <td>确认密码</td>
                <td><input 
                    type="password" 
                    value=""
                    class="inputxt" 
                    id="repassword" 
                    required="" 
                    style="width:180px" /></td>
            </tr>

            <tr>
                <td colspan="2">
                    <button 
                        id="login"
                        type="submit" style="width: 200px"
                        onclick="return insertManager()">下一步</button>
                    <button 
                        type="reset" style="width: 200px">重置</button>
                </td>
            </tr>

        </table>
    </form>
    <script type = "text/javascript" >
    function insertManager() {
        var password = document.getElementById("password").value;
        var repassword = document.getElementById("repassword").value;
        if (password != repassword) {
            window.alert("您输入的新密码与确认密码确认不一致");
            signupForm.repassword.focus();
            return false;
        }
        return true;
    } </script>

</body>
</html>
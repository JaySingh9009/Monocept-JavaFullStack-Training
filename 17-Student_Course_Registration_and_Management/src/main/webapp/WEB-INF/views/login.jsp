<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: Arial, Helvetica, sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background: linear-gradient(135deg, #2563eb, #1e3a8a);
    overflow:hidden;
}

/* Background Glow Effects */
body::before,
body::after{
    content:"";
    position:absolute;
    width:300px;
    height:300px;
    border-radius:50%;
    background:rgba(255,255,255,0.08);
    z-index:0;
}

body::before{
    top:-100px;
    left:-80px;
}

body::after{
    bottom:-120px;
    right:-80px;
}

/* Login Wrapper */
.login-wrapper{
    width:100%;
    padding:20px;
    display:flex;
    justify-content:center;
    align-items:center;
    position:relative;
    z-index:1;
}

/* Login Box */
.login-box{
    width:100%;
    max-width:420px;
    background:white;
    padding:40px 35px;
    border-radius:22px;
    box-shadow:0 15px 35px rgba(0,0,0,0.25);
    animation:fadeIn 0.5s ease;
}

/* Heading */
.login-box h2{
    text-align:center;
    color:#1e293b;
    font-size:32px;
    margin-bottom:10px;
}

/* Subtitle */
.subtitle{
    text-align:center;
    color:#64748b;
    margin-bottom:25px;
    font-size:15px;
}

/* Labels */
label{
    display:block;
    margin-bottom:6px;
    margin-top:15px;
    color:#334155;
    font-weight:bold;
}

/* Inputs */
input[type="text"],
input[type="password"]{
    width:100%;
    padding:13px;
    border:1px solid #cbd5e1;
    border-radius:12px;
    outline:none;
    font-size:15px;
    transition:0.3s;
    background:#f8fafc;
}

input[type="text"]:focus,
input[type="password"]:focus{
    border-color:#2563eb;
    background:white;
    box-shadow:0 0 8px rgba(37,99,235,0.2);
}

/* Remember Row */
.remember-row{
    display:flex;
    align-items:center;
    gap:8px;
    margin-top:18px;
}

.remember-row input{
    width:16px;
    height:16px;
    cursor:pointer;
}

.remember-row label{
    margin:0;
    font-size:14px;
    color:#475569;
    cursor:pointer;
}

/* Button */
button{
    width:100%;
    padding:13px;
    margin-top:25px;
    border:none;
    border-radius:12px;
    background:#2563eb;
    color:white;
    font-size:16px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    background:#1d4ed8;
    transform:translateY(-2px);
}

/* Error Box */
.alert-error{
    background:#fee2e2;
    color:#b91c1c;
    padding:12px;
    border-radius:10px;
    border:1px solid #fecaca;
    margin-bottom:15px;
    text-align:center;
}

/* Animation */
@keyframes fadeIn{
    from{
        opacity:0;
        transform:translateY(20px);
    }
    to{
        opacity:1;
        transform:translateY(0);
    }
}

/* Responsive */
@media(max-width:500px){

    .login-box{
        padding:30px 22px;
    }

    .login-box h2{
        font-size:26px;
    }
}

</style>

</head>

<body>

<div class="login-wrapper">

    <div class="login-box">

        <h2>Admin Login</h2>

        <p class="subtitle">
            Student Course Management System
        </p>

        <%
        String error = (String) request.getAttribute("errorMsg");
        if(error != null){
        %>

            <div class="alert-error">
                <%= error %>
            </div>

        <%
        }
        %>

        <form action="${pageContext.request.contextPath}/login-action"
              method="post">

            <!-- Username -->
            <label for="username">Username</label>

            <input type="text"
                   id="username"
                   name="username"
                   placeholder="Enter username"

                   value="<%=request.getAttribute("rememberedUsername") != null ? request.getAttribute("rememberedUsername") : ""%>"

                   required>

            <!-- Password -->
            <label for="password">Password</label>

            <input type="password"
                   id="password"
                   name="password"
                   placeholder="Enter password"
                   required>

            <!-- Remember Me -->
            <div class="remember-row">

                <input type="checkbox"
                       id="rememberMe"
                       name="rememberMe"

                       <%=(request.getAttribute("rememberedUsername") != null
                       && !request.getAttribute("rememberedUsername").toString().isEmpty())
                       ? "checked" : ""%>>

                <label for="rememberMe">
                    Remember my username
                </label>

            </div>

            <!-- Login Button -->
            <button type="submit">
                Login
            </button>

        </form>

    </div>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: Arial, Helvetica, sans-serif;
}

body{
    background: linear-gradient(135deg, #eef2ff, #dbeafe);
    min-height:100vh;
}

/* Main Container */
.container{
    display:flex;
    justify-content:center;
    align-items:center;
    min-height:90vh;
    padding:20px;
}

/* Error Card */
.error-box{
    width:100%;
    max-width:500px;
    background:white;
    padding:40px 35px;
    border-radius:22px;
    text-align:center;
    box-shadow:0 15px 30px rgba(0,0,0,0.1);
    animation:fadeIn 0.5s ease;
}

/* Error Icon Circle */
.error-icon{
    width:90px;
    height:90px;
    margin:0 auto 20px;
    border-radius:50%;
    background:#fee2e2;
    display:flex;
    justify-content:center;
    align-items:center;
    font-size:42px;
    color:#dc2626;
    font-weight:bold;
}

/* Heading */
.error-box h2{
    font-size:30px;
    color:#1e293b;
    margin-bottom:15px;
}

/* Error Message */
.alert-error{
    background:#fff1f2;
    color:#b91c1c;
    padding:16px;
    border-radius:12px;
    border:1px solid #fecdd3;
    margin-bottom:25px;
    line-height:1.6;
    font-size:16px;
}

/* Back Button */
.back-link{
    display:inline-block;
    text-decoration:none;
    background:#2563eb;
    color:white;
    padding:12px 22px;
    border-radius:10px;
    font-weight:bold;
    transition:0.3s;
}

.back-link:hover{
    background:#1d4ed8;
    transform:translateY(-2px);
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
@media(max-width:600px){

    .error-box{
        padding:30px 20px;
    }

    .error-box h2{
        font-size:24px;
    }

    .alert-error{
        font-size:15px;
    }
}

</style>

</head>

<body>

<%@ include file="navbar.jsp"%>

<div class="container">

    <div class="error-box">

        <!-- Error Icon -->
        <div class="error-icon">
            !
        </div>

        <!-- Heading -->
        <h2>Something Went Wrong</h2>

        <!-- Error Message -->
        <div class="alert-error">

            <%
            String msg = (String) request.getAttribute("errorMsg");
            %>

            <%= msg != null ? msg : "An unexpected error occurred." %>

        </div>

        <!-- Back Button -->
        <a class="back-link"
           href="${pageContext.request.contextPath}/dashboard">

           ← Go to Dashboard

        </a>

    </div>

</div>

</body>
</html>
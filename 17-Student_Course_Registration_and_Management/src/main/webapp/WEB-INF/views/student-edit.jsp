<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.studentcourse.model.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>

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
    width:100%;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:40px 15px;
}

/* Form Box */
.form-box{
    width:100%;
    max-width:550px;
    background:white;
    padding:35px;
    border-radius:20px;
    box-shadow:0 10px 25px rgba(0,0,0,0.1);
    animation:fadeIn 0.5s ease;
}

/* Heading */
h2{
    text-align:center;
    margin-bottom:25px;
    color:#1e293b;
    font-size:30px;
}

/* Labels */
label{
    display:block;
    margin-top:16px;
    margin-bottom:6px;
    font-weight:bold;
    color:#334155;
}

/* Inputs */
input{
    width:100%;
    padding:12px;
    border:1px solid #cbd5e1;
    border-radius:10px;
    outline:none;
    font-size:15px;
    background:#f8fafc;
    transition:0.3s;
}

input:focus{
    border-color:#2563eb;
    background:white;
    box-shadow:0 0 8px rgba(37,99,235,0.2);
}

/* Submit Button */
.btn-submit{
    width:100%;
    margin-top:25px;
    padding:13px;
    border:none;
    border-radius:10px;
    background:#2563eb;
    color:white;
    font-size:16px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s;
}

.btn-submit:hover{
    background:#1d4ed8;
    transform:translateY(-2px);
}

/* Back Link */
.back-link{
    display:block;
    text-align:center;
    margin-top:18px;
    text-decoration:none;
    color:#2563eb;
    font-weight:bold;
    transition:0.3s;
}

.back-link:hover{
    color:#1e40af;
}

/* Error Message */
.alert-error{
    background:#fee2e2;
    color:#b91c1c;
    padding:12px;
    border-radius:10px;
    margin-bottom:15px;
    border:1px solid #fecaca;
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
@media(max-width:600px){

    .form-box{
        padding:25px 20px;
    }

    h2{
        font-size:24px;
    }
}

</style>

</head>

<body>

<%@ include file="navbar.jsp"%>

<div class="container">

    <div class="form-box">

        <h2>Edit Student</h2>

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

        <%
        Student s = (Student) request.getAttribute("student");
        %>

        <form action="${pageContext.request.contextPath}/student/update"
              method="post">

            <!-- Hidden ID -->
            <input type="hidden"
                   name="studentId"
                   value="<%= s.getStudentId() %>">

            <!-- Student Name -->
            <label>Student Name</label>

            <input type="text"
                   name="studentName"
                   value="<%= s.getStudentName() %>"
                   required>

            <!-- Email -->
            <label>Email</label>

            <input type="email"
                   name="email"
                   value="<%= s.getEmail() %>"
                   required>

            <!-- Phone -->
            <label>Phone</label>

            <input type="text"
                   name="phone"
                   value="<%= s.getPhone() %>"
                   required>

            <!-- Age -->
            <label>Age</label>

            <input type="number"
                   name="age"
                   value="<%= s.getAge() %>"
                   required>

            <!-- City -->
            <label>City</label>

            <input type="text"
                   name="city"
                   value="<%= s.getCity() %>"
                   required>

            <!-- Submit Button -->
            <button class="btn-submit" type="submit">
                Update Student
            </button>

            <!-- Back Link -->
            <a class="back-link"
               href="${pageContext.request.contextPath}/students">

               ← Back

            </a>

        </form>

    </div>

</div>

</body>
</html>
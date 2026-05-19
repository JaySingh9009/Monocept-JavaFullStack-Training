<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

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
    padding:40px 20px;
}

/* Welcome Box */
.welcome-box{
    background: linear-gradient(135deg, #2563eb, #1e40af);
    color:white;
    padding:30px;
    border-radius:20px;
    margin-bottom:30px;
    box-shadow:0 10px 25px rgba(0,0,0,0.15);
    animation:fadeIn 0.5s ease;
}

.welcome-box h3{
    font-size:30px;
    margin-bottom:10px;
}

.welcome-box p{
    font-size:16px;
    opacity:0.9;
}

/* Section Headings */
h2{
    margin-bottom:20px;
    color:#1e293b;
    font-size:28px;
}

/* Cards Row */
.card-row{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(220px,1fr));
    gap:20px;
    margin-bottom:40px;
}

/* Dashboard Cards */
.card{
    background:white;
    padding:30px;
    border-radius:18px;
    text-align:center;
    box-shadow:0 10px 20px rgba(0,0,0,0.08);
    transition:0.3s;
    animation:fadeIn 0.5s ease;
}

.card:hover{
    transform:translateY(-5px);
    box-shadow:0 15px 25px rgba(0,0,0,0.12);
}

.card-number{
    font-size:42px;
    font-weight:bold;
    color:#2563eb;
    margin-bottom:10px;
}

.card-label{
    font-size:18px;
    color:#475569;
}

/* Quick Links */
.quick-links{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(220px,1fr));
    gap:18px;
}

/* Navigation Buttons */
.quick-links a{
    text-decoration:none;
    background:white;
    color:#1e293b;
    padding:18px;
    border-radius:14px;
    text-align:center;
    font-weight:bold;
    box-shadow:0 8px 18px rgba(0,0,0,0.08);
    transition:0.3s;
    border:2px solid transparent;
}

.quick-links a:hover{
    background:#2563eb;
    color:white;
    transform:translateY(-4px);
    border-color:#1d4ed8;
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
@media(max-width:768px){

    .welcome-box h3{
        font-size:24px;
    }

    h2{
        font-size:24px;
    }

    .card-number{
        font-size:34px;
    }
}

</style>

</head>

<body>

<%@ include file="navbar.jsp"%>

<div class="container">

    <!-- Welcome Section -->
    <div class="welcome-box">

        <h3>
            Welcome,
            <%= session.getAttribute("loggedInUser") %> !
        </h3>

        <p>
            Here is a quick summary of your Student Course Management System.
        </p>

    </div>

    <!-- Dashboard Stats -->
    <h2>Dashboard Overview</h2>

    <div class="card-row">

        <div class="card">

            <div class="card-number">
                ${totalStudents}
            </div>

            <div class="card-label">
                Total Students
            </div>

        </div>

        <div class="card">

            <div class="card-number">
                ${totalCourses}
            </div>

            <div class="card-label">
                Total Courses
            </div>

        </div>

        <div class="card">

            <div class="card-number">
                ${totalRegistrations}
            </div>

            <div class="card-label">
                Total Registrations
            </div>

        </div>

    </div>

    <!-- Quick Navigation -->
    <h2>Quick Navigation</h2>

    <div class="quick-links">

        <a href="${pageContext.request.contextPath}/students">
            View Students
        </a>

        <a href="${pageContext.request.contextPath}/student/add">
            Add Student
        </a>

        <a href="${pageContext.request.contextPath}/courses">
            View Courses
        </a>

        <a href="${pageContext.request.contextPath}/course/add">
            Add Course
        </a>

        <a href="${pageContext.request.contextPath}/registrations">
            View Registrations
        </a>

        <a href="${pageContext.request.contextPath}/registration/add">
            Register Student
        </a>

    </div>

</div>

</body>
</html>
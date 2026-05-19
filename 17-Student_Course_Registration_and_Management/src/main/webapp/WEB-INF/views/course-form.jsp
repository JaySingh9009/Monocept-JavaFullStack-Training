<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>

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

/* Form Card */
.form-box{
    width:100%;
    max-width:520px;
    background:#fff;
    padding:35px;
    border-radius:18px;
    box-shadow:0 10px 25px rgba(0,0,0,0.1);
    animation:fadeIn 0.5s ease;
}

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

h2{
    text-align:center;
    margin-bottom:25px;
    color:#1e293b;
    font-size:28px;
}

/* Labels */
label{
    display:block;
    margin-top:15px;
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
    transition:0.3s;
    background:#f8fafc;
}

input:focus{
    border-color:#2563eb;
    box-shadow:0 0 8px rgba(37,99,235,0.2);
    background:white;
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

/* Error Box */
.alert-error{
    background:#fee2e2;
    color:#b91c1c;
    padding:12px;
    border-radius:10px;
    margin-bottom:15px;
    border:1px solid #fecaca;
    text-align:center;
}

</style>

</head>
<body>

<%@ include file="navbar.jsp"%>

<div class="container">

    <div class="form-box">

        <h2>Add New Course</h2>

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

        <form action="${pageContext.request.contextPath}/course/add"
              method="post">

            <label>Course Name</label>
            <input type="text"
                   name="courseName"
                   placeholder="e.g. Java Full Stack"
                   value="<%=request.getAttribute("courseName") != null ? request.getAttribute("courseName") : ""%>"
                   required>

            <label>Duration (in Months)</label>
            <input type="number"
                   name="duration"
                   placeholder="e.g. 3"
                   min="1"
                   value="<%=request.getAttribute("duration") != null ? request.getAttribute("duration") : ""%>"
                   required>

            <label>Fees (must be greater than 0)</label>
            <input type="number"
                   name="fees"
                   placeholder="e.g. 15000"
                   step="0.01"
                   value="<%=request.getAttribute("fees") != null ? request.getAttribute("fees") : ""%>"
                   required>

            <label>Trainer Name</label>
            <input type="text"
                   name="trainerName"
                   placeholder="e.g. Mr. Ramesh Kumar"
                   value="<%=request.getAttribute("trainerName") != null ? request.getAttribute("trainerName") : ""%>"
                   required>

            <button class="btn-submit" type="submit">
                Add Course
            </button>

            <a class="back-link"
               href="${pageContext.request.contextPath}/courses">
               ← Back to Courses
            </a>

        </form>

    </div>

</div>

</body>
</html>
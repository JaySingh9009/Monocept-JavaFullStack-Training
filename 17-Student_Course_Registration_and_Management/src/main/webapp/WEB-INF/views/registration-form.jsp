<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="java.util.List, java.time.LocalDate, com.studentcourse.model.Student, com.studentcourse.model.Course"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Student</title>

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
    max-width:550px;
    background:#fff;
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

/* Inputs and Select */
input,
select{
    width:100%;
    padding:12px;
    border:1px solid #cbd5e1;
    border-radius:10px;
    outline:none;
    font-size:15px;
    background:#f8fafc;
    transition:0.3s;
}

input:focus,
select:focus{
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

        <h2>Register Student for a Course</h2>

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

        <form action="${pageContext.request.contextPath}/registration/add"
              method="post">

            <!-- Student Selection -->
            <label>Select Student</label>

            <select name="studentId" required>

                <option value="">
                    -- Select a Student --
                </option>

                <%
                List<Student> studentList =
                (List<Student>) request.getAttribute("studentList");

                if(studentList != null){

                    for(Student s : studentList){
                %>

                    <option value="<%= s.getStudentId() %>">
                        <%= s.getStudentName() %>
                    </option>

                <%
                    }
                }
                %>

            </select>

            <!-- Course Selection -->
            <label>Select Course</label>

            <select name="courseId" required>

                <option value="">
                    -- Select a Course --
                </option>

                <%
                List<Course> courseList =
                (List<Course>) request.getAttribute("courseList");

                if(courseList != null){

                    for(Course c : courseList){
                %>

                    <option value="<%= c.getCourseId() %>">
                        <%= c.getCourseName() %>
                    </option>

                <%
                    }
                }
                %>

            </select>

            <!-- Registration Date -->
            <label>Registration Date</label>

            <input type="date"
                   name="registrationDate"
                   max="<%= LocalDate.now().toString() %>"
                   required>

            <!-- Status -->
            <label>Status</label>

            <select name="status" required>

                <option value="">
                    -- Select Status --
                </option>

                <option value="Active">
                    Active
                </option>

                <option value="Completed">
                    Completed
                </option>

                <option value="Cancelled">
                    Cancelled
                </option>

            </select>

            <!-- Submit Button -->
            <button class="btn-submit" type="submit">
                Register
            </button>

            <!-- Back Link -->
            <a class="back-link"
               href="${pageContext.request.contextPath}/registrations">

               ← Back

            </a>

        </form>

    </div>

</div>

</body>
</html>
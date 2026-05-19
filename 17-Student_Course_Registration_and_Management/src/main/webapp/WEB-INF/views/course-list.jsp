<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Course"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course List</title>

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
    padding:40px 20px;
}

/* Heading */
h2{
    text-align:center;
    margin-bottom:25px;
    color:#1e293b;
    font-size:32px;
}

/* Table Card */
.table-box{
    background:#fff;
    border-radius:18px;
    padding:25px;
    box-shadow:0 10px 25px rgba(0,0,0,0.1);
    overflow-x:auto;
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

/* Top Bar */
.table-top{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:20px;
    flex-wrap:wrap;
    gap:10px;
}

.table-top span{
    font-size:20px;
    color:#334155;
}

/* Add Button */
.btn-add{
    background:#2563eb;
    color:white;
    padding:10px 18px;
    border-radius:10px;
    text-decoration:none;
    font-weight:bold;
    transition:0.3s;
}

.btn-add:hover{
    background:#1d4ed8;
    transform:translateY(-2px);
}

/* Table */
table{
    width:100%;
    border-collapse:collapse;
    overflow:hidden;
    border-radius:12px;
}

th{
    background:#2563eb;
    color:white;
    padding:14px;
    text-align:left;
    font-size:15px;
}

td{
    padding:14px;
    border-bottom:1px solid #e2e8f0;
    color:#334155;
}

/* Hover Effect */
tr:hover{
    background:#f8fafc;
}

/* Action Buttons */
.btn-edit,
.btn-delete{
    padding:8px 14px;
    border-radius:8px;
    text-decoration:none;
    font-size:14px;
    font-weight:bold;
    transition:0.3s;
    display:inline-block;
}

.btn-edit{
    background:#facc15;
    color:#000;
    margin-right:8px;
}

.btn-edit:hover{
    background:#eab308;
}

.btn-delete{
    background:#ef4444;
    color:white;
}

.btn-delete:hover{
    background:#dc2626;
}

/* Error Box */
.alert-error{
    background:#fee2e2;
    color:#b91c1c;
    padding:12px;
    border-radius:10px;
    margin-bottom:20px;
    border:1px solid #fecaca;
    text-align:center;
}

/* Empty Row */
.empty-row{
    text-align:center;
    color:#64748b;
    padding:25px;
    font-size:16px;
}

/* Responsive */
@media(max-width:768px){

    table{
        min-width:700px;
    }

    .table-top{
        flex-direction:column;
        align-items:flex-start;
    }
}

</style>

</head>

<body>

<%@ include file="navbar.jsp"%>

<div class="container">

    <h2>All Courses</h2>

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

    <div class="table-box">

        <div class="table-top">
            <span><strong>Course Records</strong></span>

            <a class="btn-add"
               href="${pageContext.request.contextPath}/course/add">
               + Add Course
            </a>
        </div>

        <table>

            <tr>
                <th>ID</th>
                <th>Course Name</th>
                <th>Duration</th>
                <th>Fees</th>
                <th>Trainer</th>
                <th>Actions</th>
            </tr>

            <%
            List<Course> list =
            (List<Course>) request.getAttribute("courseList");

            if(list != null && !list.isEmpty()){

                for(Course c : list){
            %>

            <tr>

                <td><%= c.getCourseId() %></td>

                <td><%= c.getCourseName() %></td>

                <td><%= c.getDuration() %></td>

                <td>
                    &#8377; <%= c.getFees() %>
                </td>

                <td><%= c.getTrainerName() %></td>

                <td>

                    <a class="btn-edit"
                       href="${pageContext.request.contextPath}/course/edit?id=<%= c.getCourseId() %>">
                       Edit
                    </a>

                    <a class="btn-delete"
                       href="${pageContext.request.contextPath}/course/delete?id=<%= c.getCourseId() %>"
                       onclick="return confirm('Delete this course?')">
                       Delete
                    </a>

                </td>

            </tr>

            <%
                }

            } else {
            %>

            <tr>
                <td colspan="6" class="empty-row">
                    No courses found.
                </td>
            </tr>

            <%
            }
            %>

        </table>

    </div>

</div>

</body>
</html>
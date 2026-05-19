<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.studentcourse.model.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>

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

/* Heading */
h2{
    text-align:center;
    margin-bottom:25px;
    color:#1e293b;
    font-size:32px;
}

/* Table Card */
.table-box{
    background:white;
    border-radius:18px;
    padding:25px;
    box-shadow:0 10px 25px rgba(0,0,0,0.1);
    overflow-x:auto;
    animation:fadeIn 0.5s ease;
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

/* Error Message */
.alert-error{
    background:#fee2e2;
    color:#b91c1c;
    padding:12px;
    border-radius:10px;
    margin-bottom:20px;
    border:1px solid #fecaca;
    text-align:center;
}

/* Empty Table Row */
.empty-row{
    text-align:center;
    color:#64748b;
    padding:25px;
    font-size:16px;
}

/* Responsive */
@media(max-width:768px){

    table{
        min-width:850px;
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

    <h2>All Students</h2>

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

        <!-- Top Bar -->
        <div class="table-top">

            <span>
                <strong>Student Records</strong>
            </span>

            <a class="btn-add"
               href="${pageContext.request.contextPath}/student/add">

               + Add Student

            </a>

        </div>

        <!-- Table -->
        <table>

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Age</th>
                <th>City</th>
                <th>Actions</th>
            </tr>

            <%
            List<Student> list =
            (List<Student>) request.getAttribute("studentList");

            if(list != null && !list.isEmpty()){

                for(Student s : list){
            %>

            <tr>

                <td><%= s.getStudentId() %></td>

                <td><%= s.getStudentName() %></td>

                <td><%= s.getEmail() %></td>

                <td><%= s.getPhone() %></td>

                <td><%= s.getAge() %></td>

                <td><%= s.getCity() %></td>

                <td>

                    <!-- Edit Button -->
                    <a class="btn-edit"
                       href="${pageContext.request.contextPath}/student/edit?id=<%= s.getStudentId() %>">

                       Edit

                    </a>

                    <!-- Delete Button -->
                    <a class="btn-delete"
                       href="${pageContext.request.contextPath}/student/delete?id=<%= s.getStudentId() %>"

                       onclick="return confirm('Delete this student?')">

                       Delete

                    </a>

                </td>

            </tr>

            <%
                }

            } else {
            %>

            <tr>

                <td colspan="7" class="empty-row">

                    No students found.

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
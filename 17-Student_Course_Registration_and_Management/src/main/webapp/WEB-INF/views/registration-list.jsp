<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.studentcourse.model.Registration"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrations</title>

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

/* Table Box */
.table-box{
    background:white;
    border-radius:18px;
    padding:25px;
    box-shadow:0 10px 25px rgba(0,0,0,0.1);
    overflow-x:auto;
    animation:fadeIn 0.5s ease;
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
    border-radius:12px;
    overflow:hidden;
}

th{
    background:#2563eb;
    color:white;
    padding:14px;
    text-align:left;
}

td{
    padding:14px;
    border-bottom:1px solid #e2e8f0;
    color:#334155;
}

tr:hover{
    background:#f8fafc;
}

/* Status Badges */
.badge{
    padding:6px 12px;
    border-radius:20px;
    font-size:13px;
    font-weight:bold;
    display:inline-block;
}

.badge-active{
    background:#dcfce7;
    color:#166534;
}

.badge-completed{
    background:#dbeafe;
    color:#1d4ed8;
}

.badge-cancelled{
    background:#fee2e2;
    color:#b91c1c;
}

/* Status Form */
.status-form{
    display:flex;
    gap:8px;
    align-items:center;
}

.status-form select{
    padding:8px;
    border-radius:8px;
    border:1px solid #cbd5e1;
    outline:none;
    background:#f8fafc;
}

.status-form select:focus{
    border-color:#2563eb;
}

/* Save Button */
.status-form button{
    padding:8px 14px;
    border:none;
    border-radius:8px;
    background:#10b981;
    color:white;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s;
}

.status-form button:hover{
    background:#059669;
}

/* Delete Button */
.btn-delete{
    background:#ef4444;
    color:white;
    padding:8px 14px;
    border-radius:8px;
    text-decoration:none;
    font-size:14px;
    font-weight:bold;
    transition:0.3s;
    display:inline-block;
}

.btn-delete:hover{
    background:#dc2626;
}

/* Empty Row */
.empty-row{
    text-align:center;
    color:#64748b;
    padding:25px;
    font-size:16px;
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
@media(max-width:900px){

    table{
        min-width:900px;
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

    <h2>All Registrations</h2>

    <div class="table-box">

        <!-- Top Bar -->
        <div class="table-top">

            <span>
                <strong>Registration Records</strong>
            </span>

            <a class="btn-add"
               href="${pageContext.request.contextPath}/registration/add">

               + Register Student

            </a>

        </div>

        <!-- Table -->
        <table>

            <tr>
                <th>ID</th>
                <th>Student</th>
                <th>Course</th>
                <th>Date</th>
                <th>Status</th>
                <th>Update Status</th>
                <th>Delete</th>
            </tr>

            <%
            List<Registration> regList =
            (List<Registration>) request.getAttribute("registrationList");

            if(regList != null && !regList.isEmpty()){

                for(Registration r : regList){

                    String badgeClass = "badge-active";

                    if("Completed".equals(r.getStatus()))
                        badgeClass = "badge-completed";

                    if("Cancelled".equals(r.getStatus()))
                        badgeClass = "badge-cancelled";
            %>

            <tr>

                <td><%= r.getRegistrationId() %></td>

                <td><%= r.getStudentName() %></td>

                <td><%= r.getCourseName() %></td>

                <td><%= r.getRegistrationDate() %></td>

                <!-- Status Badge -->
                <td>

                    <span class="badge <%= badgeClass %>">
                        <%= r.getStatus() %>
                    </span>

                </td>

                <!-- Update Form -->
                <td>

                    <form class="status-form"
                          action="${pageContext.request.contextPath}/registration/status"
                          method="post">

                        <input type="hidden"
                               name="registrationId"
                               value="<%= r.getRegistrationId() %>">

                        <select name="status">

                            <option value="Active"
                                <%="Active".equals(r.getStatus()) ? "selected" : ""%>>

                                Active

                            </option>

                            <option value="Completed"
                                <%="Completed".equals(r.getStatus()) ? "selected" : ""%>>

                                Completed

                            </option>

                            <option value="Cancelled"
                                <%="Cancelled".equals(r.getStatus()) ? "selected" : ""%>>

                                Cancelled

                            </option>

                        </select>

                        <button type="submit">
                            Save
                        </button>

                    </form>

                </td>

                <!-- Delete Button -->
                <td>

                    <a class="btn-delete"
                       href="${pageContext.request.contextPath}/registration/delete?id=<%= r.getRegistrationId() %>"

                       onclick="return confirm('Delete this registration?')">

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

                    No registrations found.

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
<nav class="navbar">

    <!-- Logo / Brand -->
    <a class="brand"
       href="${pageContext.request.contextPath}/dashboard">

       StudentCourse

    </a>

    <!-- Navigation Links -->
    <div class="nav-links">

        <a href="${pageContext.request.contextPath}/dashboard">
            Dashboard
        </a>

        <a href="${pageContext.request.contextPath}/students">
            Students
        </a>

        <a href="${pageContext.request.contextPath}/courses">
            Courses
        </a>

        <a href="${pageContext.request.contextPath}/registrations">
            Registrations
        </a>

        <a href="${pageContext.request.contextPath}/logout"
           class="logout">

           Logout

        </a>

    </div>

</nav>

<style>

/* Navbar */
.navbar{
    width:100%;
    background: linear-gradient(135deg, #1e3a8a, #2563eb);
    padding:16px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    box-shadow:0 4px 12px rgba(0,0,0,0.15);
    position:sticky;
    top:0;
    z-index:1000;
}

/* Brand */
.brand{
    color:white;
    text-decoration:none;
    font-size:28px;
    font-weight:bold;
    letter-spacing:0.5px;
    transition:0.3s;
}

.brand:hover{
    transform:scale(1.03);
}

/* Navigation Links */
.nav-links{
    display:flex;
    align-items:center;
    gap:14px;
}

/* Links */
.nav-links a{
    text-decoration:none;
    color:white;
    padding:10px 16px;
    border-radius:10px;
    font-size:15px;
    font-weight:600;
    transition:0.3s;
}

/* Hover Effect */
.nav-links a:hover{
    background:rgba(255,255,255,0.15);
    backdrop-filter:blur(5px);
}

/* Logout Button */
.logout{
    background:#ef4444;
}

.logout:hover{
    background:#dc2626 !important;
}

/* Responsive Navbar */
@media(max-width:768px){

    .navbar{
        flex-direction:column;
        gap:15px;
        padding:20px;
    }

    .nav-links{
        flex-wrap:wrap;
        justify-content:center;
    }

    .brand{
        font-size:24px;
    }
}

</style>
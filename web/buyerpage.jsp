<%
    //scriptlets (used for writing java code in jsp file)
    String email=(String)session.getAttribute("id");
    if(email==null){
        response.sendRedirect("index.jsp");
    }
%>


<html>
    <body>
        <h3>Welcome <%=email%></h3>
        <h3>BUYER-DASHBOARD</h3>
        <hr>
        <pre>
            <a href="CategoryServlet">Explore-Store</a>
            <a href="DisplayCart">View-Cart</a>
            <a href="index.jsp">Logout</a>
        </pre>
        <hr>
    </body>
</html>

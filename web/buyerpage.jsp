<%
    int n=session.getMaxInactiveInterval();
    String id=session.getId();
    long val=session.getCreationTime();
    java.util.Date dt=new java.util.Date(val);
    //scriptlets (used for writing java code in jsp file)
    String email=(String)session.getAttribute("id");
    if(email==null){
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <body>
        <h3>Welcome <%=email%></h3>
        <h4>You are with us since <%=dt%> </h4>
        <h5>If you remain idle for <%=n%> seconds, your session will expire</h5>
        <h3>BUYER-DASHBOARD</h3>
        <hr>
        <pre>
            <a href="CategoryServlet">Explore-Store</a>
            <a href="DisplayCart">View-Cart</a>
            <a href="KillSession">Logout</a>
        </pre>
        <hr>
    </body>
</html>

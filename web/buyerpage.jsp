<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="sample" %>
<%@include file="info.jsp" %>
<%--
    its a jsp comment
--%>
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
        <sample:welcome/>
        <h3>Welcome <%=email%></h3>
<!--        <h4>You are with us since <%=dt%> </h4>
        <h5>If you remain idle for <%=n%> seconds, your session will expire</h5>-->
        <h3>BUYER-DASHBOARD</h3>
        <hr>
        <pre>
            <a href="viewprices.jsp">Price-List</a>
            <a href="search.jsp">Search-Product-By-Code</a>
            <a href="discount.jsp">Know-Your-Discount</a>
            <a href="CategoryServlet">Explore-Store</a>
            <a href="DisplayCart">View-Cart</a>
            <a href="KillSession">Logout</a>
        </pre>
        <hr>
    </body>
</html>

<%@page  isELIgnored="true" %>
<%@page  session="true" language="java" import="java.sql.*"%>
<%@page  contentType="text/html" import="java.util.Stack"  %>
<%@page  import="java.sql.Connection" %>

<%
    Stack stk;
    Class.forName("com.mysql.jdbc.Driver"); //ClassNotFoundException
 %>
<html>
    <body>
        <h1>Welcome From Test Page 1</h1>
        <%=session.getAttribute("id")%><br>
        
        Your Total Amount ${560}
    </body>
</html>
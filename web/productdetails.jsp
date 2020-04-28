<%@page errorPage="myerrorpage.jsp" %>
<%@include  file="info.jsp"%>
<%!
    private int x;
%>

<%!
    int discount(int price){
        if(price<10000){
            return price*10/100;
        }else{
            return price*20/100;
        }
    }
%>

<%
    int y;
    //client request read
    int code=Integer.parseInt(request.getParameter("code"));
    //fetch the data from DB
    String sql="SELECT * FROM PRODUCTS WHERE pcode=?";
    //java.sql.Connection con=mypkg.Data.connect();
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/ecomdb";
    java.sql.Connection con=java.sql.DriverManager.getConnection(url, "root", "root");
    java.sql.PreparedStatement ps=con.prepareStatement(sql);
    ps.setInt(1, code);
    java.sql.ResultSet rs=ps.executeQuery();
    boolean found=rs.next();
    String pcode=rs.getString(1);
    String name=rs.getString(2);
    String desc=rs.getString(3);
    String catg=rs.getString(4);
    int price=rs.getInt(5);
    int dis=discount(price);
%>
<html>
    <body>
        <h3>Product-Details</h3>
        <hr>
        <table border="2">
            <tr>
                <td>Code</td>
                <td><%=pcode%></td>
            </tr>
            <tr>
                <td>PName</td>
                <td><%=name%></td>
            </tr>
            <tr>
                <td>Desc</td>
                <td><%=desc%></td>
            </tr>
            <tr>
                <td>Catg</td>
                <td><%=catg%></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><%=rs.getString(5)%></td>
            </tr>
            <tr>
                <td>Discount</td>
                <td><%=dis%></td>
            </tr>
        </table>
        <hr>
        <a href="search.jsp">Search-More</a><br>
        <a href="buyerpage.jsp">Buyer-Page</a>
    </body>
</html>
<%
    con.close();
%>
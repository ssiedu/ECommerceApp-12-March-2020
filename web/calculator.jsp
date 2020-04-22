<%
  //reading the request parameters
  String s=request.getParameter("amount");
  //processing (compute the discount amount)
  int amount=Integer.parseInt(s);
  int discount=0;
  if(amount>=10000){
      discount=amount*20/100;
  }else if(amount>=5000){
      discount=amount*10/100;
  }else{
      discount=amount*5/100;
  }
%>

<html>
    <body>
        <h3>Discount Details</h3>
        <hr>
        <table border="2">
            <tr>
                <td>Amount</td>
                <td><%=amount%></td>
            </tr>
            <tr>
                <td>Discount</td>
                <td><%=discount%></td>
            </tr>
        </table>
        <hr>
        <a href="buyerpage.jsp">Buyer-PAge</a>
    </body>
</html>

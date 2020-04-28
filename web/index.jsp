<%@include  file="info.jsp" %>

<%@taglib  uri="/WEB-INF/tlds/mylib.tld" prefix="test" %>

<html>
    <body>
        
        <test:welcome/>
        
        <form action="VerifyUser" method="get">
            <table border="0">
            <tr>
                <td>Email</td><td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td>Password</td><td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Usertype</td><td><select name="utype"><option>admin</option><option>buyer</option></select></td>
            </tr>
            <tr>
                <td>Save Pswrd</td><td><input type="checkbox" name="save" value="yes"/></td>
            </tr>
            <tr>
                <td></td><td><input type="submit" value="Login"/></td>
            </tr>
            </table>
        </form>
        <hr>
        </form>
        <a href="registration.jsp">New-User</a>
    </body>
</html>

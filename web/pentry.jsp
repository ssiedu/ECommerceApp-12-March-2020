<html>
    <body>
        <h3>Product-Entry-Form</h3>
        <hr>
        <form action="SaveProduct" method="get">
        <pre>
            PCode       <input type="text" name="pcode"/>
            PName       <input type="text" name="pname"/>
            Desc        <input type="text" name="pdesc"/>
            Catg        <select name="pcat">
                            <option>auto</option>
                            <option>books</option>
                            <option>computers</option>
                            <option>electronics</option>  
                            <option>furniture</option>
                            <option>others</option>
                        </select>
            Price       <input type="text" name="price"/>
                        <input type="submit" value="SaveProduct"/>
        </pre>
        </form>
        <hr>
        <a href="adminpage.jsp">AdminPage</a>
    </body>
</html>

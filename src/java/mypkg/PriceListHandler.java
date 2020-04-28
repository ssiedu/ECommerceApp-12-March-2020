/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.sql.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author SSI
 */
public class PriceListHandler extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            Connection con=mypkg.Data.connect();
            String sql="select pname,price from products";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            out.println("<html>");
                out.println("<body>");
                out.println("<h3>Price List</h3>");
                out.println("<hr>");
            while(rs.next()){
                String s1=rs.getString(1);
                String s2=rs.getString(2);
                
                out.println(s1+","+s2+"<br>");
                
            }
            out.println("<hr>");
                out.println("</body>");
                out.println("</html>");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

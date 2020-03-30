import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out=response.getWriter();
            //This servlet will display all products belongs to the category clicked by user
            //how this servlet will know about the linked clicked by user?
            String category=request.getParameter("ctg");
            
            //we wish to store user choice (category) to client disk so that in next request browser
            //will send it back to server and any other sevlet can read it.
            //we will write this information using a Cookie.
            //step-1 create a cookie object
            
            Cookie ck=new Cookie("userchoice", category);
            //step-2 set its maximum age
            ck.setMaxAge(50000);//seconds
            //step-3 add the cookie object to response
            response.addCookie(ck);
            
            
            //we will run select query and fetch all the products of this category
            String sql="SELECT * FROM products WHERE pcat=?";
            try{
                Connection con=mypkg.Data.connect();
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, category);
                ResultSet rs=ps.executeQuery();
                out.println("<html>");
                out.println("<body>");
                
                out.println("<h3>Product-List</h3>");
                 out.println("<hr>");
                out.println("<table border=2>");
                out.println("<tr>");
                out.println("<th>Code</th>");
                out.println("<th>Name</th>");
                out.println("<th>Desc</th>");
                out.println("<th>Category</th>");
                out.println("<th>Price</th>");
                out.println("</tr>");
                while(rs.next()){
                    String code=rs.getString(1);
                    String pname=rs.getString(2);
                    String pdesc=rs.getString(3);
                    String pcat=rs.getString(4);
                    String price=rs.getString(5);
                    out.println("<tr>");
                    out.println("<td>"+code+"</td>");
                    out.println("<td>"+pname+"</td>");
                    out.println("<td>"+pdesc+"</td>");
                    out.println("<td>"+pcat+"</td>");
                    out.println("<td>"+price+"</td>");
                    out.println("<td><a href=CartManager?id="+code+">buy</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<hr>");
                out.println("<a href=CategoryServlet>Category-Page</a><br>");
                out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
                out.println("</body>");
                out.println("</html>");
                con.close();
            }catch(Exception e){
                out.println(e);
            }
            out.close();
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

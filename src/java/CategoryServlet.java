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
import javax.servlet.http.HttpSession;

public class CategoryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //here we are reading the email address of currently logged-in user from session
            //which was stored to session by VerifyUser servlet
            //step-1 (fetch the session object created for this user)
            HttpSession session=request.getSession();
            //step-2 (read the data from sesion object)
            String email=(String)session.getAttribute("id");
            if(email==null){
                response.sendRedirect("index.jsp");
            }
            
            //here we are reading the Cookie ("userchoice") so that we can scroll focused adv.
            //step-1 (obtaining all the cookies coming along with the request)
            Cookie ck[]=request.getCookies();
            //step-2 (searching for a cookie named userchoice)
            String choice="ALL";
            if(ck!=null){
                for(Cookie c:ck){
                    String name=c.getName();
                    if(name.equals("userchoice")){
                        choice=c.getValue();
                        break;
                    }
                }
            }
            
            
            //fetch-all-categories-from-DB
            PrintWriter out=response.getWriter();
            String sql="SELECT distinct pcat FROM products";
            try{
            Connection con=mypkg.Data.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            //show-them-on-a-web-page
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Category-Page</h3>");
            out.println("<h3>Welcome "+email+"</h3>");
            out.println("<h4><marquee>Attractive Offers On "+choice+" Products</marquee></h4>");
            out.println("<h4>Click-Desired-Category</h4>");
            out.println("<hr>");
            while(rs.next()){
                String s=rs.getString(1);
                out.println("<a href=ProductListServlet?ctg="+s+">");
                out.println(s);
                out.println("</a><br>");
            }
            out.println("<hr>");
            out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
            out.println("</body>");
            out.println("</html>");
            con.close();
            }catch(Exception e){
                out.println(e);
        }
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

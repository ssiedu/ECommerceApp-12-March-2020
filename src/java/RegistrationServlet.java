import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out=response.getWriter();
            //reads the data
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            String name=request.getParameter("name");
            String address=request.getParameter("address");
            String mobile=request.getParameter("mobile");
            //process the data
            try{
                Connection con=mypkg.Data.connect();
                String sql="INSERT INTO users VALUES(?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                ps.setString(3, name);
                ps.setString(4, address);
                ps.setString(5, mobile);
                ps.executeUpdate();
                con.close();
                out.println("<html>");
                out.println("<body>");
                out.println("<hr>");
                out.println("<h3>Registration Completed</h3>");
                out.println("<hr>");
                out.println("<h5><a href=index.jsp>Login-Now</a></h5>");
                out.println("</body>");
                out.println("</html>");
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

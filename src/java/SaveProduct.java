import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveProduct extends HttpServlet {

    Connection con; PreparedStatement ps;
    
    public void init(){
        try{
        con=mypkg.Data.connect();
        String sql="INSERT INTO products VALUES(?,?,?,?,?)";
        ps=con.prepareStatement(sql);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out=response.getWriter();
            //reads the data
            String pcode=request.getParameter("pcode");
            String pname=request.getParameter("pname");
            String pdesc=request.getParameter("pdesc");
            String pcat=request.getParameter("pcat");
            String price=request.getParameter("price");
            //process the data
            try{
                ps.setInt(1, Integer.parseInt(pcode));
                ps.setString(2, pname);
                ps.setString(3, pdesc);
                ps.setString(4, pcat);
                ps.setInt(5, Integer.parseInt(price));
                ps.executeUpdate();
                out.println("<html>");
                out.println("<body>");
                out.println("<hr>");
                out.println("<h3>DATA STORED</h3>");
                out.println("<hr>");
                out.println("<h5><a href=pentry.jsp>ADD-MORE</a></h5>");
                out.println("<h5><a href=adminpage.jsp>ADMIN-PAGE</a></h5>");
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

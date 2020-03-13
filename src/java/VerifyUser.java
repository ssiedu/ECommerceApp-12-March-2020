import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String utype=request.getParameter("utype");
        
        if(utype.equals("admin")){
            //admin is trying to login
            if(email.equals("admin@gmail.com") && password.equals("indore")){
                //out.println("Welcome Admin");
                //we will show adminpage
                response.sendRedirect("adminpage.jsp");
            }else{
                out.println("Invalid Admin Credentials");
            }
        }else if(utype.equals("buyer")){
            //buyer is trying to login
            try{
                Connection con=mypkg.Data.connect();
                String sql="SELECT * FROM USERS WHERE email=? AND password=?";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,email);
                ps.setString(2, password);
                ResultSet rs=ps.executeQuery();
                boolean found=rs.next();
                if(found){
                    //out.println("Welcome Buyer");
                    //we will show buyerpage
                    response.sendRedirect("buyerpage.jsp");
                }else{
                    out.println("Invalid Buyer Credentials");
                }
                
            }catch(Exception e){
                out.println(e);
            }
            
            
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

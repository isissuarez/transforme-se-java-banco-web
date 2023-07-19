
package bancoweb.servlet;

import bancoweb.dao.ClienteDAO;
import bancoweb.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "editarCliente", urlPatterns = {"/editar"})
public class editarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        Cliente cliente = new Cliente(request.getParameter("nome"),request.getParameter("sexo").charAt(0),
                    request.getParameter("Email"),request.getParameter("estadoCivil"));
        int id = Integer.parseInt(request.getParameter("id"));
        cliente.setId(id);
        
            ClienteDAO clienteDAO = new ClienteDAO();
          int status = clienteDAO.editarCliente(cliente);
           
            if(status > 0){
               out.print("<script>alert(\"Registro alterado com sucesso\";</script>");
               response.sendRedirect("listar");
            } 
           out.print("<script>alert(\"Erro ao alterar o registro\"</script>");
               response.sendRedirect("listar"); 
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoweb.servlet;

/**
 *
 * @author DELL
 */
import bancoweb.dao.ClienteDAO;
import bancoweb.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denis
 */
@WebServlet(name = "ListarCliente", urlPatterns = {"/listar"})
public class ListarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Clientes</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"bancoweb.css\" media=\"screen\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"margem\">");
            out.println("<div class=\"cabecalho\">");
            out.println("<h1>Lista de clientes</h1>");
            out.println("</div>");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-100\">");
            out.println("<a href='cliente.html'><button id=\"novo\" class=\"botao\">+ Novo Registro</button></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"container\">");
            out.println("<table>");
            out.println("<thead><tr><th>Id</th><th>Nome</th><th>Sexo</th><th>Email</th><th>Estado civil</th><th colspan=\"2\">Ações</th></tr>");
            out.println("</thead>");
            out.println(" <tbody>");

            ClienteDAO clienteDAO = new ClienteDAO();
            List<Cliente> clientes = clienteDAO.listarClientes();

            for (Cliente cliente : clientes) {
                out.print("<tr><td>" + cliente.getId()
                        + "</td><td>" + cliente.getNome()
                        + "</td><td>" + cliente.getSexo()
                        + "</td><td>" + cliente.getEmail()
                        + "</td><td>" + cliente.getEstadoCivil()
                        + "</td><td>🖊<a href='mostrarFormEditar?id=" + cliente.getId() + "'>editar</a>"
                        + "</td><td><a href='excluir?id=" + cliente.getId() + "'>excluir</a></td></tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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

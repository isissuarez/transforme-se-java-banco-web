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
@WebServlet(name = "MostrarFormEditar", urlPatterns = {"/mostrarFormEditar"})
public class MostrarFormEditar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int id = Integer.parseInt(request.getParameter("id"));

            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.buscarCliente(id);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cliente</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"bancoweb.css\" media=\"screen\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"margem\">");
            out.println("<div class=\"cabecalho\">");
            out.println("<h1>Cliente</h1>");
            out.println("</div>");
            out.println("<div class=\"container\">");
            out.println("<form  action=\"editar\" method=\"post\">");
            out.println("<input type=\"hidden\" id=\"id\" name=\"id\" value='" + cliente.getId() + "'>");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-25\">");
            out.println("<label for=\"nome\">Nome</label>");
            out.println("</div>");
            out.println("<div class=\"col-75\">");
            out.println("<input type=\"text\" id=\"nome\" name=\"nome\" value='" + cliente.getNome() + "'>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-25\">");
            out.println("<label for=\"Email\">Email</label>");
            out.println("</div>");
            out.println("<div class=\"col-75\">");
            out.println("<input type=\"text\" id=\"Email\" name=\"Email\" value='" + cliente.getEmail() + "'>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-25\">");
            out.println("<label>Sexo</label>");
            out.println("</div>");
            out.println(" <div class=\"col-75 boxBackground\">");
            if (cliente.getSexo() == 'M') {
                out.println("<input type=\"radio\" id=\"masculino\" name=\"sexo\" value=\"M\" checked >");
            } else {
                out.println("<input type=\"radio\" id=\"masculino\" name=\"sexo\" value=\"M\">");
            }
            out.println("<label for=\"masculino\">Masculino</label><br>");
            if (cliente.getSexo() == 'F') {
                out.println("<input type=\"radio\" id=\"feminino\" name=\"sexo\" value=\"F\" checked>");
            } else {
                out.println("<input type=\"radio\" id=\"feminino\" name=\"sexo\" value=\"F\">");
            }
            out.println("<label for=\"feminino\">Feminino</label><br>");
            out.println(" </div>");
            out.println("</div>");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-25\">");
            out.println("<label>Estado civíl</label>");
            out.println("</div>");
            out.println("<div class=\"col-75 boxBackground\">");
            if(cliente.getEstadoCivil().equals("casado")){
             out.println("<input type=\"radio\" id=\"casado\"name=\"estadoCivil\" value=\"casado\"checked>");   
            }
            else{
            out.println("<input type=\"radio\" id=\"casado\"name=\"estadoCivil\" value=\"casado\">");
            }
            out.println("<label for=\"casado\">casado</label><br>");
            if(cliente.getEstadoCivil().equals("solteiro")){
            out.println("<input type=\"radio\" id=\"solteiro\" name=\"estadoCivil\" value=\"solteiro\"checked>");    
            }
            else{
            out.println("<input type=\"radio\" id=\"solteiro\" name=\"estadoCivil\" value=\"solteiro\">");
            }
            out.println("<label for=\"solteiro\">solteiro</label><br>");
            if(cliente.getEstadoCivil().equals("divorciado")){
             out.println("<input type=\"radio\" id=\"divorciado\" name=\"estadoCivil\" value=\"divorciado\"checked>");   
            }
            else{
            out.println("<input type=\"radio\" id=\"divorciado\" name=\"estadoCivil\" value=\"divorciado\">");
            }
            out.println("<label for=\"divorciado\">divorciado</label><br>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-100\">");
            out.println("<input type=\"submit\" value=\"Salvar\">");
            out.println("</div>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div style=\"text-align: center;\">");
            out.println("<a href=\"listar\">Listar Clientes</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

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

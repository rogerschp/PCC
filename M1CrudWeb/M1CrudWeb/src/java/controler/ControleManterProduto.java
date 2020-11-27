/*
Roger Schmidt de Paula RGM: 11191102577
*/
package controler;

import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet(name = "ControleManterProduto", urlPatterns = {"/ControleManterProduto"})
public class ControleManterProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem = "";
        double preco;
        int id;

        try {
            Produto prod = new Produto();
            String operacao = request.getParameter("btnoperacao");
            ProdutoDAO pdao = new ProdutoDAO();
            if (request.getParameter("txtdescricao").equals("") || request.getParameter("txtpreco").equals("") || request.getParameter("txtid").equals("")) {
                if (operacao.equals("Visualizar")) {

                    List<Produto> lista = pdao.consultarTodos();
                    request.setAttribute("lprod", lista);
                    request.getRequestDispatcher("/listarTodos.jsp").forward(request, response);

                    mensagem = "Consulta";
                }
            } else {
                String descricao = request.getParameter("txtdescricao");
                preco = Double.parseDouble(request.getParameter("txtpreco"));
                id = Integer.parseInt(request.getParameter("txtid"));
                prod.setPreco(preco);
                prod.setId(id);
                prod.setDescricao(descricao);
                if (operacao.equals("Cadastrar")) {
                    pdao.cadastrar(prod);
                    mensagem = "CADASTRADO COM SUCESSO!!!";
                } else if (operacao.equals("Deletar")) {
                    pdao.deletar(prod);
                    mensagem = "DELETADO COM SUCESSO!!!";
                } else if (operacao.equals("Alterar")) {
                    pdao.alterar(prod);
                    mensagem = "ALTERAR COM SUCESSO!!!";
                }
            }

        } catch (ClassNotFoundException ex) {
            mensagem = "Erro no Digitação: " + ex.getMessage();
        } catch (SQLException ex) {
            mensagem = "Erro no Conexão: " + ex.getMessage();
        }

        request.setAttribute("mensagem", mensagem);

        request.getRequestDispatcher("/sucessocadproduto.jsp").forward(request, response);

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

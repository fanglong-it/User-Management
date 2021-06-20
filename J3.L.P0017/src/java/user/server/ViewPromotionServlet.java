/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.server;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.driver.listPromotionDAO;
import user.driver.listPromotionDTO;
import user.driver.promotionDAO;
import user.driver.promotionDTO;

/**
 *
 * @author Admin
 */
public class ViewPromotionServlet extends HttpServlet {

    private final String VIEWPROMOTION_PAGE = "viewPromotion.jsp";
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
        String url = VIEWPROMOTION_PAGE;
        try {
            promotionDAO pdao = new promotionDAO();
            listPromotionDAO ldao = new listPromotionDAO();
            List<promotionDTO> listPromotion = pdao.getAllPromotion();
            List<listPromotionDTO> listPromotionInfo = ldao.getAllListPromotion();
            
            HttpSession session = request.getSession();
            session.setAttribute("PROMOTION", listPromotion);
            session.setAttribute("LIST_PROMOTION", listPromotionInfo);
            
        } catch (Exception e) {
            log("Error At ViewPromotion Servlet: " + e.toString());
        } finally {
            response.sendRedirect(url);

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

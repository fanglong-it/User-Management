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
import user.util.util;
import user.driver.listPromotionDAO;
import user.driver.listPromotionDTO;

/**
 *
 * @author Admin
 */
public class SavePromotionServlet extends HttpServlet {

    private final String ADMIN_PAGE = "admin.jsp";

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
        String url = ADMIN_PAGE;
        try {
            util checkList = new util();
            HttpSession session = request.getSession();
            listPromotionDAO dao = new listPromotionDAO();
            List<listPromotionDTO> list1 = dao.getAllListPromotion();
            List<listPromotionDTO> list2 = (List<listPromotionDTO>) session.getAttribute("LIST_PROMOTION");

            if (list1 == null) {
                for (listPromotionDTO c : list2) {
                    dao.insertUserPromotion(c);
                }
            } else {
                for (listPromotionDTO dtodata : list1) {
                    for (listPromotionDTO dtonew : list2) {
                        if (!dao.checkExistInListPromotion(dtonew.getUsername())) {
                            dao.insertUserPromotion(dtonew);
                        } else if (!checkList.checkListExist(list2, dtodata.getUsername())) {
                            dao.deleteUserPromotion(dtodata);
                        } else if (dao.checkExistInListPromotion(dtonew.getUsername())) {
                            dao.updateUserPromotion(dtonew);
                        } else {

                        }
                    }
                }
            }
            request.setAttribute("MESSOK", "Save Success!");

        } catch (Exception e) {
            log("Error at Save Promotion Servlet: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.server;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.driver.listPromotionDAO;
import user.driver.listPromotionDTO;
import user.driver.userDAO;

/**
 *
 * @author Admin
 */
public class AddUserPromotionServlet extends HttpServlet {

    private final String VIEWPROMOTION_PAGE = "viewPromotion.jsp";
    private final String VIEWUSER_PAGE = "viewUserPromotion.jsp";

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
            float Value = 5;
            Boolean Check = true;
            String errorMessage = "";
            userDAO dao = new userDAO();
            HttpSession session = request.getSession();
            String Username = request.getParameter("txtUsername");
            String PromotionId = request.getParameter("txtPromotionId");
            Date date = new Date(System.currentTimeMillis());
            String Date = date.toString();
            List<listPromotionDTO> list = (List<listPromotionDTO>) session.getAttribute("LIST_PROMOTION");
            if(dao.checkRole(Username).equals("1")){
                Check = false;
                errorMessage = "You can't Add user have Role Admin to Promotion";
            }
            for (listPromotionDTO c : list) {
                if (c.getUsername().equals(Username)) {
                    errorMessage = "The User is present in List Promotion, Please Add new one!";
                    Check = false;
                }
            }
            if (Check) {
                listPromotionDTO dto = new listPromotionDTO(Username, Date, PromotionId, Value);
                list.add(dto);
                session.setAttribute("LIST_PROMOTION", list);
            } else {
                request.setAttribute("ERROR_MESSAGE", errorMessage);
                url = "ViewUserPromotionServlet?txtPromotionId=" + PromotionId;
            }

        } catch (Exception e) {
            log("Error at add User Promotion Servlet: " + e.toString());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.server;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.driver.listPromotionDAO;
import user.driver.listPromotionDTO;
import user.util.encrypted;
import user.driver.userDAO;
import user.driver.userDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final String ERROR = "login.jsp";
    private final String ADMIN_PAGE = "admin.jsp";
    private final String USER_PAGE = "user.jsp";

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
        String url = ERROR;

        try {
            userDAO dao = new userDAO();
            listPromotionDAO listDao = new listPromotionDAO();
            HttpSession session = request.getSession();
            String Username = request.getParameter("Username");
            String Password = request.getParameter("Password");

            userDTO user = dao.checkLogin(Username, encrypted.encryptedPassword(Password));
            listPromotionDTO userPromotion = listDao.getUserPromotion(Username);
            if(userPromotion != null){
                session.setAttribute("USER_PROMOTION", userPromotion);
            }
            if (user != null) {
                session.setAttribute("USER", user);
                if (user.getRole() == 1) {
                    url = ADMIN_PAGE;
                } else {
                    listPromotionDTO listDto = listDao.getUserPromotion(user.getUsername());
                    url = USER_PAGE;
                }
            } else {
                session.setAttribute("ERROR_MESSAGE", "Incorrect Username and Password");
                url = ERROR;
            }
        } catch (Exception e) {
            log("Error at Login Servlet: " + e.toString());
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

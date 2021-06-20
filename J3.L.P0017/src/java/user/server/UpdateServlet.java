/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.server;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.util.encrypted;
import user.driver.userDAO;
import user.driver.userDTO;

/**
 *
 * @author Admin
 */
public class UpdateServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.jsp";

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
        String url = LOGIN_PAGE;
        try {
            boolean check = true;
            userDAO dao = new userDAO();
            String errorMessage = "";
            HttpSession session = request.getSession();
            String LoginUsername = request.getParameter("txtLoginUsername");
            String Username = request.getParameter("txtUsername");
            String PhotoCode = request.getParameter("txtPhotoCode");
            String Name = request.getParameter("txtName");
            String Email = request.getParameter("txtEmail");
            String PhoneNumber = request.getParameter("txtPhoneNumber");
            String Role = request.getParameter("txtRole");
            String Status = request.getParameter("txtStatus");
            String newPassword = request.getParameter("txtNewPassword");
            String rePassword = request.getParameter("txtRePassword");
            String password = request.getParameter("txtPassword");

            if (!newPassword.isEmpty()) {
                if (newPassword.equals(rePassword)) {
                    password = encrypted.encryptedPassword(newPassword);
                } else {
                    check = false;
                    errorMessage = "Repassword must match with Password!";
                }
            }
            userDTO user = new userDTO(Username, password, PhotoCode, Name, Email, PhoneNumber, Integer.parseInt(Role), Status);
            if (check) {
                if (dao.updateUserInfo(user) > 0) {
                    if (LoginUsername.equals(Username)) {
                        url = LOGIN_PAGE;
                    } else {
                        url = "SearchServlet?Option=1&SearchName=";
                    }
                } else {
                    errorMessage = "Can't Update check again Infomation!";
                    url = "ViewInfoServlet?txtUsername=" + Username;
                }
            } else {
                url = "ViewInfoServlet?txtUsername=" + Username;
            }

            session.setAttribute("ERROR_UPDATE", errorMessage);
        } catch (Exception e) {
            log("Error at UpdateServlet: " + e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.server;

import java.io.IOException;
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
public class CreateAccountServlet extends HttpServlet {
    private final String LOGIN_PAGE = "login.jsp";
    private final String CREATE_PAGE = "createAccount.jsp";

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
            String errorMessage = "";
            userDAO dao = new userDAO();
            String Username = request.getParameter("txtUsername");
            String PhotoCode = request.getParameter("txtPhotoCode");
            String Password = request.getParameter("txtPassword");
            String RePassword = request.getParameter("txtRePassword");
            String Name = request.getParameter("txtName");
            String Email = request.getParameter("txtEmail");
            String PhoneNumber = request.getParameter("txtPhoneNumber");
            String Role = request.getParameter("txtRole");
            String Status = request.getParameter("txtStatus");
            if (!Password.equals(RePassword)) {
                check = false;
                errorMessage = "The Password and Repassword must match!";
            }
            if (dao.checkExist(Username)) {
                check = false;
                errorMessage = "The Account Existed, Choose new Account!";
            }
            if (check) {
                userDTO user = new userDTO(Username, encrypted.encryptedPassword(Password), PhotoCode, Name, Email, PhoneNumber, Integer.parseInt(Role), Status);
                if (dao.insertUser(user) > 0) {
                    url = LOGIN_PAGE;
                } else {
                    errorMessage = "Can't Insert Account, check again Infomation!";
                    url = CREATE_PAGE;
                }
            } else {
                url = CREATE_PAGE;
            }
            request.setAttribute("CREATE_ERROR", errorMessage);
        } catch (Exception e) {
            log("Error At create Account Servlet: " + e.toString());
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

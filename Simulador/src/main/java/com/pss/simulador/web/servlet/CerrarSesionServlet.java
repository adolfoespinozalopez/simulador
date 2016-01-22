package com.pss.simulador.web.servlet;

import com.pss.simulador.web.controller.LoginController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 04/01/2016
 * @since 1.0
 */
@WebServlet(name = "CerrarSesionServlet", urlPatterns = {"/CerrarSesionServlet"})
public class CerrarSesionServlet extends HttpServlet {

    public CerrarSesionServlet() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoginController login = (LoginController) session.getAttribute("loginController");
        if (session != null && login != null) {
//            login.setLogueado(false);
//            login.setUsuario("");
//            login.setContrasena("");
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath()+"/");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

package com.emergentes.controlador;

import com.emergentes.modelo.Empleados;
import com.emergentes.modelo.EmpleadosDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validar extends HttpServlet {

    EmpleadosDAO edao = new EmpleadosDAO();
    Empleados em = new Empleados();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            em = edao.validar(user, pass);
            if (em.getUser() != null) {
                session.setAttribute("usuario", em);
                request.getRequestDispatcher("Controlador?menu=Inicio").forward(request, response);
            } else {
                request.setAttribute("errorLogin", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

}

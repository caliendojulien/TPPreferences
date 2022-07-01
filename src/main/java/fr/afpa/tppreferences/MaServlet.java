package fr.afpa.tppreferences;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/affichage")
public class MaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("couleur") != null) {
            request.setAttribute("couleur", session.getAttribute("couleur"));
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String couleur = request.getParameter("couleur");
        System.out.println(couleur);
        if (couleur != null) {
            HttpSession session = request.getSession();
            session.setAttribute("couleur", couleur);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

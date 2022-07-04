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
        boolean trouve = false;
        int cpt = 1;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("compteur")) {
                trouve = true;
                cpt = Integer.parseInt(cookie.getValue());
                cookie.setValue(String.valueOf(++cpt));
                response.addCookie(cookie);
                break;
            }
        }
        if (!trouve) {
            Cookie cookie = new Cookie("compteur", "1");
            cookie.setMaxAge(50000000);
            response.addCookie(cookie);
        }
        request.setAttribute("compteur", cpt);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String couleur = request.getParameter("couleur");
        if (couleur != null) {
            HttpSession session = request.getSession();
            session.setAttribute("couleur", couleur);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

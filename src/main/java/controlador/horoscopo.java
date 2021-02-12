/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Utilidades;

/**
 *
 * @author Bueno
 */
public class horoscopo extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet horoscopo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet horoscopo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        ArrayList<String> meses = Utilidades.getMeses();
        ArrayList<String> dias = Utilidades.getDias();
        request.setAttribute("meses", meses);
        request.setAttribute("dias", dias);
        request.getRequestDispatcher("horoscopo.jsp").forward(request, response);
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
        ArrayList<String> meses = Utilidades.getMeses();
        ArrayList<String> dias = Utilidades.getDias();
        request.setAttribute("meses", meses);
        request.setAttribute("dias", dias);

        String nombre = request.getParameter("nombre");
        String diaSel = request.getParameter("dia");
        String mesSel = request.getParameter("mes");

        String signo = "";
        String[] mesTexto = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        if (Integer.parseInt(diaSel) >= 21 && mesSel.equals("1")
                || (Integer.parseInt(diaSel) <= 18 && mesSel.equals("2"))) {
            signo = nombre  + " tu signo es Acuario";
        } else if (Integer.parseInt(diaSel) >= 19 && Integer.parseInt(diaSel) <= 28 && mesSel.equals("2")
                || (Integer.parseInt(diaSel) <= 20 && mesSel.equals("3"))) {
            signo = nombre  + " tu signo es Piscis";
        } else if (Integer.parseInt(diaSel) >= 21 && mesSel.equals("3")
                || (Integer.parseInt(diaSel) <= 20 && mesSel.equals("4"))) {
            signo = nombre  + " tu signo es Aries";
        } else if (Integer.parseInt(diaSel) >= 21 && Integer.parseInt(diaSel) <= 30 && mesSel.equals("4")
                || (Integer.parseInt(diaSel) <= 20 && mesSel.equals("5"))) {
            signo = nombre  + " tu signo es Tauro";
        } else if (Integer.parseInt(diaSel) >= 21 && mesSel.equals("5")
                || (Integer.parseInt(diaSel) <= 20 && mesSel.equals("6"))) {
            signo = nombre  + " tu signo es Géminis";
        } else if (Integer.parseInt(diaSel) >= 21 && Integer.parseInt(diaSel) <= 30 && mesSel.equals("6")
                || (Integer.parseInt(diaSel) <= 22 && mesSel.equals("7"))) {
            signo = nombre  + " tu signo es Cáncer";
        } else if (Integer.parseInt(diaSel) >= 23 && mesSel.equals("7")
                || (Integer.parseInt(diaSel) <= 22 && mesSel.equals("8"))) {
            signo = nombre  + " tu signo es Leo";
        } else if (Integer.parseInt(diaSel) >= 23 && mesSel.equals("8")
                || (Integer.parseInt(diaSel) <= 21 && mesSel.equals("9"))) {
            signo = nombre  + " tu signo es Virgo";
        } else if (Integer.parseInt(diaSel) >= 22 && Integer.parseInt(diaSel) <= 30 && mesSel.equals("9")
                || (Integer.parseInt(diaSel) <= 22 && mesSel.equals("10"))) {
            signo = nombre  + " tu signo es Libra";
        } else if (Integer.parseInt(diaSel) >= 23 && mesSel.equals("10")
                || (Integer.parseInt(diaSel) <= 22 && mesSel.equals("11"))) {
            signo = nombre  + " tu signo es Escorpio";
        } else if (Integer.parseInt(diaSel) >= 23 && Integer.parseInt(diaSel) <= 30 && mesSel.equals("11")
                || (Integer.parseInt(diaSel) <= 21 && mesSel.equals("12"))) {
            signo = nombre  + " tu signo es Sagitario";
        } else if (Integer.parseInt(diaSel) >= 22 && mesSel.equals("12")
                || (Integer.parseInt(diaSel) <= 20 && mesSel.equals("1"))) {
            signo = nombre  + " tu signo es Capricornio";
        } else {
            signo = "NO existe el día " + diaSel + " para el mes de " + mesTexto[Integer.parseInt(mesSel) - 1];
        }

        request.setAttribute("nombreSel", nombre);
        request.setAttribute("diaSel", diaSel);
        request.setAttribute("mesSel", mesSel);
        request.setAttribute("signo", signo);

        request.getRequestDispatcher("horoscopo.jsp").forward(request, response);
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

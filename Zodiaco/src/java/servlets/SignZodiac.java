/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Polupero
 */
public class SignZodiac extends HttpServlet {

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
            out.println("<title>Servlet SignZodiac</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet SignZodiac at " + request.getContextPath() + "</h1>");
            out.println("<h1>Zodiaco</h1>");
            int dia = 0, mes = 0, ano = 0;
            String signo = "";
            try{
                dia = Integer.parseInt(request.getParameter("dia"));
                mes = Integer.parseInt(request.getParameter("mes"));
                ano = Integer.parseInt(request.getParameter("ano"));
                GregorianCalendar cal = new GregorianCalendar(ano, mes, dia);
            }
            catch(Exception e){
//                response.sendRedirect("index.jsp?bandera=0"); También se puede mandar de esta manera.
                request.setAttribute("message", "error");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response); 
            }
            switch (mes){
                case 1:
                    signo = (dia<21)?"Capricornio":"Acuario";
                    break;
                case 2:
                    signo = (dia<20)?"Acuario":"Piscis";
                    break;
                case 3:
                    signo = (dia<21)?"Piscis":"Aries";
                    break;
                case 4:
                    signo = (dia<21)?"Aries":"Tauro";
                    break;
                case 5:
                    signo = (dia<22)?"Tauro":"Geminis";
                    break;
                case 6:
                    signo = (dia<22)?"Geminis":"Cancer";
                    break;
                case 7:
                    signo = (dia<23)?"Cancer":"Leo";
                    break;
                case 8:
                    signo = (dia<23)?"Leo":"Virgo";
                    break;
                case 9:
                    signo = (dia<23)?"Virgo":"Libra";
                    break;
                case 10:
                    signo = (dia<23)?"Libra":"Escorpio";
                    break;
                case 11:
                    signo = (dia<23)?"Escorpio":"Sagitario";
                    break;
                default:
                    signo = (dia<22)?"Sagitario":"Capricornio";
                    break;
            }
            out.println("<p>Tu signo es: " + signo + "</p>");
            out.println("<form action=\"CompatibleSigns\">");
            out.println("<input type=\"hidden\" value=\"" + signo +"\"name=\"hidden\" />");
            out.println("<input type=\"submit\" value=\"Ver signos compatibles\" name=\"enviar\" />");
            out.println("</form>");
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

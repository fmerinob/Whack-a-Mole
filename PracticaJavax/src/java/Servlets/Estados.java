/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author polupero
 */
public class Estados extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            ArrayList<String> estados = new ArrayList<String>();
            estados.add("Aguascalientes - Aguascalientes");
            estados.add("Baja California - Mexicalli");
            estados.add("Baja California Sur - La paz");
            estados.add("Campeche - Campeche");
            estados.add("Coahuila - Saltillo");
            estados.add("Colima - Colima");
            estados.add("Chiapas - Tuxtla Gutierrez");
            estados.add("Chihuahua - Chihuahua");
            estados.add("Distrito Federal - Ciudad de México");
            estados.add("Durango - Durango");
            estados.add("Estado de México - Toluca");
            estados.add("Guanajuato - Guanajuato");
            estados.add("Guerrero - Chilpancingo");
            estados.add("Hidalgo - Pachuca");
            estados.add("Jalisco - Guadalajara");
            estados.add("Michoacan - Morelia");
            estados.add("Morelos - Cuernavaca");
            estados.add("Nayarit - Tepic");
            estados.add("Oaxaca - Oaxaca");
            estados.add("Puebla - Puebla");
            estados.add("Quintana Roo - Chetumal");
            estados.add("San Luis Potosi - San Luis Potosi");
            estados.add("Sinaloa - Culiacan");
            estados.add("Sonora - Hermosillo");
            estados.add("Tabasco - Villahermosa");
            estados.add("Tamaulipas - Ciudad Victoria");
            estados.add("Tlaxcala - Tlaxcala");
            estados.add("Veracruz - Xalapa");
            estados.add("Yucatán - Merida");
            estados.add("Zacatecas - Zacatecas");
            
            String input = request.getParameter("input");
            String hints = "";
            if(input.length()>=1){
                for (int i = 0; i < estados.size(); i++) {
                    if (estados.get(i).toLowerCase().substring(0, input.length()+1).contains(input.toLowerCase())){
                        hints+= "[" + estados.get(i) + "]";
                    }
                }
            }
            out.write(hints);
        } finally {
            out.close();
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

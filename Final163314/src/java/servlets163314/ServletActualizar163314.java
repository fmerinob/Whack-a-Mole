/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets163314;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Polupero
 */
public class ServletActualizar163314 extends HttpServlet {

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
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            java.sql.Connection con2 = DriverManager.getConnection("jdbc:derby://localhost:1527/misdatos163314", "root", "root");
            Statement query = con2.createStatement();
            query.executeUpdate("UPDATE MITABLA163314 SET CLIENTE163314='" + request.getParameter("Cliente163314") + "'WHERE IDENTIFICADOR163314=" + request.getParameter("Identificador163314"));
            query.executeUpdate("UPDATE MITABLA163314 SET DOMICILIO163314='" + request.getParameter("Domicilio163314") + "'WHERE IDENTIFICADOR163314=" + request.getParameter("Identificador163314"));
            query.executeUpdate("UPDATE MITABLA163314 SET SALDO163314=" + Double.valueOf(request.getParameter("Saldo163314")) + " WHERE IDENTIFICADOR163314=" + request.getParameter("Identificador163314"));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletActualizar163314.class.getName()).log(Level.SEVERE, null, ex);
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

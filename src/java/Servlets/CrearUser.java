/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import davivienda.usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author FredyPenaChambo
 */
public class CrearUser extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String cedula = request.getParameter("cedula");
        String PNombre = request.getParameter("PNombre");
        String SNombre = request.getParameter("SNombre");
        String PApellido = request.getParameter("PApellido");
        String SApellido = request.getParameter("SApellido");
        String celular = request.getParameter("Celular");
        String password = request.getParameter("pass");
       
       
         usuario u = new usuario();
          PrintWriter out = response.getWriter();
         int cedInt = Integer.parseInt(cedula);
         int pass = Integer.parseInt(password);
         boolean validacion =  u.crearCuenta(PNombre, SNombre, PApellido, SApellido, cedInt, celular, pass);
         if(validacion){
                response.sendRedirect("index.jsp");
         }else{
                  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal('El usuario ya esta registrado' , ' ' , 'error' );");
                    out.println("});");
                    out.println("</script>");

                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);
         }
         
        
        


       //if(u.crearCuenta(null, null, null, null, cedula, null, contrasena));
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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

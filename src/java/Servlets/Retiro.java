/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import davivienda.transacciones;
import davivienda.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FredyPenaChambo
 */
@WebServlet(name = "Retiro", urlPatterns = {"/sacar"})
public class Retiro extends HttpServlet {

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
        int monto = 0;
        int NoCuenta;
        String recibirM = request.getParameter("numero");

        if (!recibirM.equals("")) {
            monto = Integer.parseInt(recibirM);

            usuario u = new usuario();
            transacciones t = new transacciones();
            PrintWriter out = response.getWriter();
            HttpSession objSession = request.getSession(false);

            String cedula = (String) objSession.getAttribute("cedula");

            if (Integer.parseInt(t.monto(Integer.parseInt(cedula))) >= monto) {
                NoCuenta = Integer.parseInt(cedula);
                String a = u.retornarCuenta(NoCuenta);
                NoCuenta = Integer.parseInt(a);
                if (t.retirar(NoCuenta, monto) == true) {
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal('Su transacción fue exitosa' , ' ' , 'success' );");
                    out.println("});");
                    out.println("</script>");

                    RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                    rd.include(request, response);
                } else {
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal('Su transacción no fue exitosa' , ' ' , 'error' );");
                    out.println("});");
                    out.println("</script>");

                    RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                    rd.include(request, response);
                }
            } else {
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Su transacción no fue exitosa' , ' ' , 'error' );");
                out.println("});");
                out.println("</script>");

                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.include(request, response);
            }
        } else {
            response.sendRedirect("home.jsp");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Retiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Retiro.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Retiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Retiro.class.getName()).log(Level.SEVERE, null, ex);
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

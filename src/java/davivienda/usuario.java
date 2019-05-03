/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davivienda;

//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import davivienda.conexion2;

import java.sql.*;
import java.sql.CallableStatement;
import java.time.Clock;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class usuario {

    String primerNombre;
    String segundoNombre;
    String primerApellido;
    String segundoApellido;
    String noCuenta;
    int cedula;
     String telefono;
     int contrasena;

   
    conexion2 conex;
    Statement estatuto;
    ResultSet rs;

    public usuario() throws ClassNotFoundException, SQLException {
        primerNombre = "";
        segundoNombre = "";
        primerApellido = "";
        segundoApellido = "";
        cedula = 0;
        telefono = "";
        contrasena = 0;
        noCuenta = "";
        conex = new conexion2();
        estatuto = null;
        rs = null;
    }

    public boolean login(int cedula, int contrasena) {

        try {
            
            
            estatuto = conex.getConexion().createStatement();
            rs = estatuto.executeQuery("SELECT count(*) FROM USUARIO WHERE cedula_usuario = " + cedula + "AND contraseña = " + contrasena);
            while (rs.next()) {
                String a = " ";
                a = rs.getString(1);
                
                //System.out.println(a);
                if (Integer.decode(a) == 1) {
                    retornarCuenta(cedula);
                    return true;
                    
                } else {
                    return false;
                }
            }
            estatuto.close();
           // conex.getConexion().close();
         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean crearCuenta(String primerNombre,
            String segundoNombre,
            String primerApellido,
            String segundoApellido,
            int cedula,
            String telefono,
            int contrasena) {
        if (!validarUsuario(cedula)) {
            try {
                CallableStatement cStmt = conex.getConexion().prepareCall("{call crear_usuario(?, ?, ?, ?, ?, ?, ?)}");
                cStmt.setInt(1, cedula);
                cStmt.setString(2, primerNombre);
                cStmt.setString(3, segundoNombre);
                cStmt.setString(4, primerApellido);
                cStmt.setString(5, segundoApellido);
                cStmt.setString(6, telefono);
                cStmt.setInt(7, contrasena);

                cStmt.execute();
                cStmt.close();
                crearCuentaB(cedula);

                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
        } else {
            return false;
        }
        return false;
    }

    public boolean crearCuentaB(int id) {
          try {
            estatuto = conex.getConexion().createStatement();
            rs = estatuto.executeQuery("INSERT INTO CUENTA VALUES (cuenta_nocuenta.NEXTVAL, 0, (select id_usuario from usuario where cedula_usuario = " + id + "), 1)");

            estatuto.close();
            conex.getConexion().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         return true;
    }

    public boolean validarUsuario(int cedula) {

        String consUsuario = "";
        String a = "";
        this.cedula = cedula;
        try {
            estatuto = conex.getConexion().createStatement();
            consUsuario = "SELECT COUNT(*) FROM USUARIO WHERE CEDULA_USUARIO = " + cedula;
            rs = estatuto.executeQuery(consUsuario);
            while (rs.next()) {
                a = rs.getString(1);
            }
            estatuto.close();
           // conex.getConexion().close();

            if (!a.equals("1")) {
                return false;
            }

            return true;

        } catch (Exception e) {
            System.out.print(e);
            return false;
        }
    }

    public String retornarCuenta (int cedula){
           String consUsuario = "";
        String a = "";
        try {
            estatuto = conex.getConexion().createStatement();
            consUsuario = "SELECT c.NOCUENTA FROM CUENTA c, USUARIO u WHERE u.ID_USUARIO = c.ID_USUARIO AND CEDULA_USUARIO = " + cedula;
            rs = estatuto.executeQuery(consUsuario);
            while (rs.next()) {
              //  System.out.println(rs.getString(1));
                a = rs.getString(1);
            }
            estatuto.close();
            conex.getConexion().close();

          
          //  System.out.println(a);
        } catch (Exception e) {
            System.out.print(e);
          //  return false;
        }
        //System.out.println(a);
        this.noCuenta = a;
        return a;
    }
    
    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }
    
     public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        //crearCuenta("pedro2", "aaaa", "peña ", "chambo", 7775 , "32454", 9870);
        usuario u = new usuario();
        
      //  u.login(3333, 9870);
       // System.out.println("Hola" +u.getNoCuenta());
        
        //System.err.println(u.crearCuenta("Killer", "qwer", "werw", "qewr", 3335, "2222", 2222));
     //  u.login(cedula, contrasena)
        //System.out.println(u.validarUsuario(3333));
        
    }

}

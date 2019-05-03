/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davivienda;


import java.sql.CallableStatement;
import java.sql.*;
import davivienda.conexion2;
import org.kohsuke.rngom.digested.Main;
import davivienda.usuario;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KilerMayorgaSanabria
 */
public class transacciones extends usuario {

    //int cedula;
    int contrasena;
    conexion2 conex;
    Statement estatuto;
    ResultSet rs;
    usuario u;

    public transacciones() throws ClassNotFoundException, SQLException {

        //  cedula = 0;
        contrasena = 0;
        conex = new conexion2();
        estatuto = null;
        rs = null;
        u = new usuario();

    }

    public boolean consignar(int NoCuenta, int adicion) {
        try {
            CallableStatement cStmt = conex.getConexion().prepareCall("{call consignar(?, ?)}");
            cStmt.setInt(1, NoCuenta);
            cStmt.setFloat(2, adicion);

            cStmt.execute();

            cStmt.close();
            conex.getConexion().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public String monto(int cedula) throws SQLException {
        estatuto = conex.getConexion().createStatement();
        String a = " ";
        rs = estatuto.executeQuery("SELECT c.monto from cuenta c, usuario u where u.id_usuario = c.id_usuario AND u.cedula_usuario = " + cedula);
        while (rs.next()) {
            a = rs.getString(1);
        }
        return a;
    }

    public boolean retirar(int NoCuenta, int resta) throws ClassNotFoundException, SQLException {
        transacciones t = new transacciones();
      //  if (Integer.parseInt(t.monto()) >= resta) {
            try {
                CallableStatement cStmt = conex.getConexion().prepareCall("{call retirar(?, ?)}");
                cStmt.setInt(1, NoCuenta);
                cStmt.setFloat(2, resta);
                cStmt.execute();
                cStmt.close();
                conex.getConexion().close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
      //  } else {
       //     return false;
     //   }
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        int NoCuenta = 0;
        usuario u = new usuario();
        transacciones t = new transacciones();
        t.consignar(5001, 1000);
    }

}

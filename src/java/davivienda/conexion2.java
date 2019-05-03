/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davivienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
*
* @author AndresFelipeVegaBelt
*/
public class conexion2 {


   String bd = "orcl";
   String user = "davik";
   String password = "davivienda";
   String url = "jdbc:oracle:thin:@localhost:1521:"+bd;
   private Connection conexion;
   private Statement st = null;


   public  conexion2() throws ClassNotFoundException, SQLException {

     Class.forName("oracle.jdbc.driver.OracleDriver");
     conexion = DriverManager.getConnection(url, user, password);
     st = conexion.createStatement();

   }

   /**
    * @return the conexion
    */
   public Connection getConexion() {
       return conexion;
   }

   /**
    * @param conexion the conexion to set
    */
   public void setConexion(Connection conexion) {
       this.conexion = conexion;
   }

   /**
    * @return the st
    */
   public Statement getSt() {
       return st;
   }

   /**
    * @param st the st to set
    */
   public void setSt(Statement st) {
       this.st = st;
   }

    Object getConexcion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

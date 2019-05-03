/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davivienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.kohsuke.rngom.digested.Main;

public class conexion {

    static String bd = "orcl";
    static String login = "Bodegas";
    static String password = "bodegas";
    static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    Connection connection = null;


    public  conexion() {
        try {
            connection = DriverManager.getConnection(url, login, password);
            if (connection != null) {
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*Permite retornar la conexión*/
    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
    }

}

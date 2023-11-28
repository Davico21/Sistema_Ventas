package com.emergentes.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_sistema_ventas";
    String user = "root";
    String pass = "1234";

    public Connection Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el Driver: "+ ex.getMessage());
        }
        return con;
    }
     public void desconetar(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar" + ex.getMessage());
        }
    }
}

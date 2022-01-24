/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDd;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author PERSONAL
 */
public class Conexion {
    Connection connect = null;
    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/electrodomesticos", "root", "");
            // JOptionPane.showConfirmDialog(null,"Estas Conectado");
        } catch (Exception ex) {
            // Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "Error..." + ex);
        }
        return connect;
    }

   
}


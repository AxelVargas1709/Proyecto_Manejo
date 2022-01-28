package BaseDd;

import BaseDd.empleados;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BDEmpleados {

    private static Connection mConection;
    private static Statement mStatement;
    private static ResultSet mResultSet;
    private final String bd;
    private final String user;
    private final String password;

    public BDEmpleados(String bd, String user, String password) {
        mConection = null;
        mStatement = null;
        mResultSet = null;
        this.bd = bd;
        this.user = user;
        this.password = password;
    }
    
    public boolean Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            mConection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/electrodomesticos", "root", "");
            return mConection != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void Desconectar() {
        try {
            this.mConection.close();
        } catch (Exception e) {
        }
    }

    public Boolean AddUserEmp(empleados Usuemp) {
        try {
            mStatement = mConection.createStatement();
            mStatement.execute("INSERT INTO empleados (CED_EMP, NOM_EMP, APE_EMP, CONT_EMP, CARG_EMP, TELF_EMP, SUEL_EMP)"
                    + " VALUES ('" + Usuemp.getCedula_emp()+ "', '" + Usuemp.getNombre_emp()+ "','" + Usuemp.getApellido_emp()
                    + "','" + Usuemp.getContrasena_emp()+ "','" + Usuemp.getCargo_emp()+ "','" + Usuemp.getTelefono_emp()+ "','" + Usuemp.getSueldo_emp()+ "')");
            return true;
             }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Cedula existente");    
        return false;
    }
    }
    
    public empleados GetUsuarioEmp(String cedulaEmp) {
        empleados mUsuario = null;
        try {
            mStatement = mConection.createStatement();
            mResultSet = mStatement.executeQuery("SELECT * FROM empleados WHERE CED_EMP = '" + cedulaEmp + "' ");
            while (mResultSet.next()) {
                mUsuario = new empleados();
                mUsuario.setCedula_emp(mResultSet.getString("CED_EMP"));
                mUsuario.setNombre_emp(mResultSet.getString("NOM_EMP"));
                mUsuario.setApellido_emp(mResultSet.getString("APE_EMP"));
                mUsuario.setContrasena_emp(mResultSet.getString("CONT_EMP"));
                mUsuario.setCargo_emp(mResultSet.getString("CARG_EMP"));
                mUsuario.setTelefono_emp(mResultSet.getString("TELF_EMP"));
                mUsuario.setSueldo_emp(mResultSet.getInt("SUEL_EMP"));
                return mUsuario;
            }
        } catch (SQLException e) {
            return null;
        }
        return mUsuario;
    }

    public Boolean ExisteUsuario(String cedula) {
        try {
            mStatement = mConection.createStatement();
            mResultSet = mStatement.executeQuery("SELECT * FROM empleados WHERE CED_EMP ='" + cedula + "'");
            return mResultSet.next();
        } catch (SQLException ex) {
            return false;
        }
    }
 
    public Boolean ExistePerfilGerente(String cedula) {
        try {
            mStatement = mConection.createStatement();
            mResultSet = mStatement.executeQuery("SELECT * FROM empleados WHERE CARG_EMP= 'GERENTE' AND CED_EMP='" + cedula + "'");
            return mResultSet.next();
       
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            
        }
        return false;
    }
    public Boolean ExistePerfilVendedor(String cedula) {
        try {
            mStatement = mConection.createStatement();
            mResultSet = mStatement.executeQuery("SELECT * FROM empleados WHERE CARG_EMP= 'VENDEDOR' AND CED_EMP='" + cedula + "'");
            return mResultSet.next();
       
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            
        }
        return false;
    }
    
     public Boolean ExistePerfilContador(String cedula) {
        try {
            mStatement = mConection.createStatement();
            mResultSet = mStatement.executeQuery("SELECT * FROM empleados WHERE CARG_EMP= 'CONTADOR' AND CED_EMP='" + cedula + "'");
            return mResultSet.next();
       
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            
        }
        return false;
    }
}

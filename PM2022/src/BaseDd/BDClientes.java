package BaseDd;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BDClientes {

    private static Connection mConection;
    private static Statement mStatement;
    private static ResultSet mResultSet;
    private final String bd;
    private final String user;
    private final String password;

    public BDClientes(String bd, String user, String password) {
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

    public Boolean AddUserCli(clientes Usuemp) {
        try {
            mStatement = mConection.createStatement();
            mStatement.execute("INSERT INTO clientes (CED_CLI,NOM_CLI,APE_CLI,TELF_CLI,DIR_CLI)"
                    + " VALUES ('" + Usuemp.getCed_cli()+ "', '" + Usuemp.getNom_cli()+ "','" + Usuemp.getApe_cli()
                    + "','" + Usuemp.getTel_cli()+ "','" + Usuemp.getDir_cli()+"')");
            return true;
             }catch(MySQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "Cedula existente");
            
        
        } catch (SQLException e) {
            System.err.println(e.toString());
            
        }
        return false;
    }

    public clientes GetUsuarioEmp(String cedulaEmp) {
        clientes mUsuario = null;
        try {
            mStatement = mConection.createStatement();
            mResultSet = mStatement.executeQuery("SELECT * FROM clientes WHERE CED_CLI='" + cedulaEmp + "' ");
            while (mResultSet.next()) {
                mUsuario = new clientes();
                mUsuario.setCed_cli(mResultSet.getString("CED_CLI"));
                mUsuario.setNom_cli(mResultSet.getString("NOM_CLI"));
                mUsuario.setApe_cli(mResultSet.getString("APE_CLI"));
                mUsuario.setTel_cli(mResultSet.getString("TELF_CLI"));
                mUsuario.setDir_cli(mResultSet.getString("DIR_CLI"));
                return mUsuario;
            }
        } catch (SQLException e) {
            return null;
        }
        return mUsuario;
    }

    public Boolean ExisteCliente(String cedula) {
        try {
            mStatement = mConection.createStatement();
            mResultSet = mStatement.executeQuery("SELECT * FROM clientes WHERE CED_CLI ='" + cedula + "'");
            return mResultSet.next();
        } catch (SQLException ex) {
            return false;
        }
    }
 
    public Boolean ExistePerfilGerente(String cedula) {
        try {
            mStatement = mConection.createStatement();
            mResultSet = mStatement.executeQuery("SELECT * FROM clientes WHERE CARG_EMP= 'GERENTE' AND CED_EMP='" + cedula + "'");
            return mResultSet.next();
       
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            
        }
        return false;
    }
}

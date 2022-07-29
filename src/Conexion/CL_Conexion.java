package Conexion;
//-----------*******IMPORTS*****------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Vista.*;
/**
 *
 * @author fabian
 */
public class CL_Conexion {
    Connection conn = null;
    Principal index = new Principal(); // SE INICIALIZA LA PAG.PRINCIPAL
    Loggin lg = new Loggin();          // SE INICIALIZA LA PAG.LOGGIN
    /*
    public CL_Conexion() {
        abrirConexion("","");
    }*/
    public void abrirConexion(String username,String password) { //CREAR LA CONEXION MEDIANTE PARAMETROS
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // DRIVER
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",username,password); // SE PASAN LOS PARAMETROS
            if (conn != null) { // INICIA CONDICIONAL
                JOptionPane.showMessageDialog(null,"Conexion exitosa"); //MOSTRAR MENSAJE
                index.setVisible(true);            // MUESTRO LA PANTALLA PRINCIPAL
                lg.setVisible(false);              // ESCONDO LA PAGINA LOGGIN
                
            }// CIERRA CONDICIONAL
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos" + ex +"/n verifique sus datos" ); // MENSAJE DE ERROR
            Loggin lg = new Loggin();   // SE INICIALIZA LA PAG.LOGGIN
            lg.setVisible(true);        // ESCONDO LA PAGINA LOGGIN   
        }
    }
    public Connection obtenerConexion(){ // OBTENER CONEXION
        return conn;
    }
    public void cerrarConexion() throws SQLException{ // CIERRO LA CONEXION
        try {
            conn.close(); // CIERRA CONEXION
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al cerrar la base de datos" + ex ); // MENSAJE DE ERROR
        }           
    }
}
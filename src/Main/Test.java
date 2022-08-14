package Main;
import Conexion.CL_Conexion;
import java.sql.Connection;
import javax.swing.JOptionPane;
import Vista.*;
/**
 *
 * @author fabian
 */
public class Test {
    public static Connection conexion = null;
Loggin lg = new Loggin();
    public static void main(String[] args) {        
        try {
            Loggin lg = new Loggin();
            lg.setVisible(true);
            //CL_Conexion conn = new CL_Conexion();
            //conexion = conn.obtenerConexion();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar" + ex);
        }
    }
}
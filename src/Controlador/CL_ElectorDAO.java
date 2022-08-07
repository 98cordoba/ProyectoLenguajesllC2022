package Controlador;
//-----------*******IMPORTS*****------------------------------------------------
import Conexion.CL_Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.internal.OracleTypes;
import oracle.jdbc.OracleCallableStatement;
/**
 *
 * @author fabian
 */
public class CL_ElectorDAO {
    public static Connection conexion = null; //INICIALIZAR CONEXION    
    public CL_ElectorDAO() { //SI LA CONEXION ES NULA LA OBTENGO
        if (conexion == null) {
            conexion = new CL_Conexion().obtenerConexion();
        }
    }     
    public DefaultTableModel listarElectores(){ //CREACIÓN O LISTADO DE LA J.TABLE DE ELECTORES 
        try {
            DefaultTableModel tabla = new DefaultTableModel(); // SE INICIALIZA LA TABLA
            tabla.addColumn("Cedula Elector");      //COLUMNA
            tabla.addColumn("Codigo Elector");      //COLUMNA
            tabla.addColumn("Relleno");             //COLUMNA
            tabla.addColumn("Fecha Caduca Cedula"); //COLUMNA
            tabla.addColumn("Junta Receptora");     //COLUMNA
            tabla.addColumn("Nombre Elector");      //COLUMNA
            tabla.addColumn("1.Apellido Elector");  //COLUMNA
            tabla.addColumn("2.Apellido Elector");  //COLUMNA           
            CallableStatement cstmt = conexion.prepareCall("{? = call read_txt}"); //lLAMA UN PROCEDIMIENTO ALMACENADO Y Retorna un cursor            
            cstmt.registerOutParameter(1,OracleTypes.CURSOR);           
            cstmt.execute();  // SE EJECUTA          
            ResultSet rs = ((OracleCallableStatement)cstmt).getCursor(1);            
            String datos[] = new String[7]; // SE INICIALIZA UN ARRAY DE STRING            
            while (rs.next()) { // EMPIEZA EL WHILE
                datos[0] = String.valueOf(rs.getInt("cedulaElector"));  //ALMACENA UN DATO
                datos[1] = String.valueOf(rs.getInt("codElector"));     //ALMACENA UN DATO
                datos[2] = rs.getString("relleno");                     //ALMACENA UN DATO
                datos[3] = String.valueOf(rs.getDate("fechaCaduca"));   //ALMACENA UN DATO
                datos[4] = String.valueOf(rs.getInt("juntaReceptora")); //ALMACENA UN DATO
                datos[5] = rs.getString("nombreElector");               //ALMACENA UN DATO
                datos[6] = rs.getString("primerApellido");              //ALMACENA UN DATO
                datos[7] = rs.getString("segundoApellido");             //ALMACENA UN DATO   
                tabla.addRow(datos);     // SE AGREGA LA FILA           
            }//CIERRA EL WHILE
            return tabla; // SE RETORNA LA TABLA
        } catch (Exception e) {
            return null;
        }        
    }     
    public int buscarElectorXCedula(String cedulaE){//FUNCION BUSCAR POR CEDULA
        try {
            CallableStatement cstmt = conexion.prepareCall("{? = call FN_BuscarXCedula(?)}"); //LLAMADO AL METODO ALMACENADO            
            cstmt.setString(2, cedulaE);                        // variable de Entrada         
            cstmt.registerOutParameter(1,OracleTypes.NUMBER);   //variable de salida            
            cstmt.execute();            
            int cedula = ((OracleCallableStatement)cstmt).getInt(1);
            return cedula;            
        } catch (Exception e) {
            return 0;
        }
    }
}
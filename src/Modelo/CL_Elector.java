package Modelo;
import java.util.Date;
/**
 *
 * @author fabian
 */
public class CL_Elector {
    //--------------------*****VARIABLES*****-----------------------------------
    private int cedulaElector;
    private int codElector;
    private String relleno;
    private Date fechaCaduca;
    private String juntaReceptora;
    private String nombreElector;
    private String primerApellido;
    private String segundoApellido;
    
    //----------------*******CONSTRUCTORES**********----------------------------
    public CL_Elector() {
    }

    public CL_Elector(int cedulaElector, int codElector, String relleno, Date fechaCaduca, String juntaReceptora, String nombreElector, String primerApellido, String segundoApellido) {
        this.cedulaElector = cedulaElector;
        this.codElector = codElector;
        this.relleno = relleno;
        this.fechaCaduca = fechaCaduca;
        this.juntaReceptora = juntaReceptora;
        this.nombreElector = nombreElector;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }
    //-------------*******GETTER AND SETTER*****--------------------------------
    public int getCedulaElector() {
        return cedulaElector;
    }
    
    public void setCedulaElector(int cedulaElector) {
        this.cedulaElector = cedulaElector;
    }

    public int getCodElector() {
        return codElector;
    }

    public void setCodElector(int codElector) {
        this.codElector = codElector;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }
    
    public Date getFechaCaduca() {
        return fechaCaduca;
    }

    public void setFechaCaduca(Date fechaCaduca) {
        this.fechaCaduca = fechaCaduca;
    }

    public String getJuntaReceptora() {
        return juntaReceptora;
    }

    public void setJuntaReceptora(String juntaReceptora) {
        this.juntaReceptora = juntaReceptora;
    }

    public String getNombreElector() {
        return nombreElector;
    }

    public void setNombreElector(String nombreElector) {
        this.nombreElector = nombreElector;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }  
}
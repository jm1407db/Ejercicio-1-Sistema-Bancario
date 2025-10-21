package SRC.Model.Excepciones;
/**
 * Clase de exepcion para el manejo de operaciones invalidas
 * @author Julian Moreno
 * @version 1.0
 */
public class OperacionInvalidaExcepcion extends Exception {
    /**
     * Constructor que recibe el mensaje personalido para la excepcion en especifico
     * @param mensaje mensaje que detalle el error especifico
     */
    public OperacionInvalidaExcepcion(String mensaje){
        super(mensaje);
    }
}

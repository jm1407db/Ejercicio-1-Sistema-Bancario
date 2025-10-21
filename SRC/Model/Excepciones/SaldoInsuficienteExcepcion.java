package SRC.Model.Excepciones;
/**
 * Excepcion personalzada que lanza un mensaje cuando se realiza una operacion
 * y no se tiene el saldo suficiente para realizarla.
 * @author Julian Moreno
 * @version 1.0
 * @param
 */
public class SaldoInsuficienteExcepcion extends Exception {
    /**
         * Constuctor que recibe un mensaje personalizado de la excepcion.
         * Este mensaje es el que se obtiene en el .getMessage().
         * @param mensaje el mensaje detallado  que describe el error.
         */
    
    public SaldoInsuficienteExcepcion(String mensaje){
        super(mensaje);
    }
}

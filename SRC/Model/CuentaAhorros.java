package SRC.Model;

import javax.swing.JOptionPane;

import SRC.Model.Excepciones.OperacionInvalidaExcepcion;
import SRC.Model.Excepciones.ValorInvalidoExcepcion;
/**
 * Clase hija de cuenta bancaria que tiene un porcentaje de intereses por cada mes 
 * @author Julian Moreno
 * @version 1.0
 */
public class CuentaAhorros extends CuentaBancaria {
    private byte numeroMesesCuenta;
    /**
     * Constructor que se encarga de crear una cuenta de ahorros con sus atributos
     * @param saldo saldo inicial de la cuenta
     * @param numeroCuenta identificador de la cuenta
     * @param titular nombre del titular de la cuenta
     * @param numeroMesesCuenta numero de meses de vida de la cuenta 
     * @throws ValorInvalidoExcepcion se encarga de mostrar un mensaje en caso tal de que el numero de meses sea invalido
     * @throws OperacionInvalidaExcepcion 
     */
    public CuentaAhorros(double saldo, String numeroCuenta, String titular,byte numeroMesesCuenta) throws ValorInvalidoExcepcion, OperacionInvalidaExcepcion {
        super( saldo=saldo+((numeroMesesCuenta*0.05)*saldo),numeroCuenta, titular);
        if (numeroMesesCuenta<0) {
            throw new ValorInvalidoExcepcion("El numero de meses no puede ser negativo");
        }

        this.numeroMesesCuenta=numeroMesesCuenta;
    }
    /**
     * Metodo que se encarga de calcular los intereses actuales y mostrarselos al usuario
     */
    public void calcularIntereses(){
        JOptionPane.showMessageDialog(null, "Su interes actual es de :"+(numeroMesesCuenta*0.05)*saldo);
    }
    /**
     * Trae el numero de meses de la cuenta
     * @return el numero de meses de la cuenta
     */
    public byte getNumeroMesesCuenta() {
        return numeroMesesCuenta;
    }
    /**
     * Permite cambiar el numero de meses de la cuenta
     * @param numeroMesesCuenta numero nuevo de meses de la cuenta
     */
    public void setNumeroMesesCuenta(byte numeroMesesCuenta) {
        this.numeroMesesCuenta = numeroMesesCuenta;
    }
    
    
}

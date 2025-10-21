package SRC.Model;

import javax.swing.JOptionPane;

import SRC.Model.Excepciones.OperacionInvalidaExcepcion;
import SRC.Model.Excepciones.SaldoInsuficienteExcepcion;
import SRC.Model.Excepciones.ValorInvalidoExcepcion;

/**
 * Representa la clase padre Cuenta bancaria de la que saldran sus variantes con sus funciones basicas.
 * Permite depositar, calcular el saldo y retirar.
 * @author Julian Moreno
 * @version 1.0
 */
public abstract class CuentaBancaria {
    protected double saldo;
    protected String numeroCuenta;
    protected String titular;
    /**
     * Constructor para crear una cuenta bancaria con los datos necesarios para su manejo
     * @param saldo cantidad de dinero en su cuenta bancaria    
     * @param numeroCuenta identificador de la cuenta bancaria
     * @param titular nombre del titular al que esta asociado la cuenta bancaria
     *  @throws ValorInvalidoExcepcion Excepcion que se encarga de enviar un mensjae encaso de que los datos que necesita el 
     * metodo sean invalidos
     */
    public CuentaBancaria(double saldo, String numeroCuenta, String titular) throws ValorInvalidoExcepcion,OperacionInvalidaExcepcion{
        if (saldo<=0) {
            throw new ValorInvalidoExcepcion("El saldo inicial no puede ser negativo");
        }
        if (numeroCuenta==null||titular==null) {
            throw new ValorInvalidoExcepcion("El valor del numero de cuenta o del titular no puede ser nulo");
        }
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
    }
    /**
     * Metodo que se encarga de retirar dinero del saldo actual de la cuena bancaria
     * 
     * @param cantidadRetirar Dinero que se va a retirara del saldo actual
     * @throws SaldoInsuficienteExcepcion Excepcion que se encarga de enviar un mensaje en caso de que la cantidad a retirar
     *  no permita hacer el retiro
     * @throws ValorInvalidoExcepcion Excepcion que se encarga de enviar un mensjae encaso de que los datos que necesita el 
     * metodo sean invalidos
     * @throws OperacionInvalidaExcepcion 
     */
    public void retirar(double cantidadRetirar)throws SaldoInsuficienteExcepcion, ValorInvalidoExcepcion, OperacionInvalidaExcepcion{
        if (cantidadRetirar<=0) {
            throw new ValorInvalidoExcepcion("El monto a retirar debe ser positivo");
        }
        if (cantidadRetirar>saldo) {
            throw new SaldoInsuficienteExcepcion("No tienes saldo suficiente. Quieres retirara "+cantidadRetirar+" y solo tienes "+this.saldo);
        }
        this.saldo-=cantidadRetirar;
        JOptionPane.showMessageDialog(null, "Retiro Exitoso. Cantidada actual en la cuenta de:$"+saldo);
    }
    public void depositar(double montoDepositar)throws ValorInvalidoExcepcion{
        if (montoDepositar<=0) {
            throw new ValorInvalidoExcepcion("El monto a depositar no puede ser negativo ni cero");
        }
        saldo+=montoDepositar;
    };
    /**
     * Trae el valor del saldo actual
     * @return el saldo disponible en valor double
     */
    public double getSaldo() {
        return saldo;
    }
    /**
     * Permite editar el saldo actual
     * @param saldo es el nuevo saldo que queremos
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    /**
     * Trae el valor del numero de cuenta
     * @return el numero de cuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    /**
     * Permite cambiar el numero de cuenta bancaria
     * @param numeroCuenta numero nuevo que se desea remplazar
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    /**
     * Trae el nombre del titular de la cuenta 
     * @return el nombre del titular de la cuenta
     */
    public String getTitular() {
        return titular;
    }
    /**
     * Permite cambiar el nombre del titular de la cuenta
     * @param titular nombre nuevo por el que se desea remplazar
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
}

package SRC.Model;

import javax.swing.JOptionPane;

import SRC.Model.Excepciones.OperacionInvalidaExcepcion;
import SRC.Model.Excepciones.SaldoInsuficienteExcepcion;
import SRC.Model.Excepciones.ValorInvalidoExcepcion;
/**
 * Clase hija de cuenta bancaria que tiene como particularidad el manejo de un monto fijo por retiro
 * @author Julian Moreno
 * @version 1.0
 */
public class CuentaCorriente extends CuentaBancaria {
    private double comisionFija;
    /**
     * Constructor que se encarga de crear una cuenta corriente
     * @param saldo saldo inicial de la cuenta
     * @param numeroCuenta identificador de la cuenta
     * @param titular nombre del titular de la cuenta
     * @param comisionFija cantidad de comision fija por retiro
     * @throws ValorInvalidoExcepcion enviar un mensaje en caso de que el valor de comision fija sea invalido
     * @throws OperacionInvalidaExcepcion 
     */
    public CuentaCorriente(double saldo, String numeroCuenta, String titular,double comisionFija) throws ValorInvalidoExcepcion, OperacionInvalidaExcepcion {
        super(saldo, numeroCuenta, titular);
        if (comisionFija<=0) {
            throw new ValorInvalidoExcepcion("La comision fija no puede ser negativa o cero");
        }
        this.comisionFija=comisionFija;
    }
    @Override
    public void retirar(double cantidadRetirar)throws SaldoInsuficienteExcepcion, ValorInvalidoExcepcion{
        if (cantidadRetirar<=0) {
            throw new ValorInvalidoExcepcion("El monto a retirar debe ser positivo");
        }
        if (cantidadRetirar>saldo) {
            throw new SaldoInsuficienteExcepcion("No tienes saldo suficiente. Quieres retirara "+cantidadRetirar+" y solo tienes "+this.saldo);
        }
        this.saldo-=cantidadRetirar;
        this.saldo-=comisionFija;
        JOptionPane.showMessageDialog(null, "Retiro Exitoso. Cantidada actual en la cuenta de:$"+saldo);
    }
    /**
     * Trae el valor de la comision fija
     * @return la comision fija
     */
    public double getComisionFija() {
        return comisionFija;
    }
    /**
     * Permite cambiar el valor de la comision fija
     * @param comisionFija nuevo valor de la comision fija
     */
    public void setComisionFija(double comisionFija) {
        this.comisionFija = comisionFija;
    }
    
}

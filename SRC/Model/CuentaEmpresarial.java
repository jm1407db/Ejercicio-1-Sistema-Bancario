package SRC.Model;

import javax.swing.JOptionPane;

import SRC.Model.Excepciones.OperacionInvalidaExcepcion;
import SRC.Model.Excepciones.SaldoInsuficienteExcepcion;
import SRC.Model.Excepciones.ValorInvalidoExcepcion;
/**
 * Clase hija que tiene como diferenciador el hecho de que tiene limite de cantidad a retirar
 * @author Julian Moreno
 * @version 1.0
 */
public class CuentaEmpresarial extends CuentaBancaria {
    /**
     * Constructor que se encarga de crear ua cuenta empresarial con sus respectivos atributos
     * @param saldo saldo inicial de la cuenta
     * @param numeroCuenta identificador de la cuenta
     * @param titular nombre del titular de la cuenta
     * @throws ValorInvalidoExcepcion envia un mensaje en caso de que algun valor sea invalido
     * @throws OperacionInvalidaExcepcion 
     */
    public CuentaEmpresarial(double saldo, String numeroCuenta, String titular) throws ValorInvalidoExcepcion, OperacionInvalidaExcepcion {
        super(saldo, numeroCuenta, titular);
    }
    @Override
    public void retirar(double cantidadRetirar)throws OperacionInvalidaExcepcion, SaldoInsuficienteExcepcion, ValorInvalidoExcepcion{
        if (cantidadRetirar<=0) {
            throw new ValorInvalidoExcepcion("El monto a retirar debe ser positivo");
        }
        if (saldo<=100000) {
            throw new OperacionInvalidaExcepcion("No se puede retirar si en la cuenta quedan 100.000 o menos debido al limite de retiro \nSaldo de la cuenta:"+saldo);
        }
        if (cantidadRetirar>saldo) {
            throw new SaldoInsuficienteExcepcion("No tienes saldo suficiente. Quieres retirara "+cantidadRetirar+" y solo tienes "+this.saldo);
        }
        this.saldo-=cantidadRetirar;
        JOptionPane.showMessageDialog(null, "Retiro Exitoso. Cantidada actual en la cuenta de:$"+saldo);
    }
}

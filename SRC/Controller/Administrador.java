package SRC.Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import SRC.Model.CuentaBancaria;
import SRC.Model.Depositos;
import SRC.Model.Retiros;

public class Administrador {
    private ArrayList<Retiros>ListaRetiros;
    private ArrayList<Depositos>ListaDepositos;
    private ArrayList<CuentaBancaria>listaCuentaBancarias;
    public Administrador(ArrayList<Retiros> listaRetiros, ArrayList<Depositos> listaDepositos) {
        ListaRetiros = listaRetiros;
        ListaDepositos = listaDepositos;
        listaCuentaBancarias= new ArrayList<>();
    }
    public CuentaBancaria buscarCuentaBancaria(String numeroCuenta){
        for (CuentaBancaria cuentaBancaria : listaCuentaBancarias) {
            if (cuentaBancaria.getNumeroCuenta().equals(numeroCuenta)) {
                return cuentaBancaria;
            }
        }
        return null;
    }
    public void showListDepositos(){
        for (Depositos depositos : ListaDepositos) {
            System.out.println("Nombre titular:"+depositos.getNombreTitular()+"||Cantidad Depositada"+depositos.getCantidadDepositada()+"||Saldo actual:"+depositos.getSaldoActual()+"||Numero cuenta bancaria"+depositos.getNumeroCuenta());
        }
    }
    public void showListRetiros(){
        for (Retiros retiro : ListaRetiros) {
            System.out.println("Nombre titular:"+retiro.getNombreTitular()+"||Cantidad Retirada"+retiro.getCantidadRetirada()+"||Saldo actual:"+retiro.getSaldoActual()+"||Numero cuenta bancaria"+retiro.numeroCuenta());
        }
    }
    public void AddCuentaBancaria(CuentaBancaria cuentaBancaria){
        listaCuentaBancarias.add(cuentaBancaria);
    }
    public void AddRetiro(Retiros retiro){
        ListaRetiros.add(retiro);
    }
    public void AddDeposito(Depositos deposito){
        ListaDepositos.add(deposito);
    }
}

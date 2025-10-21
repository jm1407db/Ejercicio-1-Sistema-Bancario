package SRC.Model;

public class Depositos {
    private String nombreTitular;
    private double cantidadDepositada;
    private double SaldoActual;
    private String numeroCuenta;
    public Depositos(String nombreTitular, double cantidadDepositada, double saldoActual,
            String numeroCuenta) {
        this.nombreTitular = nombreTitular;
        this.cantidadDepositada = cantidadDepositada;
        this.SaldoActual = saldoActual;
        this.numeroCuenta = numeroCuenta;
    }
    public String getNombreTitular() {
        return nombreTitular;
    }
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    public double getCantidadDepositada() {
        return cantidadDepositada;
    }
    public void setCantidadDepositada(double cantidadDepositada) {
        this.cantidadDepositada = cantidadDepositada;
    }
    public double getSaldoActual() {
        return SaldoActual;
    }
    public void setSaldoActual(double saldoActual) {
        SaldoActual = saldoActual;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta=numeroCuenta;
    }
    
}

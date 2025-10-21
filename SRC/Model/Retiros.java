package SRC.Model;

public class Retiros {
    private String nombreTitular;
    private double cantidadRetirada;
    private double saldoActual;
    private String numeroCuenta;
    public Retiros(String nombreTitular, double cantidadRetirada, double saldoActual, String numeroCuenta) {
        this.nombreTitular = nombreTitular;
        this.cantidadRetirada = cantidadRetirada;
        this.saldoActual = saldoActual;
        this.numeroCuenta= numeroCuenta;
    }
    public String getNombreTitular() {
        return nombreTitular;
    }
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    public double getCantidadRetirada() {
        return cantidadRetirada;
    }
    public void setCantidadRetirada(double cantidadRetirada) {
        this.cantidadRetirada = cantidadRetirada;
    }
    public double getSaldoActual() {
        return saldoActual;
    }
    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }
    public String numeroCuenta(){
        return numeroCuenta;
    }
    public void setTipoCuenta(String numeroCuenta) {
        this.numeroCuenta=numeroCuenta;
    }
    
    
}

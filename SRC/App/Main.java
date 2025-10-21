package SRC.App;



import java.util.ArrayList;

import javax.swing.JOptionPane;

import SRC.Controller.Administrador;
import SRC.Controller.LoaderDepositos;
import SRC.Controller.LoaderRetiros;
import SRC.Controller.WriteDepositos;
import SRC.Controller.WriteRetiros;
import SRC.Model.CuentaAhorros;
import SRC.Model.CuentaCorriente;
import SRC.Model.CuentaEmpresarial;
import SRC.Model.Depositos;
import SRC.Model.Retiros;
import SRC.Model.Excepciones.OperacionInvalidaExcepcion;
import SRC.Model.Excepciones.SaldoInsuficienteExcepcion;
import SRC.Model.Excepciones.ValorInvalidoExcepcion;

public class Main{
    public static void main(String[] args) {
        WriteDepositos writeDepositos= new WriteDepositos();
        LoaderDepositos loaderDepositos= new LoaderDepositos();
        ArrayList<Depositos>ListaDepositos= loaderDepositos.LoaderDepositos("Depositos.txt");
        WriteRetiros writeRetiros= new WriteRetiros();
        LoaderRetiros loaderRetiros= new LoaderRetiros();
        ArrayList<Retiros>ListaRetiros= loaderRetiros.LoaderRetiros("Retiros.txt");
        Administrador admin= new Administrador(ListaRetiros,ListaDepositos);
        try {
            JOptionPane.showMessageDialog(null, "Bienvenidos a Banpolombia");
            Byte user= 12;
            do{ 
                user= Byte.parseByte(JOptionPane.showInputDialog("Porfavor escriba 0 salir, escriba 1 si desea crear una Cuenta Bancaria 2. si desea ver la lista de depostios 3. si desea ver la lista de retiros"));
                switch (user) {
                    case 1:
                        do {
                            try{
                                user=Byte.parseByte(JOptionPane.showInputDialog("Escriba 0.salir del programa o 4 para regresar al menu inicial, 1 si desea crar una cuenta de ahorros, 2.Cuenta corriente, 3. Cuenta empresarial"));
                                switch (user) { 
                                        case 1:
                                            double saldoCuentaAhorros=Double.parseDouble(JOptionPane.showInputDialog("Escriba el saldo inical de su cuenta"));
                                            String nombreTitularAhorros=JOptionPane.showInputDialog("Escriba el nombre a quien va a estar la cuenta");
                                            String numeroCuentaAhorro=JOptionPane.showInputDialog("Escriba el numero de cuenta que desea tener");
                                            Byte numeroMesesAhorro=Byte.parseByte(JOptionPane.showInputDialog("Escriba los meses que lleva en el banco"));
                                            CuentaAhorros cuentaAhorros= new CuentaAhorros(saldoCuentaAhorros, numeroCuentaAhorro, nombreTitularAhorros, numeroMesesAhorro);
                                            admin.AddCuentaBancaria(cuentaAhorros);
                                            break;
                                        case 2:
                                            double saldoCuentaCorriente=Double.parseDouble(JOptionPane.showInputDialog("Escriba el saldo inical de su cuenta"));
                                            String nombreTitularCorriente=JOptionPane.showInputDialog("Escriba el nombre a quien va a estar la cuenta");
                                            String numeroCuentaCorriente=JOptionPane.showInputDialog("Escriba el numero de cuenta que desea tener");
                                            double comisionFija=Double.parseDouble(JOptionPane.showInputDialog("Escriba la comision fija que tiene por retiro"));
                                            CuentaCorriente cuentaCorriente= new CuentaCorriente(saldoCuentaCorriente, numeroCuentaCorriente, nombreTitularCorriente, comisionFija);
                                            admin.AddCuentaBancaria(cuentaCorriente);
                                            break;
                                        case 3:
                                            double saldoCuentaEmpresarial=Double.parseDouble(JOptionPane.showInputDialog("Escriba el saldo inical de su cuenta"));
                                            String nombreTitularEmpresarial=JOptionPane.showInputDialog("Escriba el nombre a quien va a estar la cuenta");
                                            String numeroCuentaEmpresarial=JOptionPane.showInputDialog("Escriba el numero de cuenta que desea tener");
                                            CuentaEmpresarial cuentaEmpresarial= new CuentaEmpresarial(saldoCuentaEmpresarial, numeroCuentaEmpresarial, nombreTitularEmpresarial);
                                            admin.AddCuentaBancaria(cuentaEmpresarial);
                                        break;
                                    }
                            }catch(ValorInvalidoExcepcion e){
                                JOptionPane.showMessageDialog(null, "Error al crear la cuenta:"+e.getMessage());
                            }catch(OperacionInvalidaExcepcion e){
                                JOptionPane.showMessageDialog(null, "Error al crear la cuenta:"+e.getMessage());
                            }catch(NullPointerException e){
                                JOptionPane.showMessageDialog(null,"El valor no puede ser nulo");
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                        } while (user!=0 && user!=4);
                        break;
                    case 2:
                        admin.showListDepositos();
                        break;
                    case 3:
                        admin.showListRetiros();
                        break;
                    case 4:
                        try{ 
                            String numeroCuenta=JOptionPane.showInputDialog(null, "Escribe el numero de tu cuenta");
                            admin.buscarCuentaBancaria(numeroCuenta);
                            if (admin.buscarCuentaBancaria(numeroCuenta)!=null) {
                                double montoRetirar=Double.parseDouble(JOptionPane.showInputDialog("Escribe el valor que quieres retirar"));
                                admin.buscarCuentaBancaria(numeroCuenta).retirar(montoRetirar);
                                admin.AddRetiro(new Retiros(admin.buscarCuentaBancaria(numeroCuenta).getTitular(),montoRetirar, admin.buscarCuentaBancaria(numeroCuenta).getSaldo(), numeroCuenta));
                                writeRetiros.SaveFiles("Retiros.txt",ListaRetiros);
                            }else{
                                JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
                            }
                        }catch(ValorInvalidoExcepcion e){
                            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
                        }catch(OperacionInvalidaExcepcion e){
                            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
                        }catch(SaldoInsuficienteExcepcion e){
                            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
                        }catch(NullPointerException e){
                            JOptionPane.showMessageDialog(null,"El valor no puede ser nulo");
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, e);
                        }
                        break;
                    case 5:
                        try{
                            String numeroCuenta2=JOptionPane.showInputDialog(null, "Escribe el numero de tu cuenta");
                            admin.buscarCuentaBancaria(numeroCuenta2);
                            if (admin.buscarCuentaBancaria(numeroCuenta2)!=null) {
                                double montoDepositar=Double.parseDouble(JOptionPane.showInputDialog("Escribe el valor que quieres Depositar"));
                                admin.buscarCuentaBancaria(numeroCuenta2).depositar(montoDepositar);
                                admin.AddDeposito(new Depositos(admin.buscarCuentaBancaria(numeroCuenta2).getTitular(), montoDepositar, admin.buscarCuentaBancaria(numeroCuenta2).getSaldo(), numeroCuenta2));
                                writeDepositos.SaveFiles("Depositos.txt", ListaDepositos);
                            }else{
                                JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
                            }
                        }catch(ValorInvalidoExcepcion e){
                            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
                        }catch(NullPointerException e){
                            JOptionPane.showMessageDialog(null,"El valor no puede ser nulo");
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, e);
                        }
                        break;
                    }    
            }while(user!=0);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,"El valor no puede ser nulo");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        

    }
}

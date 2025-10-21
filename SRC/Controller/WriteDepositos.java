package SRC.Controller;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import SRC.Model.Depositos;

public class WriteDepositos {
    public static void SaveFiles(String pathFile,List<Depositos>newListDepositos) throws IOException{
        try(BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(pathFile))) {
            for (Depositos deposito : newListDepositos) {
                String valores= deposito.getNombreTitular()+","+deposito.getCantidadDepositada()+","+deposito.getSaldoActual()+","+deposito.getNumeroCuenta();
                bufferedWriter.write(valores);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"No se encontro el archivo");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, pathFile, 0);
        }

    }
}

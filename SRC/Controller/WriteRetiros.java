package SRC.Controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import SRC.Model.Depositos;
import SRC.Model.Retiros;

public class WriteRetiros {
    public static void SaveFiles(String pathFile,List<Retiros>newListRetiros) throws IOException{
        try(BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(pathFile))) {
            for (Retiros retiro : newListRetiros) {
                String valores= retiro.getNombreTitular()+","+retiro.getCantidadRetirada()+","+retiro.getSaldoActual()+","+retiro.numeroCuenta();
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

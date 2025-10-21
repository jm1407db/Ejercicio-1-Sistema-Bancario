package SRC.Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import SRC.Model.Depositos;

public class LoaderDepositos {
    public static ArrayList<Depositos> LoaderDepositos(String pathFile){
            ArrayList<Depositos> depositos=new ArrayList<>();

            try(BufferedReader buffer_reader=new BufferedReader(new FileReader(pathFile))){
                String line;
                while ((line=buffer_reader.readLine())!=null){

                    String[]values=line.split(",");
                    String nombreTitular=values[0];
                    double cantidadDepositada=Double.parseDouble(values[1]);
                    double SaldoActual=Double.parseDouble(values[2]);
                    String numeroCuenta=values[3];

                    depositos.add(new Depositos(nombreTitular, cantidadDepositada, SaldoActual, numeroCuenta));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
        
                System.out.println("There is a problem loading the file"+ e.getMessage());
            }
            return depositos;
        }
}
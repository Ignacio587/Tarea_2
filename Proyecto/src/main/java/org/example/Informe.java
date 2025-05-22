package org.example;
import java.io.FileWriter;
import java.io.IOException;

public class Informe {
    Reunion reunion;
    public Informe(Reunion reunion){
        this.reunion=reunion;
    }
    public  void escribir(){
        try {
        FileWriter escritor = new FileWriter("nota_de_reuinion.txt");
        escritor.write(reunion.toString());
        escritor.close();
        }
        catch (IOException e) {
        }
    }
}

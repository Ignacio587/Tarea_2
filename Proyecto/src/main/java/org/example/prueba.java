package org.example;
import java.io.FileWriter;
import java.io.IOException;

public class prueba {
    Reunion reunion;
    public prueba(Reunion reunion){
        this.reunion=reunion;
    }
    public  void escribir(){
        try {
        FileWriter escritor = new FileWriter("nota_de_reuinion.txt");
        escritor.write(reunion.toString());
        escritor.close();
    } catch (IOException e) {
    }
}
}

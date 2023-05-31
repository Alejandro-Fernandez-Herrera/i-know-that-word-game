package I_Know_That_Word;

import java.util.ArrayList;

public class Palabras {
    private ArrayList<String> banco = new ArrayList<String>();

    public Palabras(){
        FileManager fileManager = new FileManager();
        banco = fileManager.readFile("palabras.txt");
    }



    public ArrayList<String> getPalabras(){
        return banco;

    }
}

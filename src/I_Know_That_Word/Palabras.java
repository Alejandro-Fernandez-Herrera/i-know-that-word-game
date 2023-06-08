package I_Know_That_Word;

import java.util.ArrayList;
/**
 * The Palabras class represents a collection of words.
 */
public class Palabras {
    private ArrayList<String> banco = new ArrayList<String>();
    /**
     * Constructs a Palabras object and initializes it with words from a file.
     */
    public Palabras(){
        FileManager fileManager = new FileManager();
        banco = fileManager.readFile("words.txt");
    }
    /**
     * Retrieves the collection of words.
     *
     * @return ArrayList of words.
     */
    public ArrayList<String> getPalabras(){
        return banco;

    }
}

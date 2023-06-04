package I_Know_That_Word;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    //public static final String PATH = "src/I_Know_That_word/files/words.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    /**
     * Obtains words from text files
     * */
    public ArrayList<String> readFile(String filename) {
        ArrayList<String> list = new ArrayList<String>();

        String path = "src/I_Know_That_Word/files/" + filename;

        try {
            fileReader = new FileReader(path);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                list.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}


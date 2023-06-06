package I_Know_That_Word;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;
    private String filePath = "src/I_Know_That_Word/files/data.txt";

    /**
     * Gets the words from the text files
     * */
    public ArrayList<String> readFile(String file) {
        ArrayList<String> list = new ArrayList<String>();

        String PATH = file ;

        try {
            fileReader = new FileReader(PATH);
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

    /**
     * Writes the specified text to a file
     */
    public void writer(String text) {
        try {
            fileWriter = new FileWriter(filePath, true);
            output = new BufferedWriter(fileWriter);
            output.write(text);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Reads the content of a file and returns it as a string
     */
    public String reader() {
        StringBuilder sb = new StringBuilder();
        try {
            fileReader = new FileReader(filePath);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                sb.append(line).append("\n");
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
        return sb.toString();
    }
}
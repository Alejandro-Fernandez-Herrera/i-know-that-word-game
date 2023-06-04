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

/**
 * private FileReader fileReader;: Declares a private FileReader object to read characters from a file.
 * private BufferedReader input;: Declares a private BufferedReader object to read text from a character-input stream.
 * private FileWriter fileWriter;: Declares a private FileWriter object to write characters to a file.
 * private BufferedWriter output;: Declares a private BufferedWriter object to write text to a character-output stream.
 * public ArrayList<String> readFile(String filename) {: Defines a public method called readFile that takes a filename as a parameter and returns an ArrayList of strings.
 * ArrayList<String> list = new ArrayList<String>();: Creates a new ArrayList to store the read words.
 * String path = "src/myProject/archivos/" + filename;: Constructs the path to the text file based on the provided filename.
 * fileReader = new FileReader(path);: Initializes the FileReader object with the specified file path.
 * input = new BufferedReader(fileReader);: Initializes the BufferedReader object with the FileReader to read text from the file.
 * String line = input.readLine();: Reads the first line of text from the file.
 * while (line != null) {: Starts a loop to read each line of text until reaching the end of the file.
 * list.add(line);: Adds the current line to the ArrayList of words.
 * line = input.readLine();: Reads the next line of text.
 * }: Closes the loop.
 * } catch (FileNotFoundException e) {: Handles the exception if the file is not found.
 * } catch (IOException e) {: Handles the exception if an I/O error occurs.
 * } finally {: Executes the following block of code regardless of whether an exception occurs or not.
 * input.close();: Closes the BufferedReader to release system resources.
 * } catch (IOException e) {: Handles the exception if an I/O error occurs while closing the BufferedReader.
 * }: Closes the `
 */
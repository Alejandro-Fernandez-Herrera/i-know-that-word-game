package fileManager;

import java.io.*;

public class FileManager {
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    public String reader(){
        String text = "";

        try {
            fileReader = new FileReader("src/fileManager/files/fileText.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine();

            while(line != null){
                text += line;
                text += "\n";
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Estoy dentro de la excepcion");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            }  catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                System.out.println("Estoy dentro del finally");
                e.printStackTrace();
            }
        }

        return text;
    }

    public void writer(String line){
        try {
            String text = reader();
            text += line + "\n";
            fileWriter = new FileWriter("src/fileManager/files/fileText.txt");
            output = new BufferedWriter(fileWriter);
            output.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

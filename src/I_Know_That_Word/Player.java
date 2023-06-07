package I_Know_That_Word; // This is the package where the class is located

import java.io.*; // Import the java.io package to use the FileWriter and BufferedWriter classes
import java.util.ArrayList; // Import the java.util package to use the ArrayList class

/**
 * This class handles actions related to the player
 */
public class Player {

    private FileWriter fileWriter; // This object is used to write in a file
    private BufferedWriter output; // This object is used to write in a file
    private String username; // This variable stores the username
    public int level, position; // These variables store the level and the position of the player in the ArrayList
    public ArrayList<String> userList = new ArrayList<String>(); // This ArrayList stores the usernames
    public ArrayList<String> levelList = new ArrayList<String>(); // This ArrayList stores the levels

    /**
     * Constructor for the Player class
     */
    public Player() { // This method is called when a Player object is created
        FileManager fileManager = new FileManager(); // This object is used to read files
        //TODO: CREATE FILEMANAGER CLASS TO READFILE
        userList = fileManager.readFile("Players.txt"); // This method is in the FileManager class
        levelList = fileManager.readFile("fileText.txt"); // This method is in the FileManager class
        position = 0; // This variable stores the position of the player in the ArrayList
        username = ""; // This variable stores the username
        level = 1; // This variable stores the level
    }

    /**
     * Checks if the username is already registered
     */
    public boolean isRegistered(String name) {
        if (userList.contains(name)) { // This method is in the ArrayList class
            position = userList.indexOf(name); // This method is in the ArrayList class
            return true; // This statement is executed if the username is already registered
        } else { // This statement is executed if the username is not registered
            return false; // This statement is executed if the username is not registered
        }
    }

    /**
     * Returns the player's level
     */
    public int getLevel() {
        level = Integer.parseInt(levelList.get(position)); // This method is in the ArrayList class
        return level;
    }

    /**
     * Returns the username
     */
    public String getName()
    {
        return username; // This variable stores the username
    }

    /**
     * Checks if the name is empty or too short
     */
    public boolean isNameEmpty(String name) {
        if (name == null || name == "" || name.length() < 3) { // This statement is executed if the name is empty or too short
            return true;
        } else {
            return false;
        }
    }

    /**
     * Registers the player in the Users.txt and Levels.txt files
     */
    public void registerPlayer(String name, int levelCleared) {
        String user = name;
        int level = levelCleared;
        try {
            fileWriter = new FileWriter("src/I_Know_That_Word/files/fileText.txt", true); // This method is in the FileWriter class
            output = new BufferedWriter(fileWriter);
            output.newLine();
            output.write(name);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileWriter = new FileWriter("src/I_Know_That_Word/files/fileText.txt", true);
            output = new BufferedWriter(fileWriter);
            output.newLine();
            output.write(String.valueOf(levelCleared));
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
     * Updates the user's maximum level in the Levels.txt file
     */
    public void updateUser(String name, int levelCleared) {

        int indexToSave = 0;
        String valueToUpdate;
        indexToSave = userList.indexOf(name);

        valueToUpdate = String.valueOf(levelCleared);

        levelList.set(indexToSave, valueToUpdate);

        try {
            fileWriter = new FileWriter("src/I_Know_That_Word/files/data.txt", false);
            output = new BufferedWriter(fileWriter);
            for (int i = 0; i < levelList.toArray().length; i++) {
                output.write(String.valueOf(levelList.get(i)));
                if ((i + 1) < levelList.toArray().length) {
                    output.newLine();
                }
            }
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
}
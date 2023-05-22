package fileManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jugador {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] arg){
        //user to test the login
        registerUser("alejandro", "1234567890");

        //login - checkout if the user write whit uppercase or lowercase - fixit....
        //TODO: fix the login when the user write whit uppercase or lowercase
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        //check if the user are registred
        boolean isRegistered = checkUser(username, password); //crear metodo checkUser

        //verify the login is correct
        if(isRegistered){
            System.out.println("Welcome to I Know that word!!!");
    } else {
            System.out.println("Incorrect username or password, please try again or register if you are a new gamer");
        }
    }

    public static void registerUser(String username, String password){
        users.put(username, password);
        }

    public static boolean checkUser(String username, String password){
        if(users.containsKey(username)){
            if(users.get(username).equals(password)){
                return true;
            }
        }
        return false;
    }

}

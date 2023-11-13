import java.util.*;
import java.io.*;
import java.nio.file.*;

public class TaskPerf6 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filename = "C:\\records.txt";

        System.out.println("Press 1 to Register. Press 2 to Login");
        int input = scanner.nextInt();
        
        if (input == 1) {
            System.out.println("------ Register ------");

            System.out.println("Enter a username (alphanumeric only): ");
            String username = scanner.next();
            System.out.println("Enter a password (alphanumeric only): ");
            String password = scanner.next();

            if (username.matches("[a-zA-Z0-9]+") && password.matches("[a-zA-Z0-9]+")) {
                Path path = Paths.get(filename.toString()); 
                BufferedWriter writer = new BufferedWriter(new FileWriter("records.txt", true));
                writer.write(username + "," + password);
                writer.newLine();
                writer.close();
                System.out.println("Account has been Registered");
            } else {
                System.out.println("Invalid username or password.");
            }

        } else if (input == 2) {

            System.out.println("Enter your username: ");
            String username = scanner.next();
            System.out.println("Enter your password: ");
            String password = scanner.next();

            Path path = Paths.get(filename.toString()); 
            BufferedReader reader = new BufferedReader(new FileReader("records.txt"));
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    System.out.println(" You have logged in.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Incorrect username or password.");
            }
            reader.close();
        } else {
            System.out.println("Invalid input.");
        }
    }
}
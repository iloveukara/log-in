import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginLogger {
    private static final String FILE_PATH = "login_logs.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Store login information in a file
        storeLoginInfo(username, password);

        // Print the contents of the file
        printLoginInfo();

        scanner.close();
    }

    public static void storeLoginInfo(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String logEntry = String.format("Username: %s, Password: %s", username, password);
            writer.write(logEntry);
            writer.newLine();
            System.out.println("Login information stored successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing the login information: " + e.getMessage());
        }
    }

    public static void printLoginInfo() {
        try {
            String content = Files.readString(Paths.get(FILE_PATH));
            System.out.println("Login information stored in the file:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the login information: " + e.getMessage());
        }
    }
}

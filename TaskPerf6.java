import java.util.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class TaskPerf6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "c:\\records.txt";

        try {
            System.out.println("Press 1 to Register. Press 2 to Login.");
            System.out.println("1. Register");
            System.out.println("2. Log in");
            int input = scanner.nextInt();

            if (input == 1) {
                System.out.println("------- Register -------");

                System.out.println("Enter username: ");
                String Uname = scanner.nextLine();
                Uname = scanner.nextLine();
                System.out.println("Enter password: ");
                String Pword = scanner.nextLine();

                Path path = Paths.get(filename.toString());
                OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

                writer.write(Uname + "," + Pword);
                writer.newLine();
                System.out.println("Account has been registered.");
                writer.close();
                output.close();

                new TaskPerf6();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
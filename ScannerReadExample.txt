import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReadExample {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // Reading input from the user
        System.out.print("Enter your name: ");
        String name = inputScanner.nextLine();

        System.out.print("Enter your age: ");
        int age = inputScanner.nextInt();

        System.out.println("Hello " + name + ", you are " + age + " years old.");

        inputScanner.close();

        // Reading from a file using Scanner
        try {
            File file = new File("sample.txt"); // Ensure this file exists
            Scanner fileScanner = new Scanner(file);

            System.out.println("\nContents of sample.txt:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure 'sample.txt' exists.");
        }
    }
}

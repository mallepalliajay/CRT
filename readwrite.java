import java.io.*;
public class ReadWrite {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // Write to file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello from Java file handling!\n");
            writer.write("This file was written successfully.");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read from file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\nFile contents:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

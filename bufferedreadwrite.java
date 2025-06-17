import java.io.*;

public class BufferedReadWriteExample {
    public static void main(String[] args) {
        String fileName = "buffered_example.txt";

        // Writing to a file using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("This is the first line using BufferedWriter.");
            writer.newLine();  // Adds a new line
            writer.write("This is the second line.");
            System.out.println("File written successfully using BufferedWriter.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }

        // Reading from a file using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\nReading file using BufferedReader:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}

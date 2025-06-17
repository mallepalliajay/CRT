import java.io.File;

public class Fileclass {
    public static void main(String[] args) {
        File file = new File("test.txt");
        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getAbsolutePath());
    }
}

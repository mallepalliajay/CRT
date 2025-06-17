import java.util.Arrays;

public class SortStrings {
    public static void main(String[] args) {
        String[] words = {"banana", "apple", "cherry", "date", "elderberry"};

        // Sort the array alphabetically
        Arrays.sort(words);

        // Print the sorted array
        System.out.println("Sorted strings:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}

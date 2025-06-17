public class CountSwaps {

    public static int countSwaps(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2};
        int swaps = countSwaps(arr);
        System.out.println("Total Swaps: " + swaps);
    }
}

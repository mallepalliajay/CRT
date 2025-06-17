public class HeapChecker {

    // Check if array arr represents a max-heap
    public static boolean isMaxHeap(int[] arr) {
        int n = arr.length;

        // Start from root and go till the last parent node
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // If left child exists and is greater than parent
            if (left < n && arr[i] < arr[left]) {
                return false;
            }

            // If right child exists and is greater than parent
            if (right < n && arr[i] < arr[right]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] heapArray = {90, 15, 10, 7, 12, 2};
        System.out.println("Is max heap? " + isMaxHeap(heapArray));
    }
}

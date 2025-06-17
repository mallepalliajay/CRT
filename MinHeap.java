import java.util.ArrayList;

class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Insert a new value into the heap
    public void insert(int val) {
        heap.add(val);
        int currentIndex = heap.size() - 1;
        // Bubble up to maintain min heap property
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(parentIndex) > heap.get(currentIndex)) {
                swap(parentIndex, currentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    // Remove and return the min (root) element from the heap
    public int extractMin() {
        if (heap.size() == 0)
            throw new IllegalStateException("Heap is empty");

        int min = heap.get(0);

        // Move last element to root and remove last
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        // Heapify down from root
        heapifyDown(0);

        return min;
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        int smallest = index;

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Insert values
        minHeap.insert(10);
        minHeap.insert(4);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(0);
        minHeap.insert(8);

        System.out.println("MinHeap elements after insertions:");
        minHeap.printHeap();

        System.out.println("\nExtracting min repeatedly:");
        while (!minHeap.isEmpty()) {
            int min = minHeap.extractMin();
            System.out.println("Extracted Min: " + min);
            System.out.print("Heap now: ");
            minHeap.printHeap();
        }
    }
}

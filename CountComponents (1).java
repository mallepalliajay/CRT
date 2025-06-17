import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList;

    // Constructor to initialize the graph
    public Graph() {
        adjList = new HashMap<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    // Method to count the number of connected components
    public int countConnectedComponents() {
        Set<Integer> visited = new HashSet<>();
        int componentCount = 0;

        // Iterate over all nodes in the graph
        for (Integer node : adjList.keySet()) {
            if (!visited.contains(node)) {
                // Start DFS from the unvisited node
                dfs(node, visited);
                componentCount++;  // Increment count for each connected component
            }
        }

        return componentCount;
    }

    // DFS method to visit all nodes in a component
    private void dfs(int node, Set<Integer> visited) {
        visited.add(node);  // Mark the current node as visited

        // Visit all neighbors
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }
}

public class CountComponents {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        // Counting the connected components in the graph
        int numComponents = graph.countConnectedComponents();
        System.out.println("Number of connected components: " + numComponents);
    }
}

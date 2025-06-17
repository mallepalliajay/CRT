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
        adjList.get(v).add(u);  // For undirected graph
    }

    // Method to check if the graph has a cycle
    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        for (Integer node : adjList.keySet()) {
            if (!visited.contains(node)) {
                if (dfs(node, visited, -1)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle detected
    }

    // DFS method to detect cycle
    private boolean dfs(int current, Set<Integer> visited, int parent) {
        visited.add(current);

        // Explore all the neighbors
        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                // Recursively call DFS for the neighbor
                if (dfs(neighbor, visited, current)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and is not the parent, cycle is detected
                return true;
            }
        }
        return false;
    }
}

public class CycleDetection {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        // Checking for a cycle in the graph
        if (graph.hasCycle()) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }
    }
}

import java.util.*;

class Graph {
    // Adjacency list to represent the graph
    private Map<Integer, List<Integer>> adjList;

    // Constructor to initialize the adjacency list
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

    // Method to print the adjacency list
    public void printGraph() {
        for (Integer node : adjList.keySet()) {
            System.out.print(node + " -> ");
            for (Integer neighbor : adjList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class Graph {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding some edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        // Printing the adjacency list
        System.out.println("Graph as Adjacency List:");
        graph.printGraph();
    }
}

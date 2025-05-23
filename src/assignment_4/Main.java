package assignment_4;

import java.util.*;

class Vertex {
    String name;
    List<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}

class Edge {
    Vertex target;
    int weight;

    public Edge(Vertex target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

class UnweightedGraph {
    private Map<String, Vertex> vertices;

    public UnweightedGraph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String name) {
        vertices.putIfAbsent(name, new Vertex(name));
    }

    public void addEdge(String from, String to) {
        Vertex v1 = vertices.get(from);
        Vertex v2 = vertices.get(to);
        if (v1 != null && v2 != null) {
            v1.addEdge(new Edge(v2, 1)); // Unweighted edges
            v2.addEdge(new Edge(v1, 1)); // Undirected graph
        }
    }

    public void bfs(String start) {
        Vertex startVertex = vertices.get(start);
        if (startVertex == null) return;

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.name + " ");

            for (Edge edge : current.edges) {
                if (!visited.contains(edge.target)) {
                    visited.add(edge.target);
                    queue.add(edge.target);
                }
            }
        }
    }

    public void dfs(String start) {
        Vertex startVertex = vertices.get(start);
        if (startVertex == null) return;

        Set<Vertex> visited = new HashSet<>();
        dfsHelper(startVertex, visited);
    }

    private void dfsHelper(Vertex vertex, Set<Vertex> visited) {
        visited.add(vertex);
        System.out.print(vertex.name + " ");

        for (Edge edge : vertex.edges) {
            if (!visited.contains(edge.target)) {
                dfsHelper(edge.target, visited);
            }
        }
    }
}

class WeightedGraph {
    private Map<String, Vertex> vertices;

    public WeightedGraph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String name) {
        vertices.putIfAbsent(name, new Vertex(name));
    }

    public void addEdge(String from, String to, int weight) {
        Vertex v1 = vertices.get(from);
        Vertex v2 = vertices.get(to);
        if (v1 != null && v2 != null) {
            v1.addEdge(new Edge(v2, weight)); // Directed graph
        }
    }

    public void dijkstra(String start) {
        Vertex startVertex = vertices.get(start);
        if (startVertex == null) return;

        Map<Vertex, Integer> distances = new HashMap<>();
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        Set<Vertex> visited = new HashSet<>();

        for (Vertex vertex : vertices.values()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);
        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll();
            if (visited.contains(current)) continue;
            visited.add(current);

            for (Edge edge : current.edges) {
                if (!visited.contains(edge.target)) {
                    int newDist = distances.get(current) + edge.weight;
                    if (newDist < distances.get(edge.target)) {
                        distances.put(edge.target, newDist);
                        priorityQueue.add(edge.target);
                    }
                }
            }
        }

        // Print distances
        for (Map.Entry<Vertex, Integer> entry : distances.entrySet()) {
            System.out.println("Distance from " + start + " to " + entry.getKey().name + " is " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Unweighted Graph Example
        UnweightedGraph unweightedGraph = new UnweightedGraph();
        unweightedGraph.addVertex("A");
        unweightedGraph.addVertex("B");
        unweightedGraph.addVertex("C");
        unweightedGraph.addEdge("A", "B");
        unweightedGraph.addEdge("A", "C");
        unweightedGraph.addEdge("B", "C");

        System.out.println("BFS starting from A:");
        unweightedGraph.bfs("A");
        System.out.println("\nDFS starting from A:");
        unweightedGraph.dfs("A");

        // Weighted Graph Example
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addVertex("A");
        weightedGraph.addVertex("B");
        weightedGraph.addVertex("C");
        weightedGraph.addEdge("A", "B", 1);
        weightedGraph.addEdge("A", "C", 4);
        weightedGraph.addEdge("B", "C", 2);

        System.out.println("\nDijkstra's algorithm starting from A:");
        weightedGraph.dijkstra("A");
    }
}


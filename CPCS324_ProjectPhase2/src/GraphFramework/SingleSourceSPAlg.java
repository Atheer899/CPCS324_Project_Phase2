package GraphFramework;

import java.util.*;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }
    
    public static void computeDijkstraAlg(Graph graph, Vertex source) {
        // Initialize distances to all vertices as infinity except the source
        Map<Vertex, Integer> distances = new HashMap<>();
        Map<Vertex, Vertex> previous = new HashMap<>();
        for (Vertex vertex : graph.vertices.values()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
 
        // Initialize priority queue for vertices based on their distances
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        pq.add(source);
 
        // Initialize set to track visited vertices
        Map<Vertex, Boolean> visited = new HashMap<>();
        for (Vertex vertex : graph.vertices.values()) {
            visited.put(vertex, false);
        }
        
        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
 
            // Iterate through the adjacency list of the current vertex
            for (Edge edge : current.getAdjList()) {
                Vertex neighbor = edge.getTarget();
                int distance = distances.get(current) + edge.getWeight();
                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    previous.put(neighbor, current); // Update previous vertex
                    pq.remove(neighbor); // Remove and add the neighbor to update its position in the priority queue
                    pq.add(neighbor);
                    visited.put(neighbor, true); // Update visited
                }
                
            }
        }
        
        // if condition to only print when it is less than 1000 vertices
        // so when method makeGraph is computed, no need to print shortest paths
        if(graph.verticesNo <= 1000 ){
            // Print the shortest distances from the source vertex to all other vertices
            System.out.println("\nThe starting point location is " + source.getLabel());
            System.out.println("The routes from location " + source.getLabel() +" to the rest of the locations are:");
            
            for (Vertex vertex : graph.vertices.values()) {
                if(distances.get(vertex) == 0){
                    System.out.println("No path");
                    continue;
                }
                if (visited.get(vertex)) {
                    //System.out.print("Shortest path from " + source.getLabel() + " to " + vertex.getLabel() + ": ");
                    List<Vertex> path = new ArrayList<>();
                    Vertex v = vertex;
                    while (v != null) {
                        path.add(v);
                        v = previous.get(v);
                    }
                    Collections.reverse(path);
                    for(Vertex entry : path) {
                        entry.displayInfo();
                        System.out.print("-");
                    }
                    System.out.println(" --- route length: " + distances.get(vertex));
                }
            }
        }
    }
}

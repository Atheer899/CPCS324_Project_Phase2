package GraphFramework;

import java.io.*;
import java.util.*;

public abstract class Graph {
    public int verticesNo;
    public int edgeNo;
    public boolean isDigraph;
    public Map<String, Vertex> vertices;

    // Graph constructor
    public Graph() {
        this.verticesNo = 0;
        this.edgeNo = 0;
        this.isDigraph = false;
        this.vertices = new HashMap<>(); // Initialize vertices map
    }
    
    public Graph(int verticesNo, int edgeNo, boolean isDigraph){
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = false;
        this.vertices = new HashMap<>();
    }
    
    // Method to create vertex
    public abstract Vertex createVertex(String label) ;
        
    // Method to create an edge
    public abstract Edge createEdge(Vertex vertex1, Vertex vertex2, int w) ;
         
    // Method to add edge to the graph
    public Edge addEdge(String v, String u, int w) {
        Edge edge = null;
        Vertex vertex1;
        Vertex vertex2;
        // Ensure both vertices exist, creating them if necessary
        if (!vertices.containsKey(v)) {
            vertex1 = createVertex(v);
            vertices.put(v, vertex1);
            verticesNo++;
        }
        else{
            vertex1 = vertices.get(v);
        }
        if (!vertices.containsKey(u)) {
            vertex2 = createVertex(u);
            vertices.put(u, vertex2);
            verticesNo++;
        }
        else{
            vertex2 = vertices.get(u);
        }
        
        // Ensure both vertices exist
        if (vertices.containsKey(v) && vertices.containsKey(u)) {
            vertex1 = vertices.get(v);
            vertex2 = vertices.get(u);
            // Create edge and add it to adjacency list of source vertex
            edge = createEdge(vertex1, vertex2, w);
            vertex1.getAdjList().add(edge);
            // If graph is undirected, also add the reverse edge
            if (!isDigraph) {
                Edge edgeRev = createEdge(vertex2, vertex1, w);
                vertex2.getAdjList().add(edgeRev);
                edgeNo += 2; // Two edges for undirected graph
            } else {
                edgeNo++; // One edge for directed graph
            }
        }    
        
        return edge;
        
    }

    // Method to create a random graph
    public void makeGraph(int v, int e) {
        verticesNo = v;
        edgeNo = e;
        Random rand = new Random();

        // Create vertices
        for(int i=0; i<v; i++) {
            // Ensure the vertex is not already in the graph
            Vertex newVertex = null;
            if (!vertices.containsKey(String.valueOf(i))) {
                newVertex = createVertex(String.valueOf(i));
                vertices.put(String.valueOf(i), newVertex);
                verticesNo++;
            } else {
                newVertex = vertices.get(String.valueOf(i));
            }
        }

        List<String> keys = new ArrayList<>(vertices.keySet());

        // Create edges
        for(int i=0; i<e; i++) {
            // Randomly select source and destination vertices
            String source = keys.get(rand.nextInt(v));
            String destination = keys.get(rand.nextInt(v));

            // Ensure that source and destination vertices are not the same
            while (destination.equals(source)) {
                destination = keys.get(rand.nextInt(v));
            }

            // Add edge with random weight
            addEdge(source, destination, rand.nextInt(20) + 1);
        }
    }

    // Method to read graph from a file
    public void readGraphFromFile(File fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // Read and process first line to determine if graph is directed or not
        String line = reader.readLine();
        this.isDigraph = line.contains("1");

        // Read and process second line to get number of vertices and edges
        line = reader.readLine();
        String[] parts = line.split(" ");
        int vertices = Integer.parseInt(parts[0]);
        int edges = Integer.parseInt(parts[1]);

        // Read and process remaining lines to get edges
        for(int i=0; i<edges; i++) {
            line = reader.readLine();
            parts = line.split(" ");
            String vertex1 = parts[0];
            String vertex2 = parts[1];
            int weight = Integer.parseInt(parts[2]);
            addEdge(vertex1, vertex2, weight); // Add edge to graph
        }

        reader.close(); // Close the reader
    }
}

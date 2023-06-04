
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class AFRouteMap extends Graph{
    
    //AFRouteMap constructor
    public AFRouteMap(){
        this.verticesNo = 0;
        this.edgeNo = 0;
        this.isDigraph = false;
        this.vertices = new HashMap<>();
    }
    
    // AFRouteMap Constructor
    public AFRouteMap(int verticesNo, int edgeNo, boolean isDigraph){
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        this.vertices = new HashMap<>();
    }
    
    // Method to create vertex (Location)
    @Override
    public Vertex createVertex(String label) {
        return new Location(label);
    }

    // Method to create edge (Route)
    @Override
    public Edge createEdge(Vertex vertex1, Vertex vertex2, int w) {
        return new Route(vertex1, vertex2, w);
    }
    
    // Method to add an edge (Route)
    @Override
    public Edge addEdge(String v, String u, int w){
        return super.addEdge(v, u, w);
    }
    
    // Method to create random graph
    @Override
    public void makeGraph(int v, int e){
        super.makeGraph(v, e);
    }
    
    // Method to read graph from a file
    @Override
    public void readGraphFromFile(File fileName)throws IOException{
        super.readGraphFromFile(fileName);
    }

    
}

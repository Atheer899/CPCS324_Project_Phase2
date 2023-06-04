package GraphFramework;

import java.util.*;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    
    public DBAllSourceSPAlg(Graph graph) {
        super(graph);
    }

    public void computeDijkstraBasedSPAlg() {
        for(Map.Entry<String, Vertex> vertex : graph.vertices.entrySet()){
            SingleSourceSPAlg.computeDijkstraAlg(graph, vertex.getValue()) ;               
        }          
    }
    
}
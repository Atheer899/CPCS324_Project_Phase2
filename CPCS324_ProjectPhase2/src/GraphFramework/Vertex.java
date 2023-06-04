package GraphFramework;

import java.util.*;

public class Vertex {  
    private String label;
    private boolean isVisited;
    private List<Edge> adjList;
    
    public Vertex(){
        adjList = new ArrayList<>();
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }

    public boolean getIsVisited() {
        return this.isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public List<Edge> getAdjList() {
        return this.adjList;
    }

    public void setAdjList(List<Edge> adjList) {
        this.adjList = adjList;
    }
    
    // Vertex constructor
    public Vertex(String label){
        this.label = label;
        this.isVisited = false;
        adjList = new ArrayList<>(); // Initialize adjacency list for this vertex
    }

    // Method to display vertex information
    public void displayInfo(){
        
    }
}
    
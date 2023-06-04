package GraphFramework;

public class Edge { 
    private Vertex source;
    private Vertex target;
    private Vertex parent;
    private int weight;

    // Edge constructor
    public Edge(Vertex source, Vertex target, int weight){
        this.source = source;
        this.target = target;
        this.weight = weight;
        parent = new Vertex();
    }

    public Vertex getSource() {
        return this.source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return this.target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public Vertex getParent() {
        return this.parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    // Method to display edge information
    public void displayInfo(){
        System.out.print(" route length: " + getWeight());
    }  
    
}
    


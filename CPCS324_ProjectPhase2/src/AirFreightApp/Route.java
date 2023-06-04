
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

public class Route extends Edge{
    
    // Route constructor
    public Route(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }
    
    // Method to display Edge (Route) info
    @Override
    public void displayInfo(){
        super.displayInfo();
    }
}

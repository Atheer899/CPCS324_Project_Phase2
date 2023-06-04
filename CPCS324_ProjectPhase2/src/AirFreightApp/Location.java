
package AirFreightApp;

import GraphFramework.Vertex;

public class Location extends Vertex{
    // data feild 
    private String city;

    // Location constructor
    public Location(String city) {
        super(city);
        this.city = city; 
    }
    
    // Method to display Vertex (Location) info
    @Override
    public void displayInfo(){
        System.out.print("loc. " + city + ": city " + ((int)city.charAt(0) - 64 ) );
    }
    
}

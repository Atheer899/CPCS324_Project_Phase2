
package AirFreightApp;

import GraphFramework.DBAllSourceSPAlg;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AirFreightApp {

    public static void main(String[] args) throws IOException {
        // Scanner object to read data from input file
        Scanner input = new Scanner(System.in);
        int reqNumber = 0;
        
        while(reqNumber != 3) {
            // Header of the program
            System.out.println("\n-----------------------------Air Freight App-----------------------------");
            System.out.println("\t    Compute shortest paths using Dijkstra algorithm   ");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Requirement 1. Use readGraphFromFile function");
            System.out.println("Requirement 2. Use makeGraph function");
            System.out.println("Requirement 3. Exit");
        
            // user will choose a requirement number and then read the number and save it in a variable
            System.out.print("\nPlease choose the function you want to use (enter 1, 2 , or 3 only) : ");
            reqNumber = input.nextInt();
            
            // a while loop to make sure that the user entered a valid number
            while(reqNumber != 1 && reqNumber != 2 && reqNumber != 3){
                System.out.println("Invalid number. Please Try Again.");
                System.out.print("\nPlease choose the function you want to use (enter 1, 2 , or 3 only) : ");
                reqNumber = input.nextInt();
            }

            // AFRouteMap object
            AFRouteMap graph = new AFRouteMap();
            // DBAllSourceSPAlg object
            DBAllSourceSPAlg d;
            
            // requirement 1: ---> using method readGraphFromFile
            if(reqNumber == 1){
                System.out.println("\n-----------------Requirement 1. readGraphFromFile-----------------");
                // input file to read data from it
                File inputFile = new File("input.txt");

                // Check if the input file does exist
                if(!inputFile.exists()){
                    System.out.println("The input file does not exist."); // print a message
                    System.exit(0); // exit the program
                }
                
                // readGraph method
                graph.readGraphFromFile(inputFile); 
                // DBAllSourceSPAlg object
                d = new DBAllSourceSPAlg(graph);
                // compute and print shortest path 
                d.computeDijkstraBasedSPAlg();   
            }
            
            // create vertexNum and edgeNum to save data
            int vertexNum = 0;
            int edgeNum = 0;
            
            // requirement 2: ---> using makeGraph method
            if(reqNumber == 2){ // print the following
                System.out.println("\n---------------------Requirement 2. makeGraph---------------------");
                System.out.println("The possible cases for vertices(n) and edges(m): ");
                System.out.println("\nFirst Graph:   n=2000, m=10000\nSecond Graph:  n=3000, m=15000"
                                + "\nThird Graph:   n=4000, m=20000");
                System.out.println("Fourth Graph:  n=5000, m=25000\nFifth Graph:   n=6000, m=30000\n");
                System.out.print("Please choose a valid graph number (from 1 to 5): ");
                
                // the user will choose case number and it will be saved here
                int graphNum = input.nextInt();
                
                // while loop to ensure that the user has entered a valid number 
                // if not, enter while loop and ask user to enter it again until the user enters a valid number
                while(1 > graphNum || graphNum > 5){
                    System.out.println("Invalid Graph Number. Please Try Again.");
                    System.out.print("\nPlease choose a valid graph number (from 1 to 5): ");
                    graphNum = input.nextInt();
                }
                
                // switch statement for graph cases
                switch (graphNum) {
                    case 1: // First G1raph:   n=2000, m=10000
                        vertexNum = 2000;
                        edgeNum = 10000;
                        break;
                    case 2: // Second Graph:  n=3000, m=15000
                        vertexNum = 3000;
                        edgeNum = 15000;
                        break;
                    case 3: // Third Graph:   n=4000, m=20000
                        vertexNum = 4000;
                        edgeNum = 20000;
                        break;
                    case 4: // Fourth Graph:  n=5000, m=25000
                        vertexNum = 5000;
                        edgeNum = 25000;
                        break;
                    case 5: // Fifth Graph:   n=6000, m=30000 
                        vertexNum = 6000;
                        edgeNum = 30000;
                        break;
                    
                }
                
                System.out.println("\nThe air freight shortest path generated by Dijkstra Algorithm");
                // make random graph 
                graph.makeGraph(vertexNum, edgeNum);
                d = new DBAllSourceSPAlg(graph);
                double startTime = System.currentTimeMillis(); // a variable to record starting time of the algoritnm
                d.computeDijkstraBasedSPAlg(); // call method to compute Dijkstra
                double finishtTime = System.currentTimeMillis(); // a variable to record finishing time of the algoritnm
                double totalTime = finishtTime - startTime; // calculate total time by subtracting startTime from finishTime
                System.out.println("The running time of the dijkstra Algorithm is " + totalTime + " ms"); // print time
            }   
        }
        System.out.println("\nThank you for using Air Freight App, Good Bye!\n"); // ending message
        input.close(); // close input file
    }
    
}

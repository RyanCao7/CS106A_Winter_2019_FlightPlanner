/*
 * File: FlightPlannerServer.java
 * ---------------------
 * A server program that, when run, reads in information
 * about available flights from a data file, and then listens
 * for incoming network requests.  This program can respond to
 * two types of requests:
 * 
 * "getAllCities" -> we send back a list of all cities
 * "getDestinations" -> (needs parameter "city") we send back a
 *                      list of all cities reachable from the
 *                      provided city and the travel time to get 
 *                      there.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class FlightPlannerServer extends ConsoleProgram 
    implements SimpleServerListener {

    /* The port number where we listen for requests */
    private static final int PORT = 8080;
    
    /* The name of the file containing our flight data */
    private static final String FLIGHT_DATA_FILE = "flights.txt";
    
    /* The server object that we use to listen for requests */
    private SimpleServer server;
    
    //we want to create a mapping of a String for start city to an arrayList of Flights
    private HashMap<String, ArrayList<Flight>> flightMap;
    
   
    public void run() {
    	flightMap = new HashMap<String, ArrayList<Flight>>();
        server = new SimpleServer(this, PORT); // Initialize a server
        server.start(); // Start the server
        println("Starting server...");
    }

    public String requestMade(Request request) {
        String cmd = request.getCommand();
        
        if (cmd.equals("getAllCities")) {
            // TODO: Fill this in
        	return "";
        } else if (cmd.equals("getDestinations")) {
            // TODO: Fill this in
        	return "";
        }
        return "Error, cannot process request: " + request;
    }

    private void readFlightData(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.length() != 0) {
                    // Make sure the line isn't blank
                    processLine(line);
                }
            }
            fileScanner.close();
        } catch (IOException ex) {
            throw new ErrorException(ex);
        }
    }

    private void processLine(String line) {
    	// What should we do here?
    	Flight flight = new Flight(line);
    	//add to an array list
    	flightMap.put(flight.getSourceFlight(), value)
    	//constructor takes in a string of source, destination, time
    }
}
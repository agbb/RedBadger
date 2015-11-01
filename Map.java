import java.util.ArrayList;

public class Map {

    private int x_size;
    private int y_size;
    private ArrayList<MarkedLocation> MarkedLocations;

    // creates a new map using the user input
    public Map(String input) {

	String[] input_values = input.split("\\s+");

	// sets up the grid size of the map
	x_size = Integer.parseInt(input_values[0]);
	y_size = Integer.parseInt(input_values[1]);
	// creates a new empty list of locations robots have fallen
	MarkedLocations = new ArrayList<MarkedLocation>();

    }

    // A robot has fallen at this location, add it to the list of scent marked
    // locations
    private void createMarkedLocation(int x_value, int y_value) {
	MarkedLocations.add(new MarkedLocation(x_value, y_value));
    }

    // Check if a location contains a scent from a previous robot.
    public boolean checkMarked(int x_value, int y_value) {

	for (int i = 0; i < MarkedLocations.size(); i++) {
	    MarkedLocation currentLocation = MarkedLocations.get(i);

	    if ((currentLocation.x_value == x_value)
		    && (currentLocation.y_value == y_value)) {
		// locations matched, location is marked
		return true;
	    }
	}
	// location has not been marked yet.
	return false;
    }

    // checks if a robot has fallen off the map and is lost.
    public boolean checkFallen(int x_value, int y_value) {

	if ((x_value > x_size) || (y_value > y_size)) {
	    // robot fallen, add scent to list of marked locations
	    createMarkedLocation(x_value, y_value);
	    return true;

	} else if ((x_value < 0) || (y_value < 0)) {

	    // robot has fallen, add scent to list of marked locations
	    createMarkedLocation(x_value, y_value);
	    return true;

	} else {
	    // robot has not fallen
	    return false;
	}
    }

}

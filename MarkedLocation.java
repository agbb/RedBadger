public class MarkedLocation {

    int x_value;
    int y_value;

    // creates a new marked location at the location x_value, y_value
    public MarkedLocation(int x_value, int y_value) {
	this.x_value = x_value;
	this.y_value = y_value;

    }

    // returns x value of marked location
    public int getX_value() {
	return x_value;
    }

    // returns y value of marked location
    public int getY_value() {
	return y_value;
    }

}

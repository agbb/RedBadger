public class Robot {

    private int x_loc;
    private int y_loc;
    private Orientation orientation;
    boolean lost;
    private String instructions;
    private int previous_x;
    private int previous_y;

    // create a new robot form user input of starting location and move
    // instructions.
    public Robot(String start_input, String moves_input) {

	try {
	    String[] input_values = start_input.split(" ");
	    // set initial location and orientation
	    x_loc = Integer.parseInt(input_values[0]);
	    y_loc = Integer.parseInt(input_values[1]);
	    orientation = Orientation.valueOf(input_values[2]);
	} catch (NumberFormatException e) {
	    System.out.println("Invalid input for robot starting location");
	    System.exit(0);
	} catch (IllegalArgumentException e) {
	    System.out
	    .println("Invalid input for robt starting location orientation");
	    System.exit(0);
	}

	this.instructions = moves_input;
    }

    // check if robot has fallen
    public boolean isLost() {
	return lost;
    }

    // set if robot has fallen
    public void setLost(boolean lost) {
	this.lost = lost;
    }

    // get X location of robot on grid.
    public int getX_loc() {
	return x_loc;
    }

    // get Y location of robot on grid.
    public int getY_loc() {
	return y_loc;
    }

    // pass move instruction into robot
    public void move(char move) {
	// store previous location in case this move is rejected
	previous_x = x_loc;
	previous_y = y_loc;

	switch (move) {

	// turn left, adjust orientation
	case ('L'):
	    if (orientation == Orientation.N) {
		// set orientation back to west
		orientation = Orientation.values()[3];
	    } else {
		// increment orientation anticlockwise.
		orientation = Orientation.values()[orientation.ordinal() - 1];
	    }
	break;

	// turn Right, adjust orientation
	case ('R'):
	    if (orientation == Orientation.W) {
		// set orientation back to north
		orientation = Orientation.values()[0];
	    } else {
		// increment orientation anticlockwise.
		orientation = Orientation.values()[orientation.ordinal() + 1];
	    }

	break;

	// move forwards, adjust location depending on orientation
	case ('F'):

	    switch (orientation) {
	    case N:
		y_loc++;
		break;
	    case E:
		x_loc++;
		break;
	    case S:
		y_loc--;
		break;
	    case W:
		x_loc--;
		break;
	    default:
		break;

	    }

	break;

	default:
	    System.out.println("Invalid robot instructions, cannot continue");
	    System.exit(0);

	}
    }

    // return the instructions robot was given
    public String getInstrctions() {
	return this.instructions;

    }

    // move robot to previous location in case a move was rejected.
    public void resetMove() {
	x_loc = previous_x;
	y_loc = previous_y;
    }

    // check orientation of robot.
    public Orientation getOrientation() {
	return orientation;
    }

    // returns a string in the form: "x_loc y_loc orientation"
    @Override
    public String toString() {
	return this.x_loc + " " + this.y_loc + " " + orientation;
    }

}

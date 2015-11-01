import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// collects user input
	System.out.println("Enter upper right map co-ordinates:");
	Scanner scan = new Scanner(System.in);

	// create a new map, pass user input into it.
	String map_input = scan.nextLine();
	Map map = new Map(map_input);

	// create a new list of all robots on this map.
	ArrayList<Robot> robots = new ArrayList<Robot>();

	// add more robots to this while true.
	boolean repeat = true;
	while (repeat) {
	    // get robot starting location
	    System.out.println("Enter Robot Starting Location");
	    String robot_start_input = scan.nextLine();

	    // get robot instructions
	    System.out.println("Enter Movement instructions");
	    String moves_input = scan.nextLine();
	    Robot robot = new Robot(robot_start_input, moves_input);
	    robots.add(robot);

	    // ask user if more robots to be added.
	    System.out.println("Add more robots? (Y/N)");
	    String add_more_input = scan.nextLine();
	    if (add_more_input.equals("N")) {
		// all robots added.
		repeat = false;
		scan.close();
	    }
	}

	// create a new move calculator with the objects created from user
	// input.
	MoveCalculator calc = new MoveCalculator(map, robots);
	// process the instructions on each robot.
	calc.processMoves();

    }
}

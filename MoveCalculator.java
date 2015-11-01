import java.util.ArrayList;

public class MoveCalculator {

    private Map map;
    private ArrayList<Robot> robots;

    // set up the move calcualtor with input from user in main method.
    public MoveCalculator(Map map, ArrayList<Robot> robots) {
	super();
	this.map = map;
	this.robots = robots;

    }

    // process the moves of the robots one by one, in the order they were
    // entered.
    public void processMoves() {

	// move through list of robots, get instruction list for each one and
	// seperate it.
	for (int i = 0; i < robots.size(); i++) {
	    Robot robot = robots.get(i);
	    char[] instructions = robot.getInstrctions().toCharArray();

	    // instruct robot to execute each instruction.
	    for (int j = 0; j < instructions.length; j++) {

		robot.move(instructions[j]);

		if (map.checkMarked(robot.getX_loc(), robot.getY_loc())) {
		    // this square was scent marked, robot aborts move!
		    robot.resetMove();

		} else if (map.checkFallen(robot.getX_loc(), robot.getY_loc())) {
		    // robot fell, print that robot is lost and new marked
		    // location is created.
		    robot.resetMove();
		    System.out.println(robot.toString() + " LOST");
		    robot.lost = true;
		    break;

		}
	    }
	    if (!robot.lost) {
		// robot survived, print out location
		System.out.println(robot.toString());
	    }
	}
    }
}

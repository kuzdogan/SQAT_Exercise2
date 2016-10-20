
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 138
// Finish time: 16:32

public class PlanetExplorer {
	private Planet planet;
	private Vehicle vehicle;
	private String report;
	
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
	public PlanetExplorer(int x, int y, String obstacles){
		planet = new Planet(x, y);
		vehicle = new Vehicle(planet);
		report = vehicle.report();
		extractObstacles(obstacles);
	}
	public String getReport() {
		return report;
	}
	
	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example: 
	 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
	 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
	 
	 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
	 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */
	public String executeCommand(String command){
		for (int i = 0; i < command.length(); i++) {
			String currCommand = command.substring(i, i+1);
			vehicle.move(currCommand);
		}
		report = vehicle.report();
		return report;
	}
	
	// Iterates over the obstacle string add adds found
	// obstacles to the obstacles list.
	public void extractObstacles(String obstacles){
		// Iterate over the string
		for (int i = 0; i < obstacles.length(); i++) {
			int xPos, yPos;
			if(obstacles.charAt(i) == '('){
				int xStart = i+1;
				while(obstacles.charAt(++i) != ',');
				int xEnd = i;
				
				int yStart = ++i;
				while(obstacles.charAt(++i) != ')');
				int yEnd = i;
				
				String xStr = obstacles.substring(xStart, xEnd);
				String yStr = obstacles.substring(yStart, yEnd);
				
				xPos = Integer.parseInt(xStr);
				yPos = Integer.parseInt(yStr);
				
				planet.addObstacle(new Obstacle(xPos,yPos));
			}
		}
	}
	
	// Returns the i'th obstacle
	public Obstacle getObstacle(int i){
		return planet.getObstacles().get(i);
	}
}

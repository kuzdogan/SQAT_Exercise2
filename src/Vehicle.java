import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	private int x,y;
	String direction;
	List<Obstacle> discovered;
	Planet planet;
	
	public Vehicle(Planet planet){
		this.planet = planet;
		x=0;
		y=0;
		direction = "N";
		discovered = new ArrayList<Obstacle>();
	}
	
	public void turnLeft(){
		if(direction.equals("N"))
			direction = "W";
		else if (direction.equals("W"))
			direction = "S";
		else if (direction.equals("S"))
			direction = "E";
		else if (direction.equals("E"))
			direction = "N";
	}
	
	public void turnRight(){
		if(direction.equals("N"))
			direction = "E";
		else if (direction.equals("E"))
			direction = "S";
		else if (direction.equals("S"))
			direction = "W";
		else if (direction.equals("W"))
			direction = "N";
	}
	
	public void move(String dir){
		if(dir.equals("r"))
			turnRight();
		if(dir.equals("l"))
			turnLeft();
		
		// Look-up int for checking the coordinate to be moved
		// 	required for movement on the edges.
		int lookUp;
		
		if(dir.equals("f")){
			if(direction.equals("N")){
				// Set look up
				lookUp = y+1;
				
				// if on the edge
				if(y==planet.getHeight()-1)
					lookUp=0; // don't set y yet, check obstacles
				
				if(!isThereAnObstacle(x, lookUp))
						y = lookUp; // move if no obstacle
				else
					discoverObstacle(new Obstacle(x,lookUp));
			}
			if(direction.equals("E")){
				lookUp = x+1;
				if(y==planet.getWidth()-1)
					lookUp=0;
				if(!isThereAnObstacle(lookUp, y))
						x = lookUp;
				else
					discoverObstacle(new Obstacle(lookUp,y));
			}
			if(direction.equals("S")){
				lookUp = y-1;
				if(y==0)
					lookUp=planet.getHeight()-1;
				if(!isThereAnObstacle(x, lookUp))
					y = lookUp;
				else
					discoverObstacle(new Obstacle(x,lookUp));
			}
			if(direction.equals("W")){
				lookUp = x-1;
				if(x==0)
					lookUp=planet.getWidth()-1;
				if(!isThereAnObstacle(lookUp, y))
						x = lookUp;
				else
					discoverObstacle(new Obstacle(lookUp,y));
			}
		}
		else if(dir.equals("b")){
			if(direction.equals("N")){
				lookUp = y-1;
				if(y==0)
					lookUp=planet.getHeight()-1;
				if(!isThereAnObstacle(x, lookUp))
						y = lookUp;
				else
					discoverObstacle(new Obstacle(x,lookUp));
			}
			if(direction.equals("E")){
				lookUp = x-1;
				if(x==0)
					lookUp=planet.getWidth()-1;
				if(!isThereAnObstacle(lookUp, y))
					x = lookUp;
				else
					discoverObstacle(new Obstacle(lookUp,y));
			}
			if(direction.equals("S")){
				lookUp = y+1;
				if(y==planet.getHeight()-1)
					lookUp=0;
				if(!isThereAnObstacle(x, lookUp))
						y = lookUp;
				else
					discoverObstacle(new Obstacle(x,lookUp));
			}
			if(direction.equals("W")){
				lookUp = x+1;
				if(x==planet.getWidth()-1)
					lookUp=0;
				if(!isThereAnObstacle(lookUp, y))
						x = lookUp;
				else
					discoverObstacle(new Obstacle(lookUp,y));
			}
		}
	}
	public boolean isThereAnObstacle(int x, int y){
		Obstacle temp = new Obstacle(x,y);
		if(planet.getObstacles().contains(temp))
			return true;
		return false;
	}
	public String getPosition(){
		return "(" + x + "," + y + "," + direction + ")";
	}
	
	public String report(){
		String report = getPosition();
		for (int i = 0; i < discovered.size(); i++) {
			report += discovered.get(i).toString();
		}
		return report;
	}
	
	public void discoverObstacle(Obstacle o){
		if(!discovered.contains(o))
			discovered.add(o);
	}
}

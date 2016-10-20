import java.util.ArrayList;
import java.util.List;

public class Planet {
	private int width;
	private int height;
	private List<Obstacle> obstacles;
	
	public Planet(int x, int y){
		width = x;
		height = y;
		obstacles = new ArrayList<Obstacle>();
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(List<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}
	
	public void addObstacle(Obstacle o){
		obstacles.add(o);
	}
}

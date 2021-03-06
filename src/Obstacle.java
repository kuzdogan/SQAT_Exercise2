
public class Obstacle {
	private int x;
	private int y;
	
	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	// Override equals method for List.contains() method
	@Override
	public boolean equals(Object o){
		if (o.getClass() != Obstacle.class)
			return false;
		Obstacle obst = (Obstacle) o;
		if(obst.getX() == x && obst.getY() == y)
			return true;
		return false;
	}
	
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}

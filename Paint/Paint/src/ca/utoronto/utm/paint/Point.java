package ca.utoronto.utm.paint;

/**
 * A Point represents a location (x,y) in coordinate space. 
 * Where x, y are integers.
 * 
 */
public class Point {
	private int x, y;
	
	/**
	 * Initialize a point at location (x,y).
	 * @param x x-coordinate of the point
	 * @param y y-coordinate of the point
	 */
	Point(int x, int y){
		this.x=x; this.y=y;
	}
	
	/**
	 * @return x-coordinate of the point
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set the x-coordinate of the point
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y-coordinate of the point
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the y-coordinate of the point
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}

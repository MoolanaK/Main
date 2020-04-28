package ca.utoronto.utm.paint;

/**
 * A Square is a Rectangle but with all sides of equal length.
 * @author Devamardeep Hayatpur
 *
 */
public class Square extends Rectangle {
	
	/**
	 * Create a Square defined by points startPoint and endPoint.
	 * endPoint is adjusted to ensure the two points lie on a square.
	 * @param startPoint A point in the square.
	 * @param endPoint A point in the rectangle that encapsulates the square.
	 */
	public Square (Point startPoint, Point endPoint) {
		super(startPoint, endPoint);
		this.setEndPoint(endPoint);
	}
	
	@Override
	public void setEndPoint(Point end) {
		int dx = end.getX() - startPoint.getX();
		int dy = end.getY() - startPoint.getY();
		
		// The size of the length of each side should be the maximum of width and height
		int size = Math.max(Math.abs(dx), Math.abs(dy));
		
		// Set the end point x to be 'size' away from start point x in the direction of dx
		end.setX(startPoint.getX() + (int) Math.signum(dx)*size);
		
		// Set the end point y to be 'size' away from start point y in the direction of dy
		end.setY(startPoint.getY() + (int) Math.signum(dy)*size);
		
		this.endPoint = end;
	}
}

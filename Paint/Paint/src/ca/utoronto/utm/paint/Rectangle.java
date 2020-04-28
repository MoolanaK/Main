package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * A Rectangle class defines a rectangle between a start point and an end
 * point.
 * @author Devamardeep Hayatpur
 *
 */
public class Rectangle extends Shape {
	
	protected Point startPoint;
	protected Point endPoint;
	
	/**
	 * Create a rectangle defined by points startPoint and endPoint
	 * @param startPoint A point in the rectangle
	 * @param endPoint A point in the rectangle
	 */
	public Rectangle(Point startPoint, Point endPoint){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	/**
	 * @return startPoint
	 */
	public Point getStartPoint() {
		return startPoint;
	}
	
	/**
	 * Set the value of endPoint
	 * @param endPoint
	 */
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public void stroke(Graphics2D g2d) {
		int x = Math.min(endPoint.getX(), startPoint.getX());
		int y = Math.min(endPoint.getY(), startPoint.getY());
		
		int width = Math.abs(endPoint.getX() - startPoint.getX());
		int height = Math.abs(endPoint.getY() - startPoint.getY());
		
		g2d.drawRect(x, y, width, height);
	}

	@Override
	public void fill(Graphics2D g2d) {
		int x = Math.min(endPoint.getX(), startPoint.getX());
		int y = Math.min(endPoint.getY(), startPoint.getY());
		
		int width = Math.abs(endPoint.getX() - startPoint.getX());
		int height = Math.abs(endPoint.getY() - startPoint.getY());
		
		g2d.fillRect(x, y, width, height);
	}
}

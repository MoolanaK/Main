package ca.utoronto.utm.paint;

import java.awt.*;

/**
 * A Circle class defines a circle with a center point and a 
 * radius.
 *
 */
public class Circle extends Shape {
	private Point center;
	private int radius;
	
	/**
	 * Initiate a circle with a center and a radius.
	 * @param center Center point of the circle
	 * @param radius Radius of the circle
	 */
	public Circle(Point center, int radius){
		this.center = center;
		this.radius = radius;
	}

	/**
	 * @return center
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * Set the value of center
	 * @param center
	 */
	public void setCenter(Point center) {
		this.center = center;
	}

	/**
	 * @return radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Set the value of radius
	 * @param radius
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void stroke(Graphics2D g2d) {
		g2d.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
	}

	@Override
	public void fill(Graphics2D g2d) {
		g2d.fillOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
	}
}

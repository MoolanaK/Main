package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.awt.Polygon;

public class RegularPolygon extends Shape {
	
	private Point center;
	
	private Point current;
	
	private int numSides;
	
	public RegularPolygon(Point center, Point current, int numSides) {
		this.center = center;
		this.current = current;
		this.numSides = numSides;
	}
	
	/**
	 * @return center
	 */
	public Point getCentre() {
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
	 * @return current
	 */
	public Point getCurrent() {
		return current;
	}
	
	/**
	 * Set the value of current
	 * @param current
	 */
	public void setCurrent(Point current) {
		this.current = current;
	}
	
	/**
	 * Add the change integer to the number of sides of the polygon.
	 * Ensures that the number of sides are greater than or equal to 3.
	 * @param change Integer to add to the number of sides
	 */
	public void addToNumSides(int change) {
		this.numSides = Math.max(this.numSides + change, 3);
	}
	
	/**
	 * @return a polygon equivalent to this regular polygon
	 */
	public Polygon getPolygon() {
		// Algorithm for drawing a regular polygon obtained from:
		// https://stackoverflow.com/questions/7198144/how-to-draw-a-n-sided-regular-polygon-in-cartesian-coordinates
		
		Polygon p = new Polygon();
		
		int dx = current.getX() - center.getX();
		int dy = current.getY() - center.getY();
		
		int radius = (int) Math.sqrt(dx*dx + dy*dy);
		
		double theta = 2 * Math.PI / numSides;
		
		// I would like to offset the polygon relative to the angle between the center
		// and the current point in order for it to follow the cursor.
		double offset = Math.atan2(dy, dx);
	
		for (int i = 0; i < numSides; ++i) {
		    int x = (int) (radius * Math.cos(theta * i + offset)) + center.getX();
		    int y = (int) (radius * Math.sin(theta * i + offset)) + center.getY();
		    p.addPoint(x, y);
		}
		
		return p;
	}
	
	@Override
	public void stroke(Graphics2D g2d) {
		g2d.draw(getPolygon());
	}

	@Override
	public void fill(Graphics2D g2d) {
		g2d.fill(getPolygon());
	}
}

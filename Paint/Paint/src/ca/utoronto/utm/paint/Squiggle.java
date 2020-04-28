package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * A Squiggle is a continuous line defined by a dense set of points.
 * 
 */
public class Squiggle extends Shape {
	
	private ArrayList<Point> points = new ArrayList<Point>();
	
	/**
	 * Add a point to the Squiggle
	 * @param p Point to add
	 */
	public void addPoint(Point p) {
		points.add(p);
	}

	@Override
	public void stroke(Graphics2D g2d) {
		for(int i=0; i < points.size() - 1; i++){
			Point p1 = points.get(i);
			Point p2 = points.get(i+1);
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}

	@Override
	public void fill(Graphics2D g2d) {
		stroke(g2d);
	}
}

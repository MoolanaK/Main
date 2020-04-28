package ca.utoronto.utm.paint;

import java.awt.*;

/**
 * A Oval class defines an oval with a start Point and an end Point
 * @author Devin Gopaul
 * 
 */
public class Oval extends Shape {
	private Point start;
	private Point end;
	
	/**
	 * Initiate an oval with a start Point and an end Point.
	 * @param start the Point at which the oval begins
	 * @param end the Point at which the oval ends
	 */
	public Oval(Point start, Point end){
		this.start = start;
		this.end=end;
	}

	/**
	 * Set a new Point to be the oval's end Point
	 * @param end the Point at which the oval ends
	 */
	public void setEndPoint(Point end) {
		this.end = end;
	}

	/**
	 * Return the oval's start Point
	 * @return the Point that the oval was constructed with
	 */
	public Point getStartPoint() {
		return start;
	}
	
	
	@Override
	public void stroke(Graphics2D g2d) {
		int x = Math.min(end.getX(), start.getX());
		int y = Math.min(end.getY(), start.getY());
		int width = Math.abs(end.getX() - start.getX());
		int height = Math.abs(end.getY() - start.getY());
		
		g2d.drawOval(x, y, width, height);
	}

	@Override
	public void fill(Graphics2D g2d) {
		int x = Math.min(end.getX(), start.getX());
		int y = Math.min(end.getY(), start.getY());
		int width = Math.abs(end.getX() - start.getX());
		int height = Math.abs(end.getY() - start.getY());
		
		g2d.fillOval(x, y, width, height);
	}
}

package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

/** 
 * The polyline class defines a connected sequence of line segments from an array of points. 
 * @author Kabeer Moolana
 *
 */
public class Polyline extends Shape {
	private ArrayList<Point> points = new ArrayList<Point>();
	
	/**
	 * Adds a point to the Polyline
	 * @param p Point to add
	 */
	public void addPoint(Point p) {
		points.add(p);
	}
	
	/**
	 * Checks if the points array is greater than one and removes the last point in the array.
	 */
	public void removePoint() {
		if (points.size() > 1) {
			points.remove(points.size()-1);
		}
	}
	
	/**
	 * Returns a general path of the polyline, which is this instance of it.
	 * @return General path of the polyline
	 */
	public GeneralPath getGeneralPath() {
		// Referenced to this documentation to draw geometry using a general path:
        // https://docs.oracle.com/javase/tutorial/2d/geometry/arbitrary.html
        GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, points.size());
        path.moveTo(points.get(0).getX(), points.get(0).getY());
        
        for(int i = 1; i < points.size(); i++) {
            Point p = points.get(i);
            path.lineTo(p.getX(), p.getY());
        }
        return path;
	}

	@Override
	public void stroke(Graphics2D g2d) {
		g2d.draw(getGeneralPath());
	}

	@Override
	public void fill(Graphics2D g2d) {
		stroke(g2d);
	}
}
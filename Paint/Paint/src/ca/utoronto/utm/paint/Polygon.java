package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 * The polygon class defines a polygon from an array of x and y /
 * points along with the number of sides it has.
 * @author Kabeer Moolana
 *
 */
public class Polygon extends Polyline {
	
	@Override
	public void stroke(Graphics2D g2d) {
		GeneralPath path = getGeneralPath();
        path.closePath();
        
        g2d.draw(path);
    }

	@Override
	public void fill(Graphics2D g2d) {
		GeneralPath path = getGeneralPath();
        path.closePath();
        
        g2d.fill(path);
    }

}

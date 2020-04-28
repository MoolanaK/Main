package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * Erase everything underneath the cursor by painting over it with the background color
 * @author Shuai Wen Yu
 *
 */
public class Erase extends Squiggle {
	
	@Override
	public void stroke(Graphics2D g2d) {
		super.stroke(g2d);
	}
	

	@Override
	public void fill(Graphics2D g2d) {
		stroke(g2d);
	}
}

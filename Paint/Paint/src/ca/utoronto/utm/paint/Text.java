package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * A Text class is string that is going to be drawn onto the canvas using Graphics2D 
 * @author Shuai Wen Yu
 *
 */
public class Text extends Shape{
	private String text;
	private int x;
	private int y;
	
	/**
	 * A constructor for Text
	 * @param x - the x coordinate of the location where the String should be rendered
	 * @param y - the y coordinate of the location where the String should be rendered
	 * @param text - string that is going to be drawn
	 */
	public Text(int x, int y,String text) {
		this.text = text;
		this.x = x; 
		this.y = y;
	}
	
	
	@Override
	public void stroke(Graphics2D g2d) {
		g2d.drawString(text, x, y);
	}

	@Override
	public void fill(Graphics2D g2d) {
		stroke(g2d);
	}
}

package ca.utoronto.utm.paint;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Abstract class for a Shape that knows how to draw itself.
 * 
 */
public abstract class Shape implements DrawingCommand {
	
	private Color color;
	private int thickness;
	private boolean filled;
	
	/**
	 * Sets the color of the shape.
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * @return color of the shape
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Sets the thickness of the stroke of the shape.
	 * @param thickness
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	/**
	 * @return true if shape should be filled, false otherwise 
	 */
	public int getThickness() {
		return thickness;
	}
	
	/**
	 * Sets whether the shape should be filled or not.
	 * @param filled - true if shape should be filled, false otherwise 
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	/**
	 * @return true if shape should be filled, false otherwise 
	 */
	public boolean getFilled() {
		return filled;
	}
	
	@Override
	public void execute(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(this.thickness));
		g2d.setColor(this.color);
		if (this.getFilled())
			this.fill(g2d);
		else
			this.stroke(g2d);
	}
	
	/**
	 * Draws the outline of the shape
	 * @param g2d - the graphics component used to draw the shape 
	 */
	public abstract void stroke(Graphics2D g2d);
	
	/**
	 * Draws the shape with the inside filled
	 * @param g2d - the graphics component used to draw the shape 
	 */
	public abstract void fill(Graphics2D g2d);
}

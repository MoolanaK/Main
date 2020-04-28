package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * Icon used for Color Selector Button to indicate its current color
 * @author Devamardeep Hayatpur
 * 
 */
public class ColorSelectorButtonIcon implements Icon {

	private Color color;
	private int size = 25;
	
	/**
	 * Initiate the icon with a color
	 * @param color 
	 */
	public ColorSelectorButtonIcon(Color color) {
		this.color = color;
	}
	
	/**
	 * Set the color
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public int getIconHeight() {
		return size;
	}

	@Override
	public int getIconWidth() {
		return size;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, size, size);
	}
	
}

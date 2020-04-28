package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * A DrawingCommand defines a command to be performed on a Graphics2D object
 * @author Devamardeep Hayatpur
 * 
 */
public interface DrawingCommand {
	
	/**
	 * Execute the command
	 * @param g2d Graphics context
	 */
	public abstract void execute(Graphics2D g2d);
}

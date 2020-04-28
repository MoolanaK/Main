package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * A JTextField that gives the users hints on how to use the drawing tools 
 * @author Shuai Wen Yu
 *
 */
public class Hints extends JTextField implements ActionListener{
	private static final String DEFAULT_HINT = "Select a shape to get started";
	private static final String CIRCLE_HINT = "Drag and release to create a circle";
	private static final String OVAL_HINT = "Drag and release to create an oval";
	private static final String SQUARE_HINT = "Drag and release to create a square";
	private static final String RECTANGLE_HINT = "Drag and release to create a rectangle";
	private static final String SQUIGGLE_HINT = "Drag and release to create a squiggle";
	private static final String POLYLINE_HINT = "Click to add points to the polyline, double click to end the polyline";
	private static final String POLYGON_HINT = "Click to add points to the polygon, double click to end the polygon";
	private static final String REGULAR_POLYGON_HINT = "Drag to begin and use the mousewheel to change the number of sides";
	private static final String ERASE_HINT = "Drag to erase the canvas";
	private static final String TEXT_HINT = "Click to add text to the canvas";
	
	/**
	 * A constructor that sets Hints to be not editable 
	 */
	public Hints() {
		this.setEditable(false);
		this.setText(DEFAULT_HINT);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Set the hint appropriately
		switch (e.getActionCommand()) {
			case "Circle": 
				this.setText(Hints.CIRCLE_HINT);
			    break;
			case "Oval":  
				this.setText(Hints.OVAL_HINT);
			    break;
			case "Square":  
				this.setText(Hints.SQUARE_HINT);
				break;
			case "Rectangle":
				this.setText(Hints.RECTANGLE_HINT);
				break;
			case "Squiggle":
				this.setText(Hints.SQUIGGLE_HINT);
				break;
			case "Polyline":
				this.setText(Hints.POLYLINE_HINT);
				break;
			case "Polygon":
				this.setText(Hints.POLYGON_HINT);
				break;
			case "RegularPolygon":
				this.setText(Hints.REGULAR_POLYGON_HINT);
				break;
			case "Erase":
				this.setText(Hints.ERASE_HINT);
				break;
			case "Text":
				this.setText(Hints.TEXT_HINT);
				break;
		}
	}
}

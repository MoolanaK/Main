package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * A ShapeChooserPanel is a menu that allows the user to select a variety of shapes.
 *
 */
class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view

	/**
	 * Initiate a ShapeChooserPanel with a view
	 * @param view
	 */
	public ShapeChooserPanel(View view, Hints hints) {	
		this.view=view;
		
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline", "Polygon", "RegularPolygon", "Erase", "Text"};
		
		ButtonGroup group = new ButtonGroup();
	    this.setLayout(new GridLayout(buttonLabels.length, 1));
	    
		for (int i=0; i<buttonLabels.length; i+=1) {
			ShapeChooserButton button = new ShapeChooserButton(buttonLabels[i]);
			button.setActionCommand(buttonLabels[i]);
			button.addActionListener(this);	
			button.addActionListener(hints);
		    group.add(button);
		    this.add(button);
		}
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ShapeChooserButton button = (ShapeChooserButton) e.getSource();
		this.view.getPaintPanel().setMode(button.getID());
	}

}

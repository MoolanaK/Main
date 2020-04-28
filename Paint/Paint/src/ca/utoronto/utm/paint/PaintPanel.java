package ca.utoronto.utm.paint;

import javax.swing.*;  
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * A PaintPanel is a view that displays the canvas for the Paint application.
 * 
 */
class PaintPanel extends JPanel implements Observer  {
	
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private String mode; // modifies how we interpret input (could be better?)
	private ShapeManipulatorStrategy strategy;

	/**
	 * Initial a PaintPanel with a model and a view and default mode "Circle".
	 * @param model
	 * @param view
	 */
	public PaintPanel(PaintModel model, View view){		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(300,300));
		this.model = model;
		this.model.addObserver(this);
		this.view=view;
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
        
		// Add anti-aliasing
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                		     RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Execute Model Drawing Commands
		model.execute(g2d);
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}

	/**
	 *  Controller aspect of this
	 */
	public void setMode(String mode){
		this.mode=mode;
		
		// Let the strategy know we are changing the mode
		if (strategy!=null)
			strategy.modeChanged();
		
		strategy = new ShapeManipulatorFactory(this.mode, view, model).getStrategy();
		
		// remove any previous MouseListeners
		if (this.getMouseListeners().length==1) 
			this.removeMouseListener(this.getMouseListeners()[0]);
		
		this.addMouseListener(strategy);
		this.addMouseMotionListener(strategy);
		this.addMouseWheelListener(strategy);
	}
}

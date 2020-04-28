package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * A shape manipulator strategy to create and manipulate an instance of a circle
 * depending on the mouse input.
 * @author Kabeer Moolana
 *
 */
public class CircleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	private Circle circle;
	
	/**
	 * Initiates the strategy with the given view and model
	 * @param view View of the application
	 * @param model PaintModel to act on
	 */
	public CircleManipulatorStrategy(View view, PaintModel model) {
		super(view, model);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.circle!=null) {
			int dx = this.circle.getCenter().getX()-e.getX();
			int dy = this.circle.getCenter().getY()-e.getY();
			int radius = (int) Math.sqrt(dx*dx + dy*dy);
			this.circle.setRadius(radius);
			
			this.view.getPaintPanel().repaint();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point center = new Point(e.getX(), e.getY());
		this.circle=new Circle(center, 0);
		
		// Retrieve the color, thickness, and filled value from the appropriate
		// component and set it as the properties of the circle
		this.circle.setColor(this.view.getColorChooser().getColor());
		this.circle.setThickness(this.view.getThicknessSlider().getValue());
		this.circle.setFilled(this.view.getFillCheckBox().isSelected());
		
		// Add the command to the model. Note, the command is added by reference since
		// it is mutable. Therefore, any changes made to the command that do not change 
		// its reference will be automatically updated in the model's command list.
		this.model.addCommand(this.circle);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.circle!=null)
			this.circle=null;
	}
}

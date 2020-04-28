package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class RegularPolygonManipulatorStrategy extends ShapeManipulatorStrategy {
	
	private RegularPolygon polygon;
	
	/**
	 * Constructor for the strategy
	 * @param view
	 * @param model
	 */
	public RegularPolygonManipulatorStrategy(View view, PaintModel model) {
		super(view, model);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.polygon!=null) {
			this.polygon.setCurrent(new Point(e.getX(), e.getY()));
			this.view.getPaintPanel().repaint();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point centre = new Point(e.getX(), e.getY());
		this.polygon = new RegularPolygon(centre, centre, 3);
		
		// Retrieve the color, thickness, and filled value from the appropriate
		// component and set it as the properties of the circle
		this.polygon.setColor(this.view.getColorChooser().getColor());
		this.polygon.setThickness(this.view.getThicknessSlider().getValue());
		this.polygon.setFilled(this.view.getFillCheckBox().isSelected());
		
		// Add the command to the model. Note, the command is added by reference since
		// it is mutable. Therefore, any changes made to the command that do not change 
		// its reference will be automatically updated in the model's command list.
		this.model.addCommand(this.polygon);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.polygon!=null)
			this.polygon=null;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(this.polygon!=null) {
			int notches = e.getWheelRotation();
			this.polygon.addToNumSides(-notches);
			this.view.getPaintPanel().repaint();
		}
	}
}

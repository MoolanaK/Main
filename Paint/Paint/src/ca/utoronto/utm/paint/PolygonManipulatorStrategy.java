package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * A shape manipulator strategy to create and manipulate an instance of a polygon
 * depending on the mouse input.
 * @author Kabeer Moolana
 *
 */
public class PolygonManipulatorStrategy extends ShapeManipulatorStrategy {
	private Polygon polygon;
	
	/**
	 * Initiates the strategy with the given view and model
	 * @param view View of the application
	 * @param model PaintModel to act on
	 */
	public PolygonManipulatorStrategy(View view, PaintModel model) {
		super(view, model);
	}
	
	/**
	 * @return If the polygon is not null and is the latest command in model
	 */
	public boolean isActive() {
		ArrayList<DrawingCommand> commands = model.getShapeCommands();
		if (commands.size() > 0)
			return commands.get(commands.size() - 1) == this.polygon && polygon != null;
		else 
			return false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if (isActive()) {
			this.polygon.removePoint(); //so it doesn't become a squiggle
			this.polygon.addPoint(new Point(e.getX(), e.getY()));
			this.view.getPaintPanel().repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (isActive()) {
			this.polygon.addPoint(new Point(e.getX(), e.getY()));
		}
		else {
			this.polygon = new Polygon();
            this.polygon.addPoint(new Point(e.getX(), e.getY()));
            
			// Retrieve the color, thickness, and filled value from the appropriate
            // component and set it as the properties of the polyline
            this.polygon.setColor(this.view.getColorChooser().getColor());
            this.polygon.setThickness(this.view.getThicknessSlider().getValue());
            this.polygon.setFilled(this.view.getFillCheckBox().isSelected());
            
    		// Add the command to the model. Note, the command is added by reference since
    		// it is mutable. Therefore, any changes made to the command that do not change 
    		// its reference will be automatically updated in the model's command list.
			this.model.addCommand(this.polygon);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// checks if the user double clicks to end the polygon
		if (e.getClickCount()==2 && isActive())
			this.polygon=null;
	}

	@Override
	public void modeChanged() {
		if (isActive())
			this.polygon = null;
	}
}



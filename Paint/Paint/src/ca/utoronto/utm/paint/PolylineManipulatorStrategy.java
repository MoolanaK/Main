package ca.utoronto.utm.paint;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * A shape manipulator strategy to create and manipulate an instance of a polyline
 * depending on the mouse input.
 * @author Kabeer Moolana
 *
 */
public class PolylineManipulatorStrategy extends ShapeManipulatorStrategy {

	private Polyline polyline;

	/**
	 * Initiates the strategy with the given view and model
	 * @param view View of the application
	 * @param model PaintModel to act on
	 */
	public PolylineManipulatorStrategy(View view, PaintModel model) {
		super(view, model);
	}

	/**
	 * @return If the polyline is not null and is the latest command in model
	 */
	public boolean isActive() {
		ArrayList<DrawingCommand> commands = model.getShapeCommands();
		if (commands.size() > 0)
			return commands.get(commands.size() - 1) == this.polyline && polyline != null;
		else 
			return false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if (isActive()) {
			this.polyline.removePoint(); //so it doesn't become a squiggle
			this.polyline.addPoint(new Point(e.getX(), e.getY()));
			this.view.getPaintPanel().repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (isActive()) {
			Point p = new Point(e.getX(), e.getY());
			this.polyline.addPoint(p);
		}
		else {
			this.polyline = new Polyline();
			this.polyline.addPoint(new Point(e.getX(), e.getY()));
			
			// Retrieve the color, thickness, and filled value from the appropriate
			// component and set it as the properties of the polyline
			this.polyline.setColor(this.view.getColorChooser().getColor());
			this.polyline.setThickness(this.view.getThicknessSlider().getValue());
			this.polyline.setFilled(this.view.getFillCheckBox().isSelected());
			
    		// Add the command to the model. Note, the command is added by reference since
    		// it is mutable. Therefore, any changes made to the command that do not change 
    		// its reference will be automatically updated in the model's command list.
			this.model.addCommand(this.polyline);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// checks if the user double clicks to end the polyline	
		if (e.getClickCount()==2 && isActive())
			this.polyline=null;
	}

	@Override
	public void modeChanged() {
		if (isActive())
			this.polyline = null;
	}
}

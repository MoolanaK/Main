package ca.utoronto.utm.paint;
import java.awt.event.MouseEvent;

/**
 * A shape manipulator strategy to create and manipulate an instance of a rectangle
 * depending on the mouse input.
 * @author Kabeer Moolana
 *
 */
public class RectangleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	private Rectangle rectangle;

	/**
	 * Initiates the strategy with the given view and model
	 * @param view View of the application
	 * @param model PaintModel to act on
	 */
	public RectangleManipulatorStrategy(View view, PaintModel model) {
		super(view, model);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.rectangle!=null) {
			this.rectangle.setEndPoint(new Point(e.getX(), e.getY()));
			this.view.getPaintPanel().repaint();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point startPoint = new Point(e.getX(), e.getY());
		this.rectangle = new Rectangle(startPoint, startPoint);
		
		// Retrieve the color, thickness, and filled value from the appropriate
		// component and set it as the properties of the rectangle
		this.rectangle.setColor(this.view.getColorChooser().getColor());
		this.rectangle.setThickness(this.view.getThicknessSlider().getValue());
		this.rectangle.setFilled(this.view.getFillCheckBox().isSelected());
		
		// Add the command to the model. Note, the command is added by reference since
		// it is mutable. Therefore, any changes made to the command that do not change 
		// its reference will be automatically updated in the model's command list.
		this.model.addCommand(this.rectangle);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.rectangle!=null)
			this.rectangle=null;
	}
}

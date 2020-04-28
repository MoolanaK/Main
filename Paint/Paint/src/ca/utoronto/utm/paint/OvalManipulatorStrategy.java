package ca.utoronto.utm.paint;
import java.awt.event.MouseEvent;

/**
 * A shape manipulator strategy to create and manipulate an instance of an Oval
 * depending on the mouse input.
 * @author Devin Gopaul
 *
 */
public class OvalManipulatorStrategy extends ShapeManipulatorStrategy {
	
	private Oval oval;
	
	/**
	 * Initiates the strategy with the given view and model
	 * @param view View of the application
	 * @param model PaintModel to act on
	 */
	public OvalManipulatorStrategy(View view, PaintModel model) {
		super(view, model);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.oval!=null) {
			this.oval.setEndPoint(new Point(e.getX(), e.getY()));
			this.view.getPaintPanel().repaint();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point startPoint = new Point(e.getX(), e.getY());
		this.oval = new Oval(startPoint, startPoint);
		
		// Retrieve the color, thickness, and filled value from the appropriate
		// component and set it as the properties of the oval
		this.oval.setColor(this.view.getColorChooser().getColor());
		this.oval.setThickness(this.view.getThicknessSlider().getValue());
		this.oval.setFilled(this.view.getFillCheckBox().isSelected());
		
		// Add the command to the model. Note, the command is added by reference since
		// it is mutable. Therefore, any changes made to the command that do not change 
		// its reference will be automatically updated in the model's command list.
		this.model.addCommand(this.oval);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.oval!=null)
			this.oval=null;
	}
}

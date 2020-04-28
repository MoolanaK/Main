package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

/**
 * A ShapeManipulatorStrategy used to creates Text instances 
 * @author Shuai Wen Yu
 *
 */
public class TextManipulatorStrategy extends ShapeManipulatorStrategy {
	private Text text;
	
	/**
	 * Constructor for the strategy
	 * @param view
	 * @param model
	 */
	public TextManipulatorStrategy(View view, PaintModel model) {
		super(view, model);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		String text = JOptionPane.showInputDialog("Please Input Text");
		if (text != null) {
			this.text = new Text(e.getX(), e.getY(),text);
			
			// Retrieve the color, thickness, and filled value from the appropriate
			// component and set it as the properties of the square
			this.text.setColor(this.view.getColorChooser().getColor());
			this.text.setThickness(this.view.getThicknessSlider().getValue());
			this.text.setFilled(this.view.getFillCheckBox().isSelected());
			
			// Add the command to the model. Note, the command is added by reference since
			// it is mutable. Therefore, any changes made to the command that do not change 
			// its reference will be automatically updated in the model's command list.
			this.model.addCommand(this.text);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.text!=null)
			this.text=null;
	}
}

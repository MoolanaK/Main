package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 * A shape manipulator strategy to create an instance of a erase
 * @author Shuai Wen Yu
 *
 */
public class EraseManipulatorStrategy extends SquiggleManipulatorStrategy {
	private Erase erase;
	
	/**
	 * Constructor for the strategy
	 * @param view
	 * @param model
	 */
	public EraseManipulatorStrategy(View view, PaintModel model) {
		super(view, model);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.erase!=null){
			this.erase.addPoint(new Point(e.getX(), e.getY()));
			this.view.getPaintPanel().repaint();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.erase = new Erase();
		
		// Retrieve the color, thickness, and filled value from the appropriate
		// component and set it as the properties of the eraser
		this.erase.setColor(Color.WHITE);
		this.erase.setThickness(this.view.getThicknessSlider().getValue());
		this.erase.setFilled(this.view.getFillCheckBox().isSelected());
		
		this.model.addCommand(this.erase);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.erase!=null)
			this.erase=null;
	}
}
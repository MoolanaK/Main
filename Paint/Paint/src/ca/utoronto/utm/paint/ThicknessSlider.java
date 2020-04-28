package ca.utoronto.utm.paint;

import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

/**
 * Creates a JPanel with a JSlider that lets the user select the thickness of the lines 
 * being painted 
 * @author Shuai Wen Yu
 *
 */
public class ThicknessSlider extends JSlider {
	private final static int defaultThickness = 1;
	
	/**
	 * Constructs the JPanel with a JSlider that determines how thick the lines being drawn 
	 * should be
	 */
 	public ThicknessSlider() {
		// Create a new JSlider with a vertical orientation, minimum value of 1,
		// maximum value of 20, and start value of defaultThickness
 		super(JSlider.VERTICAL, 1, 20, defaultThickness);
 		
		this.setMajorTickSpacing(19);
		this.setMinorTickSpacing(1);
		this.setPaintTicks(true);
		this.setPaintLabels(true);
		this.setSnapToTicks(true);
		this.setToolTipText("Change thickness of the brush");
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}

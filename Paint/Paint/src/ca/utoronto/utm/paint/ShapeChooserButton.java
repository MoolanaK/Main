package ca.utoronto.utm.paint;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 * 
 * A JToggleButton for a Shape, to be used and displayed on ShapeChooserPanel.
 * @author Devin Gopaul
 * 
 */
public class ShapeChooserButton extends JToggleButton {
	
	private String id;
	
	/**
	 * Sets up the ShapeButton's appearance and behaviour.
	 * @param id the String of the shape corresponding with the ShapeButton.
	 */
	public ShapeChooserButton(String id) {
		this.id = id;
		this.setIcon(new ImageIcon("images/buttonIcons/" + id + ".png"));
		this.setToolTipText(id);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setMargin(new Insets(0,0,0,0));
		this.setPreferredSize(new Dimension(50, 50));
	}
	
	/**
	 * @return id
	 */
	public String getID() {
		return id;
	}
}

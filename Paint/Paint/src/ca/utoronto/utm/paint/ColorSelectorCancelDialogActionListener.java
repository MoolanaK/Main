package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

/**
 * An ActionListener that will reset the color of paint panel to what it was before the dialog
 * when the action occurs 
 * @author Shuai Wen Yu
 *
 */
public class ColorSelectorCancelDialogActionListener implements ActionListener{
	private Color color;
	private JColorChooser colorChooser;
	
	/**
	 * A constructor to set up the ActionListener
	 * @param color Color before any changes made by the user
	 * @param colorChooser Color Chooser to act on
	 */
	public ColorSelectorCancelDialogActionListener(Color color, JColorChooser colorChooser) {
		this.color = color;
		this.colorChooser = colorChooser;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.colorChooser.setColor(color);
	}
}

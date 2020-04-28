package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.colorchooser.AbstractColorChooserPanel;

/**
 * Creates a JPanel that contains the HSV panel from JColorChooser that can return
 * the color a user selects 
 * @author Shuai Wen Yu
 *
 */
public class ColorSelectorButton extends JButton implements ActionListener {
	private final static Color defaultColor = Color.BLACK;
	private ColorSelectorButtonIcon icon;
	private JColorChooser colorChooser;
	
	/**
	 * Creates the JPanel that contains the HSV Panel for JColorChooser
	 */
	public ColorSelectorButton() {
		super("Color");
		this.colorChooser = this.createColorChooser();
		this.icon = new ColorSelectorButtonIcon(defaultColor);
		
		this.setToolTipText("Change Color");
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.addActionListener(this);
		this.setIcon(this.icon);
	}
	
	/**
	 * @return A JColorChooser with only the HSV Panel
	 */
	public JColorChooser createColorChooser() {
		/*
		 * Learned how to use JColorChooser from 
		 * https://docs.oracle.com/javase/tutorial/uiswing/components/colorchooser.html
		 */
		JColorChooser chooser = new JColorChooser(defaultColor);
		chooser.setPreviewPanel(new JPanel());
		
		/*
		 * Referred to this post: 
		 * https://stackoverflow.com/questions/9079807/jcolorchooser-hide-all-default-panels-and-show-hsb-panel-only
		 * to remove unnecessary color panels  
		 */
		AbstractColorChooserPanel[] panels = chooser.getChooserPanels();
		for (AbstractColorChooserPanel chooserPanel : panels) {
		   if(!chooserPanel.getDisplayName().equals("HSV")) {
			   chooser.removeChooserPanel(chooserPanel);
		   } 
		}
		return chooser;
	}
	
	/**
	 * Creates a pop-up window that lets the user choose shape color 
	 */
	public void createAndShowColorChooserPopUp() {
		ColorSelectorCancelDialogActionListener cancelActionListener = new ColorSelectorCancelDialogActionListener(colorChooser.getColor(),colorChooser);
		JDialog colorChooserPopUp = JColorChooser.createDialog(null, "Shape Color Selector", true, colorChooser, null, cancelActionListener);
		colorChooserPopUp.pack();
		colorChooserPopUp.setVisible(true);
	}

	/**
	 * @return the color chooser
	 */
	public JColorChooser getColorChooser() {
		return colorChooser;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		this.createAndShowColorChooserPopUp();
		this.icon.setColor((colorChooser.getColor()));
		this.repaint();
	}
}

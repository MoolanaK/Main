package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An ActionListener that will give clear the PaintModel of its commands
 * @author Shuai Wen Yu
 *
 */
public class ClearActionListener implements ActionListener{
	private PaintModel model;
	
	/**
	 * A constructor to set up the ActionListener
	 * @param model - the PaintModel the command is being added to
	 */
	ClearActionListener(PaintModel model){
		this.model=model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.clear();
	}

}

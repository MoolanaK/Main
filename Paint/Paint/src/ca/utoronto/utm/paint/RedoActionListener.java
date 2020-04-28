package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A action listener to redo changes.
 * @author Devamardeep Hayatpur
 *
 */
public class RedoActionListener implements ActionListener {

	private PaintModel model;
	
	/**
	 * Create an action listener to redo commands on the model.
	 * @param model PaintModel to redo commands on
	 */
	public RedoActionListener(PaintModel model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.redoCommand();
	}
}

package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A action listener to undo changes.
 * @author Devamardeep Hayatpur
 *
 */
public class UndoActionListener implements ActionListener {

	private PaintModel model;
	
	/**
	 * Create an action listener to undo commands on the model.
	 * @param model PaintModel to undo commands on
	 */
	public UndoActionListener(PaintModel model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.undoCommand();
	}
}

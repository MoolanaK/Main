package ca.utoronto.utm.paint;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * An Redo button for Paint Model that is disabled appropriately depending on
 * the state of Paint Model
 * @author Devamardeep Hayatpur
 *
 */
public class RedoButton extends JButton implements Observer {
	
	/**
	 * Initiate the redo button
	 */
	public RedoButton() {
		this.setIcon(new ImageIcon("images/utilityIcons/redo.png"));
		this.setToolTipText("Redo");
		this.setEnabled(false);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		PaintModel model = (PaintModel) o;
		if (model.getUndoCommands().size() > 0)
			this.setEnabled(true);
		else
			this.setEnabled(false);
	}
}

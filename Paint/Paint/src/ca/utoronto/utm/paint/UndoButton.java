package ca.utoronto.utm.paint;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * An Undo button for Paint Model that is disabled appropriately depending on
 * the state of Paint Model
 * @author Devamardeep Hayatpur
 *
 */
public class UndoButton extends JButton implements Observer {

	/**
	 * Initiate the undo button
	 */
	public UndoButton() {
		this.setIcon(new ImageIcon("images/utilityIcons/undo.png"));
		this.setToolTipText("Undo");
		this.setEnabled(false);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		PaintModel model = (PaintModel) o;
		if (model.getShapeCommands().size() > 0)
			this.setEnabled(true);
		else
			this.setEnabled(false);
	}
}

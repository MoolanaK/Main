package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * A base class that every Shape Manipulator must extend, allows for changes to the
 * model using information from the view depending on the mouse input.
 * @author Kabeer Moolana
 *
 */
public class ShapeManipulatorStrategy implements MouseMotionListener, MouseListener, MouseWheelListener {
	
	protected View view;
	protected PaintModel model;
	
	/**
	 * Initiates the strategy with the given view and model
	 * @param view View of the application
	 * @param model PaintModel to act on
	 */
	public ShapeManipulatorStrategy(View view, PaintModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}
	
	public void modeChanged() {
	}
}

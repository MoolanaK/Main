package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;

/**
 * A PaintModel is an Observable that stores attributes
 * of a paint canvas.
 * 
 */

public class PaintModel extends Observable {
	
	private ArrayList<DrawingCommand> commands = new ArrayList<>();
	
	// Commands that have been undo'ed
	private ArrayList<DrawingCommand> undoCommands = new ArrayList<>();
	
	/**
	 * Adds a command
	 * @param command DrawingCommand to add
	 */
	public void addCommand(DrawingCommand command){
		this.commands.add(command);
		
		// If a new command is added then the previous undo list is obsolete
		undoCommands.clear();
		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Executes all of the commands.
	 * @param g2d Graphics context
	 */
	public void execute(Graphics2D g2d) {
		for(DrawingCommand c:commands) {
			c.execute(g2d);
		}
	}
	
	/**
	 * Undo a command
	 */
	public void undoCommand(){
		if (commands.size() > 0) {
			// Add the command to the undo list
			undoCommands.add(commands.get(commands.size() - 1));
			commands.remove(commands.size() - 1);
			
			setChanged();
			notifyObservers("Undo");
		}
	}
	
	/**
	 * Redo a command
	 */
	public void redoCommand(){
		if (undoCommands.size() > 0) {
			commands.add(undoCommands.get(undoCommands.size() - 1));
			undoCommands.remove(undoCommands.size() - 1);
			
			setChanged();
			notifyObservers("Redo");
		}
	}
	
	/**
	 * Removes all commands and clears the canvas 
	 */
	public void clear() {
		commands.clear();
		
		this.setChanged();
		this.notifyObservers("Clear");
	}
	
	/**
	 * @return List of all commands
	 */
	public ArrayList<DrawingCommand> getShapeCommands(){
		return commands;
	}
	
	/**
	 * @return List of all commands that have been undo'ed
	 */
	public ArrayList<DrawingCommand> getUndoCommands(){
		return undoCommands;
	}
	
}

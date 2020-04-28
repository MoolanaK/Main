package ca.utoronto.utm.paint;

/**
 * The ShapeManipulatorFactory takes in an input String, and it creates and returns the ShapeManiuplatorStrategy
 * associated with that String.
 * @author Devin Gopaul
 *
 */
public class ShapeManipulatorFactory {
	private PaintModel model;
	private ShapeManipulatorStrategy strategy;

	/**
	 * Creates an instance of the ShapeManipulatorStrategy subclass associated with id.
	 * @param id The String that tells the Factory which ShapeManipulatorStrategy subclass to instantiate.
	 * @param view The view that is passed on to the constructor of the ShapeManipulatorStrategy subclass instance
	 * @param model The model that is passed on to the constructor of the ShapeManipulatorStrategy subclass instance
	 */
	public ShapeManipulatorFactory(String id, View view, PaintModel model) {
		this.model=model;
		
		// Set the strategy appropriately depending on value of id
		switch (id) {
			case "Circle": 
				this.strategy= new CircleManipulatorStrategy(view, model);
			    break;
			case "Oval":  
				this.strategy= new OvalManipulatorStrategy(view, model);
			    break;
			case "Square":  
				this.strategy= new SquareManipulatorStrategy(view, model);
				break;
			case "Rectangle":
				this.strategy= new RectangleManipulatorStrategy(view, model);
				break;
			case "Squiggle":
				this.strategy= new SquiggleManipulatorStrategy(view, model);
				break;
			case "Polyline":
				this.strategy= new PolylineManipulatorStrategy(view, model);
				break;
			case "Polygon":
				this.strategy= new PolygonManipulatorStrategy(view, model);
				break;
			case "RegularPolygon":
				this.strategy= new RegularPolygonManipulatorStrategy(view, model);
				break;
			case "Erase":
				this.strategy= new EraseManipulatorStrategy(view,model);
				break;
			case "Text":
				this.strategy= new TextManipulatorStrategy(view,model);
		}
	}
	
	/**
	 * Returns the ShapeManipulatorStrategy that was associated with the Input string provided in the constructor
	 * @return A ShapeManipulator subclass instance created by the constructor
	 */
	public ShapeManipulatorStrategy getStrategy() {
		return this.strategy;
	}
}


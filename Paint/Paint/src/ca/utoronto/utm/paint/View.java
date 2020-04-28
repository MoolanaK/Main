package ca.utoronto.utm.paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private PaintModel model;
	
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColorSelectorButton colorSelectorButton;
	private JCheckBox fillCheckBox;
	private Hints hints;
	private ThicknessSlider thicknessSlider;

	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Try to set the look and feel to Nimbus
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		// Try to set the icon of the application
		try {
		    this.setIconImage(ImageIO.read(new File("images/utilityIcons/paint.png")));
		} catch (IOException exc) {}
		
		// Initialize Model
		this.model = model;
		
		// Initialize paint panel
		this.paintPanel = new PaintPanel(model, this);
		
		// Initialize menu bar
		this.setJMenuBar(createMenuBar());
		
		Container c = this.getContentPane();
		
		// Initiate components
		this.hints = new Hints();
		this.shapeChooserPanel = new ShapeChooserPanel(this, hints);	
		this.colorSelectorButton = new ColorSelectorButton();
		this.thicknessSlider = new ThicknessSlider();
		
		this.fillCheckBox = new JCheckBox("Fill");
		this.fillCheckBox.setHorizontalAlignment(JCheckBox.CENTER);
		this.fillCheckBox.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.fillCheckBox.setToolTipText("Filled in or not");
		
		// Create a JPanel to store the thickness slider and its label in
		JPanel thicknessPanel = new JPanel(new BorderLayout());
		JLabel thicknessLabel = new JLabel("Size", JLabel.CENTER);
		// Add some padding around the label
		thicknessLabel.setBorder(new EmptyBorder(0, 5, 5, 5));
		thicknessPanel.add(thicknessSlider, BorderLayout.CENTER);
		thicknessPanel.add(thicknessLabel, BorderLayout.SOUTH);
	
		JPanel right = new JPanel(new BorderLayout());
		
		// Add separators around the thickness panel
		JPanel rightMid = new JPanel(new BorderLayout());
		rightMid.add(thicknessPanel, BorderLayout.CENTER);
		rightMid.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.PAGE_START);
		rightMid.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.PAGE_END);
		
		right.add(fillCheckBox, BorderLayout.NORTH);
		right.add(rightMid, BorderLayout.CENTER);
		right.add(colorSelectorButton, BorderLayout.SOUTH);
		
		// Add all the components appropriately
		c.add(createToolBar(), BorderLayout.PAGE_START);
		c.add(this.paintPanel, BorderLayout.CENTER);
		c.add(shapeChooserPanel, BorderLayout.WEST);
		c.add(right, BorderLayout.EAST);
		c.add(hints, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
	}

	/**
	 * @return the PaintPanel in the View.
	 */
	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	/**
	 * @return the ShapeChooserPanel in the View.
	 */
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;	
	}
	
	/**
	 * @return the fill checkbox in the View.
	 */
	public JToggleButton getFillCheckBox() {
		return this.fillCheckBox;
	}
	
	/**
	 * @return the ColorSelectorPanel in the View.
	 */
	public JColorChooser getColorChooser() {
		return colorSelectorButton.getColorChooser();
	}
	
	/**
	 * @return the ThicknessSelectorPanel in the View.
	 */
	public ThicknessSlider getThicknessSlider() {
		return thicknessSlider;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(new UndoActionListener(this.model));
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(new RedoActionListener(this.model));
		menu.add(menuItem);

		menu.addSeparator();// -------------
		
		menuItem = new JMenuItem("Clear"); 
		menuItem.addActionListener(new ClearActionListener(this.model));
		menu.add(menuItem);
		
		menuBar.add(menu);

		return menuBar;
	}
	
	private JToolBar createToolBar() {
		JToolBar toolbar = new JToolBar();
		
		JButton newButton = new JButton();
		newButton.setIcon(new ImageIcon("images/utilityIcons/new.png"));
		newButton.setToolTipText("New File");
		newButton.setEnabled(false);
		
		JButton openButton = new JButton();
		openButton.setIcon(new ImageIcon("images/utilityIcons/open.png"));
		openButton.setToolTipText("Open File");
		openButton.setEnabled(false);
		
		JButton saveButton = new JButton();
		saveButton.setIcon(new ImageIcon("images/utilityIcons/save.png"));
		saveButton.setToolTipText("Save File");
		saveButton.setEnabled(false);
		
		
		JButton cutButton = new JButton();
		cutButton.setIcon(new ImageIcon("images/utilityIcons/cut.png"));
		cutButton.setToolTipText("Cut Selection");
		cutButton.setEnabled(false);
		
		JButton copyButton = new JButton();
		copyButton.setIcon(new ImageIcon("images/utilityIcons/copy.png"));
		copyButton.setToolTipText("Copy Selection");
		copyButton.setEnabled(false);
		
		JButton pasteButton = new JButton();
		pasteButton.setIcon(new ImageIcon("images/utilityIcons/paste.png"));
		pasteButton.setToolTipText("Paste Selection");
		pasteButton.setEnabled(false);
		
		UndoButton undoButton = new UndoButton();
		undoButton.addActionListener(new UndoActionListener(this.model));
		model.addObserver(undoButton);
		
		RedoButton redoButton = new RedoButton();
		redoButton.addActionListener(new RedoActionListener(this.model));
		model.addObserver(redoButton);
		
		ClearButton clearButton = new ClearButton();
		clearButton.addActionListener(new ClearActionListener(this.model));
		model.addObserver(clearButton);
		
		toolbar.add(newButton);
		toolbar.add(openButton);
		toolbar.add(saveButton);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(cutButton);
		toolbar.add(copyButton);
		toolbar.add(pasteButton);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(undoButton);
		toolbar.add(redoButton);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(clearButton);
		
		return toolbar;
	}

	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getActionCommand());
	}
}

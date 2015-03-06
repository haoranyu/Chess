/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author haoranyu
 *
 */
public class MenuListener implements ActionListener {
	
	private static Chess controller; /**< the controlled for the class */
	
	/**
	 * Constructor for listener of menu
	 */
	public MenuListener() {
		super();
	}
	
	/**
	 * Set controller to the main chess controller
	 * @param chess	The chess controller
	 */
	public static void setController(Chess chess) {
		controller = chess;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Exit") {
			System.exit(0);
		}
		if(e.getActionCommand() == "New Game") {
			controller.refreshChessBoard(null);
		}
		if(e.getActionCommand() == "Undo") {
			controller.revertMove();
		}
		if(e.getActionCommand() == "Give Up") {
			controller.setLose();
		}
	}
}

/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelCore.Position;
/**
 * @author haoranyu
 *
 */

public class PieceListener implements ActionListener {
	private static Position initialPosition = null; /**< the first position clicked */
	private static Chess controller; /**< the controlled for the class */
	private Position position; /**< the position this action clicked */
	
	/**
	 * receive the position on the chessboard where is clicked
	 * @param position
	 */
	public PieceListener(Position position) {
		super();
		this.position = position;
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
		if(initialPosition == null) {
			initialPosition = this.position;
		}
		else {
			controller.move(initialPosition, this.position);
			initialPosition = null;
		}
	}


}

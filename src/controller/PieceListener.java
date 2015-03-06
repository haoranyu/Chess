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
	private static Position initialPosition = null;
	private static Chess controller;
	private Position position;
	
	public PieceListener(Position position) {
		super();
		this.position = position;
	}

	/**
	 * @param chess
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

/**
 * 
 */
package views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelCore.ChessBoard;
/**
 * @author haoranyu
 *
 */
public class GUI implements ActionListener {
	private ChessBoard chessBoard;
	private JFrame gameFrame;
	private JPanel gamePanel;
	private JButton[][] board;
	int gridSize;
	
	public GUI(int size) {
		this.gridSize = size;
		this.chessBoard = new ChessBoard();

		initializeFrame();
		initializePanel();

	}
	
	private void initializeFrame() {
		this.gameFrame = new JFrame("Chess Game");
		this.gameFrame.setSize(this.chessBoard.col * this.gridSize, this.chessBoard.row * this.gridSize);
		this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gameFrame.setVisible(true);
	}
	
	private void initializePanel() {
		this.gamePanel = new JPanel(new GridLayout(this.chessBoard.col, this.chessBoard.row));
		this.gamePanel.setBackground(Color.cyan);
		this.gameFrame.add(this.gamePanel);
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

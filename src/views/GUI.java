/**
 * 
 */
package views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelCore.ChessBoard;
import modelCore.Position;
/**
 * @author haoranyu
 *
 */
public class GUI implements ActionListener {
	private ChessBoard chessBoard;
	private JFrame gameFrame;
	private int gameFrameHeight;
	private int gameFrameWidth;
	private JPanel gamePanel; 
	private int gridSize;
	
	public GUI(int size) {
		this.gridSize = size;
		this.chessBoard = new ChessBoard();
		this.gameFrameHeight = this.chessBoard.row * this.gridSize;
		this.gameFrameWidth = this.chessBoard.col * this.gridSize;
		
		initializeFrame();
		initializePanel();
		initializePieces();
		
		this.gameFrame.setVisible(true);
	}
	
	private void initializeFrame() {
		this.gameFrame = new JFrame("Chess Game");
		this.gameFrame.setSize(this.gameFrameWidth, this.gameFrameHeight);
		this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void initializePanel() {
		this.gamePanel = new JPanel(new GridLayout(this.chessBoard.col, this.chessBoard.row)) {  
			private static final long serialVersionUID = 1L;

			@Override  
            protected void paintComponent(Graphics g) {  
            	ImageIcon background = new ImageIcon("img/chess_panel_bg.png");
                Image img = background.getImage();  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), background.getImageObserver());  
            }  
        };  
        this.gameFrame.add(this.gamePanel);
	}
	
	private void initializePieces() {
		for(int row = this.chessBoard.row; row >= 1; row--) {
			for(int col = 1; col <= this.chessBoard.col; col++) {
				String type = chessBoard.getChessPieceInPosition(new Position(row,col)).getType();
				String name = chessBoard.getChessPieceInPosition(new Position(row,col)).getName(); 
				JButton piece = new JButton(getIconForPieces(type, name));
				piece.setFont(new Font("Arial", Font.BOLD, this.gridSize / 2));
				piece.setOpaque(false);
				piece.setContentAreaFilled(false);
				piece.setBorderPainted(false);
				this.gamePanel.add(piece);
			}
		}
	}
	
	private String getIconForPieces(String type, String name) {
		String iconString = null;
		if(type.equals("white")) {
			switch(name) {
			case "king": iconString = "\u2654"; break;
			case "queen": iconString = "\u2655"; break;
			case "rook": iconString = "\u2656"; break;
			case "bishop": iconString = "\u2657"; break;
			case "knight": iconString = "\u2658"; break;
			case "pawn": iconString = "\u2659";
			}
		}
		else if(type.equals("black")){ // black
			switch(name) {
			case "king": iconString = "\u265A"; break;
			case "queen": iconString = "\u265B"; break;
			case "rook": iconString = "\u265C"; break;
			case "bishop": iconString = "\u265D"; break;
			case "knight": iconString = "\u265E"; break;
			case "pawn": iconString = "\u265F";
			}
		}
		else {
			iconString = "";
		}
		return iconString;
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
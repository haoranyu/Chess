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
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

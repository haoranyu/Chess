/**
 * 
 */
package views;
import java.awt.*;

import javax.swing.*;

import modelCore.ChessBoard;
import modelCore.Position;
import controller.MenuListener;
import controller.PieceListener;
/**
 * @author haoranyu
 * 
 */
public class GUI{
	private ChessBoard chessBoard;
	private int gameFrameHeight;
	private int gameFrameWidth;
	private int gridSize;
	
	public JFrame gameFrame;
	public JPanel gamePanel; 
	public JPanel gameMain; 
	public JLabel gameInfo; 
	
	/**
	 * The constructor for GUI
	 * @param size 	The size base of the window (which is the grid block size)
	 */
	public GUI(int size) {
		this.gridSize = size;
		this.chessBoard = new ChessBoard();
		this.gameFrameHeight = this.chessBoard.row * this.gridSize + 60;
		this.gameFrameWidth = this.chessBoard.col * this.gridSize;
		
		initializeFrame();
		initializeMain();
		initializeInfo();
		initializePanel();
		initializePieces();
		initializeMenu();
		this.gameFrame.setVisible(true);
	}
	
	/**
	 * Initialize the frame of window
	 */
	private void initializeFrame() {
		this.gameFrame = new JFrame("Chess Game");
		this.gameFrame.setSize(this.gameFrameWidth, this.gameFrameHeight);
		this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void initializeMain() {
		this.gameMain = new JPanel(new BorderLayout());
		this.gameFrame.add(this.gameMain);
	}
	
	private void initializeInfo() {
		this.gameInfo = new JLabel("White Score: 0    Black Score: 0");
		this.gameInfo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.gameMain.add("North", this.gameInfo);
	}
	
	
	/**
	 * Initialize the panel for the game
	 */
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
        this.gameMain.add("Center", this.gamePanel);
	}
		
	/**
	 * Initialize the menu
	 */
	private void initializeMenu() {
        JMenuBar menubar = new JMenuBar();
        
        JMenu game = new JMenu("Game");
        
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new MenuListener());
        game.add(newGame);
       
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new MenuListener());
        game.add(exit);

        JMenu option = new JMenu("Option");
        
        JMenuItem undo = new JMenuItem("Undo");
        undo.addActionListener(new MenuListener());
        option.add(undo);

        
        JMenuItem giveUp = new JMenuItem("Give Up");
        giveUp.addActionListener(new MenuListener());
        option.add(giveUp);
        
        menubar.add(game);
        menubar.add(option);
        
        this.gameFrame.setJMenuBar(menubar);
    }
	
	/**
	 * Initialize chess pieces in GUI
	 */
	private void initializePieces() {
		for(int row = this.chessBoard.row; row >= 1; row--) {
			for(int col = 1; col <= this.chessBoard.col; col++) {
				String type = chessBoard.getChessPieceInPosition(new Position(row,col)).getType();
				String name = chessBoard.getChessPieceInPosition(new Position(row,col)).getName(); 
				JButton piece = new JButton(getIconForPieces(type, name));
				piece.setBorder(BorderFactory.createEtchedBorder());
				piece.setFont(new Font("Arial", Font.BOLD, this.gridSize / 2));
				piece.setOpaque(false);
				piece.setContentAreaFilled(false);
				piece.setBorderPainted(false);
				piece.addActionListener(new PieceListener(new Position(row, col)));
				this.gamePanel.add(piece);
			}
		}
	}
	
	/**
	 * According to the type and name passed in to return a char as the icon 
	 * of chess piece
	 * @param type	The type of chess piece
	 * @param name	The name of chess piece
	 * @return	The right char for the icon of chess piece
	 */
	private String getIconForPieces(String type, String name) {
		String iconString = null;
		if(type.equals("white")) {
			switch(name) {
			case "king": iconString = "\u2654"; break;
			case "queen": iconString = "\u2655"; break;
			case "rook": iconString = "\u2656"; break;
			case "bishop": iconString = "\u2657"; break;
			case "knight": iconString = "\u2658"; break;
			case "pawn": iconString = "\u2659"; break;
			case "princess": iconString = "\u2740"; break;
			case "empress": iconString = "\u272C";
			}
		}
		else if(type.equals("black")){ // black
			switch(name) {
			case "king": iconString = "\u265A"; break;
			case "queen": iconString = "\u265B"; break;
			case "rook": iconString = "\u265C"; break;
			case "bishop": iconString = "\u265D"; break;
			case "knight": iconString = "\u265E"; break;
			case "pawn": iconString = "\u265F"; break;
			case "princess": iconString = "\u273F"; break;
			case "empress": iconString = "\u272B";
			}
		}
		else {
			iconString = "";
		}
		return iconString;
	}
	

	/**
	 * The real refresh action on GUI
	 * @param chessBoard	The aim chessBoard it will become
	 */
	public void refreshChessBoard(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
		
		gamePanel.removeAll();
		initializePieces();
		this.gameFrame.setVisible(true);
	}
	
	/**
	 * Alert a message for user
	 * @param msg	The content of alert
	 */
	public void popMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Warning", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Refresh the score on the interface
	 * @param whiteScore	The score for white player
	 * @param blackScore	The score for black player
	 */
	public void refreshScore(Integer whiteScore, Integer blackScore) {
		this.gameInfo.setText("White Score: " + whiteScore.toString() + "    Black Score: " +  blackScore.toString());
		this.gameFrame.setVisible(true);
	}
	
}

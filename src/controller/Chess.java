package controller;
import java.util.HashMap;

import modelCore.ChessBoard;
import modelCore.Position;
import views.GUI;

/**
 * @author haoranyu
 *
 */
public class Chess {
	
	private GUI chessView; /**< the GUI object as the view */
	private ChessBoard chessBoard; /**< the chessBoard we really play on */
	private HashMap<String, Integer> score; /**< the hash for score saving */
	
	/**
	 * The constructor initialize the GUI and chess board
	 * and also set the original score for both side to 0
	 * and bind two listeners to this controller 
	 */
	public Chess() {
		chessView = new GUI(80);
		
		chessBoard = new ChessBoard();
		
		score = new HashMap<String, Integer>();
		score.put("black", 0);
		score.put("white", 0);
		
		PieceListener.setController(this);
		MenuListener.setController(this);
	}
	
	/**
	 * The controller for move a chess piece 
	 * @param fromPosition	The position get clicked first
	 * @param toPosition	The position get clicked after
	 */
	public void move(Position fromPosition, Position toPosition) {
		if(chessBoard.getChessPieceInPosition(fromPosition).getType().equals(chessBoard.getTurn())) {
			if(chessBoard.move(chessBoard.getChessPieceInPosition(fromPosition), toPosition)){
				chessView.refreshChessBoard(chessBoard);
				if(chessBoard.getWin() == null) {
					chessBoard.changeTurn();
				}
				else {
					chessBoard.changeTurn();
					if(!chessBoard.getWin().equals(chessBoard.getTurn())) {
						this.setLose();
					}
				}
			}
		}
	}
	
	/**
	 * Undo the last move
	 * Can be done time to time until a empty stack
	 */
	public void revertMove() {
		if(chessBoard.revertMove()){
			chessView.refreshChessBoard(chessBoard);
		}
		else {
			chessView.popMsg("There is no record of move avaliable");
		}
	}
	
	/**
	 * Set who lose the game
	 */
	public void setLose() {
		if(chessBoard.getTurn().equals("white")) {
			chessView.popMsg("Black Win!");
			score.put("black", score.get("black") + 1);
		}
		else {
			chessView.popMsg("White Win!");
			score.put("white", score.get("white") + 1);
		}
		chessView.refreshScore(score.get("white"), score.get("black"));
		this.refreshChessBoard(null);
	}

	/**
	 * The helper function to refresh the chess board
	 * has been used everywhere
	 * @param chessBoard	The chessBoard to be displayed on GUI
	 */
	public void refreshChessBoard(ChessBoard chessBoard) {
		if(chessBoard == null) {
			this.chessBoard = new ChessBoard();
		}
		else {
			this.chessBoard = chessBoard;
		}
		chessView.refreshChessBoard(this.chessBoard);
	}
	
}

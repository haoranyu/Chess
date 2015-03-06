package controller;
import java.util.Hashtable;

import modelCore.ChessBoard;
import modelCore.Position;
import views.GUI;

/**
 * @author haoranyu
 *
 */
public class Chess {
	
	private GUI chessView;
	private ChessBoard chessBoard;
	private Hashtable<String, Integer> score;
	
	/**
	 * @param args not specified
	 */
	public Chess() {
		chessView = new GUI(80);
		
		chessBoard = new ChessBoard();
		
		score = new Hashtable<String, Integer>();
		score.put("black", 0);
		score.put("white", 0);
		
		PieceListener.setController(this);
		MenuListener.setController(this);
	}
	

	public void move(Position fromPosition, Position toPosition) {
		if(chessBoard.getChessPieceInPosition(fromPosition).getType().equals(chessBoard.getTurn())) {
			if(chessBoard.move(chessBoard.getChessPieceInPosition(fromPosition), toPosition)){
				chessView.refreshChessBoard(chessBoard);
				chessBoard.changeTurn();
			}
		}
	}
	
	public void revertMove() {
		if(chessBoard.revertMove()){
			chessView.refreshChessBoard(chessBoard);
		}
		else {
			chessView.popMsg("There is no record of move avaliable");
		}
	}

	/**
	 * 
	 * @param chessBoard
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

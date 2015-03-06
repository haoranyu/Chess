package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	}
	
	public void move(Position fromPosition, Position toPosition) {
		chessBoard.move(chessBoard.getChessPieceInPosition(fromPosition), toPosition);
		chessView.refreshChessBoard(chessBoard);
	}
}

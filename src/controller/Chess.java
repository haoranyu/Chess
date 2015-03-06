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
	private String turn;
	
	/**
	 * @param args not specified
	 */
	public Chess() {
		chessView = new GUI(80);
		
		chessBoard = new ChessBoard();
		
		score = new Hashtable<String, Integer>();
		score.put("black", 0);
		score.put("white", 0);
		
		turn = "white";
		
		PieceListener.setController(this);
	}
	
	private void changeTurn(){
		if(this.turn.equals("white")) {
			this.turn = "black";
		}
		else {
			this.turn = "white";
		}
	}
	
	public void move(Position fromPosition, Position toPosition) {
		if(chessBoard.getChessPieceInPosition(fromPosition).getType().equals(this.turn)) {
			chessBoard.move(chessBoard.getChessPieceInPosition(fromPosition), toPosition);
			chessView.refreshChessBoard(chessBoard);
			this.changeTurn();
		}
	}
}

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
	
	private GUI chessView;
	private ChessBoard chessBoard;
	private HashMap<String, Integer> score;
	
	/**
	 * @param args not specified
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
	
	public void revertMove() {
		if(chessBoard.revertMove()){
			chessView.refreshChessBoard(chessBoard);
		}
		else {
			chessView.popMsg("There is no record of move avaliable");
		}
	}
	
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

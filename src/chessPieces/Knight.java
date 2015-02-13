package chessPieces;
import models.ChessBoard;
import models.Position;






/**
 * This is the class for knight
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:26
 * @version 1.0
 */

public class Knight extends ChessPiece {

	/**
	 * Constructor for default Knight
	 * 
	 * @param type		the color or null
	 * @param number	the numbering of knight
	 */
	public Knight(String type, int number) {
		if(type == "white") {
			switch(number){
			case 1: this.setPosition(new Position(1, 2)); break;
			case 2: this.setPosition(new Position(1, 7)); 
			}
		}
		else { // black
			switch(number){
			case 1: this.setPosition(new Position(8, 2)); break;
			case 2: this.setPosition(new Position(8, 7)); 
			}
		}
		this.moved = false;
		this.setName("knight");
		this.setType(type);
		this.number = number;
	}
	
	/**
	 * Constructor for Knight with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this knight
	 * @param number	the numbering of knight
	 */
	public Knight(String type, Position position, int number) {
		this.moved = true;
		this.setName("knight");
		this.setType(type);
		this.number = number;
		this.setPosition(position);
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, 1, 2);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, 1, -2);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, -1, 2);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, -1, -2);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, 2, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, 2, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, -2, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, -2, -1);
	}

}

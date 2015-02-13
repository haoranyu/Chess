package chessPieces;
import models.ChessBoard;
import models.Position;






/**
 * This is the class for queen
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:38
 * @version 1.0
 */

public class Queen extends ChessPiece {

	/**
	 * Constructor for default Queen
	 * 
	 * @param type		the color or null
	 */
	public Queen(String type) {
		if(type == "white") {
			this.setPosition(new Position(1, 4));
		}
		else { // black
			this.setPosition(new Position(8, 4));
		}
				
		this.moved = false;
		this.setName("queen");
		this.setType(type);
		this.number = 1;
	}
	
	/**
	 * Constructor for Queen with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this queen
	 */
	public Queen(String type, Position position) {
		this.moved = true;
		this.setName("queen");
		this.setType(type);
		this.number = 1;
		this.setPosition(position);
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 7, -1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 7, 1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 7, 0, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 7, 0, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 7, 1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 7, 1, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 7, -1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 7, -1, 1);
	}

}

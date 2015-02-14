package modelChessPieces;
import modelCore.ChessBoard;
import modelCore.Position;

/**
 * This is the class for rook
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:42
 * @version 1.0
 */

public class Rook extends ChessPiece {

	/**
	 * Constructor for default Rook
	 * 
	 * @param type		the color or null
	 * @param number	the numbering of rook
	 */
	public Rook(String type, int number) {
		if(type == "white") {
			switch(number){
			case 1: this.setPosition(new Position(1, 1)); break;
			case 2: this.setPosition(new Position(1, 8)); 
			}
		}
		else { // black
			switch(number){
			case 1: this.setPosition(new Position(8, 1)); break;
			case 2: this.setPosition(new Position(8, 8)); 
			}
		}
		
		this.moved = false;
		this.name = "rook";
		this.type = type;
		this.number = number;
	}
	
	/**
	 * Constructor for Rook with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this rook
	 * @param number	the numbering of rook
	 */
	public Rook(String type, Position position, int number) {
		this.moved = true;
		this.name = "rook";
		this.type = type;
		this.number = number;
		this.position = position;
	}
	
	/**
	 * Get all possible position for the next step
	 * 
	 * @param chessBoard the chess board we are now on
	 */
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), -1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 0, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 0, -1);
	}

}

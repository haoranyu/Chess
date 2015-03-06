package modelChessPieces;
import modelCore.ChessBoard;
import modelCore.Position;


/**
 * This is the class for bishop
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:13
 * @version 1.0
 */
public class Bishop extends ChessPiece {

	/**
	 * Constructor for default Bishop
	 * 
	 * @param type		the color or null
	 * @param number	the numbering of bishop
	 */
	public Bishop(String type, int number) {
		if(type == "white") {
			switch(number){
			case 1: this.setPosition(new Position(1, 3)); break;
			case 2: this.setPosition(new Position(1, 6)); 
			}
		}
		else { // black
			switch(number){
			case 1: this.setPosition(new Position(8, 3)); break;
			case 2: this.setPosition(new Position(8, 6)); 
			}
		}
		this.moved = false;
		this.name = "bishop";
		this.type = type;
		this.number = number;
	}
	
	/**
	 * Constructor for Bishop with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this bishop
	 * @param number	the numbering of bishop
	 */
	public Bishop(String type, Position position, int number) {
		this.moved = true;
		this.name = "bishop";
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
	public void getPossibleNextPositions(ChessBoard chessBoard) {

		System.out.println(this.getType()+" "+this.getName());
		
		
		// remove all before computing new possible next position
		this.possibleNextPositions.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), -1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), -1, 1);
	}

}

package modelChessPieces;
import modelCore.ChessBoard;
import modelCore.Position;


/**
 * This is the class for princess
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:26
 * @version 1.0
 */

public class Princess extends ChessPiece {

	/**
	 * Constructor for default Princess
	 * 
	 * @param type		the color or null
	 * @param number	the numbering of princess
	 */
	public Princess(String type, int number) {
		if(type == "white") {
			switch(number){
			case 1: this.setPosition(new Position(4, 3)); break;
			case 2: this.setPosition(new Position(4, 6)); 
			}
		}
		else { // black
			switch(number){
			case 1: this.setPosition(new Position(5, 3)); break;
			case 2: this.setPosition(new Position(5, 6)); 
			}
		}
		this.moved = false;
		this.name = "princess";
		this.type = type;
		this.number = number;
	}
	
	/**
	 * Constructor for Princess with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this princess
	 * @param number	the numbering of princess
	 */
	public Princess(String type, Position position, int number) {
		this.moved = true;
		this.name = "princess";
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
		
		this.addIfAvaliable(chessBoard, this.getPosition().getDown(1).getLeft(2));
		this.addIfAvaliable(chessBoard, this.getPosition().getDown(1).getRight(2));
		this.addIfAvaliable(chessBoard, this.getPosition().getUp(1).getLeft(2));
		this.addIfAvaliable(chessBoard, this.getPosition().getUp(1).getRight(2));
		
		this.addIfAvaliable(chessBoard, this.getPosition().getDown(2).getLeft(1));
		this.addIfAvaliable(chessBoard, this.getPosition().getDown(2).getRight(1));
		this.addIfAvaliable(chessBoard, this.getPosition().getUp(2).getLeft(1));
		this.addIfAvaliable(chessBoard, this.getPosition().getUp(2).getRight(1));
		
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), -1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), -1, 1);
	}

}

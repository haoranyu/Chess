package modelChessPieces;
import modelCore.ChessBoard;
import modelCore.Position;


/**
 * This is the class for princess
 * A princess (also known as a cardinal,
 *  archbishop, or simply bishop+knight compound) 
 *  is a fairy chess piece that can move like a 
 *  bishop or a knight. It cannot jump over other
 *  pieces when moving as a bishop, but may do 
 *  so when moving as a knight. 
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
	public void getPossibleNextPositions(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPositions.clear();
		
		this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(-2, -1));
		this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(2, -1));
		this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(-2, 1));
		this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(2, 1));
		
		this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(1, 2));
		this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(-1, 2));
		this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(1, -2));
		this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(-1, -2));
		
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), -1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), -1, 1);
	}

}

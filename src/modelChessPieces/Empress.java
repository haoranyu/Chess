package modelChessPieces;
import modelCore.ChessBoard;
import modelCore.Position;

/**
 * This is the class for empress
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:26
 * @version 1.0
 */

public class Empress extends ChessPiece {

	/**
	 * Constructor for default Empress
	 * 
	 * @param type		the color or null
	 * @param number	the numbering of empress
	 */
	public Empress(String type, int number) {
		if(type == "white") {
			switch(number){
			case 1: this.setPosition(new Position(3, 1)); break;
			case 2: this.setPosition(new Position(3, 8)); 
			}
		}
		else { // black
			switch(number){
			case 1: this.setPosition(new Position(6, 1)); break;
			case 2: this.setPosition(new Position(6, 8)); 
			}
		}
		this.moved = false;
		this.name = "empress";
		this.type = type;
		this.number = number;
	}
	
	/**
	 * Constructor for Empress with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this knight
	 * @param number	the numbering of knight
	 */
	public Empress(String type, Position position, int number) {
		this.moved = true;
		this.name = "empress";
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
		
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), -1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 0, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.getPosition(), 0, -1);
	}

}

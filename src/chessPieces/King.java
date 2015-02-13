package chessPieces;
import models.ChessBoard;
import models.Position;






/**
 * This is the class for king
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:22
 * @version 1.0
 */

public class King extends ChessPiece {

	/**
	 * Constructor for default King
	 * 
	 * @param type		the color or null
	 */
	public King(String type) {
		if(type == "white") {
			this.setPosition(new Position(1, 5));
		}
		else { // black
			this.setPosition(new Position(8, 5));
		}
		this.moved = false;
		this.name = "king";
		this.type = type;
		this.number = 1;
	}
	
	/**
	 * Constructor for King with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this king
	 */
	public King(String type, Position position) {
		this.moved = true;
		this.name = "king";
		this.type = type;
		this.number = 1;
		this.position = position;
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.addIfAvaliable(chessBoard, this.getPosition().getLeft(1));
		this.addIfAvaliable(chessBoard, this.getPosition().getDown(1));
		this.addIfAvaliable(chessBoard, this.getPosition().getUp(1));
		this.addIfAvaliable(chessBoard, this.getPosition().getRight(1));
		
		this.addIfAvaliable(chessBoard, this.getPosition().getDown(1).getLeft(1));
		this.addIfAvaliable(chessBoard, this.getPosition().getDown(1).getRight(1));
		this.addIfAvaliable(chessBoard, this.getPosition().getUp(1).getLeft(1));
		this.addIfAvaliable(chessBoard, this.getPosition().getUp(1).getRight(1));
		
	}

}

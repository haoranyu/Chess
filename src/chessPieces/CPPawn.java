package chessPieces;
import models.ChessBoard;
import models.Position;






/**
 * This is the class for pawn
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:30
 * @version 1.0
 */

public class CPPawn extends ChessPiece {

	/**
	 * Constructor for default Pawn
	 * 
	 * @param type		the color or null
	 * @param number	the numbering of pawn
	 */
	public CPPawn(String type, int number) {
		if(type == "white") {
			this.setPosition(new Position(2, number));
		}
		else { // black
			this.setPosition(new Position(7, number));
		}
		
		this.moved = false;
		this.setName("pawn");
		this.setType(type);
		this.number = number;
	}
	
	/**
	 * Constructor for Pawn with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this pawn
	 * @param number	the numbering of pawn
	 */
	public CPPawn(String type, Position position, int number) {
		this.moved = true;
		this.setName("pawn");
		this.setType(type);
		this.number = number;
		this.setPosition(position);
	}
	
	/**
	 * This override for Pawn case which is special
	 * If the cell is valid AND is not self-occupied AND not duplicates, 
	 * Then add to possible position
	 * 
	 * @param chessBoard	The object of chess board
	 * @param position		The position we see into
	 */
	@Override
	protected boolean addIfAvaliable(ChessBoard chessBoard, Position position) {
		if(position.valid(chessBoard)){
			if(this.getPosition().getCol() == position.getCol()) {
				// go in a line
				if(!chessBoard.occupied(position)) {
					// should be empty for going straightforward
					if(!this.possibleNextPosition.contains(position)) {
						this.possibleNextPosition.add(position);
					}
				}
			}
			else {
				// go in diagonal  
				if(chessBoard.occupied(position) && !this.selfOccupied(chessBoard, position)) {
					if(!this.possibleNextPosition.contains(position)) {
						this.possibleNextPosition.add(position);
					}
				}
			}
		}
		// since it is not iterating, meaningless. But for the format of override. Hence return false.
		return false;
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		if(this.getType() == "white") {
			if(this.moved == false) {
				// check if not moved at all. Pawn can move 2 steps forward
				this.addIfAvaliable(chessBoard, this.getPosition().getUp(2));
			}
			// Normal case for moved pawn. 
			this.addIfAvaliable(chessBoard, this.getPosition().getUp(1));
			this.addIfAvaliable(chessBoard, this.getPosition().getUp(1).getLeft(1));
			this.addIfAvaliable(chessBoard, this.getPosition().getUp(1).getRight(1));
		}
		else { // black
			if(this.moved == false) {
				// check if not moved at all. Pawn can move 2 steps forward
				this.addIfAvaliable(chessBoard, this.getPosition().getDown(2));
			}
			// Normal case for moved pawn. 
			this.addIfAvaliable(chessBoard, this.getPosition().getDown(1));
			this.addIfAvaliable(chessBoard, this.getPosition().getDown(1).getLeft(1));
			this.addIfAvaliable(chessBoard, this.getPosition().getDown(1).getRight(1));
		}
	}

}

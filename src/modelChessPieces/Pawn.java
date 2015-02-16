package modelChessPieces;
import modelCore.ChessBoard;
import modelCore.Position;






/**
 * This is the class for pawn
 */

/**
 * @author haoranyu
 * @since  2015-02-13 16:48:36
 * @version 1.0
 */

public class Pawn extends ChessPiece {

	/**
	 * Constructor for default Pawn
	 * 
	 * @param type		the color or null
	 * @param number	the numbering of pawn
	 */
	public Pawn(String type, int number) {
		if(type == "white") {
			this.setPosition(new Position(2, number));
		}
		else { // black
			this.setPosition(new Position(7, number));
		}
		
		this.moved = false;
		this.name = "pawn";
		this.type = type;
		this.number = number;
	}
	
	/**
	 * Constructor for Pawn with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this pawn
	 * @param number	the numbering of pawn
	 */
	public Pawn(String type, Position position, int number) {
		this.moved = true;
		this.name = "pawn";
		this.type = type;
		this.number = number;
		this.position = position;
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
					if(!this.possibleNextPositions.contains(position)) {
						this.possibleNextPositions.add(position);
					}
				}
			}
			else {
				// go in diagonal  
				if(chessBoard.occupied(position) && !this.selfOccupied(chessBoard, position)) {
					if(!this.possibleNextPositions.contains(position)) {
						this.possibleNextPositions.add(position);
					}
				}
			}
		}
		// since it is not iterating, meaningless. But for the format of override. Hence return false.
		return false;
	}
	
	/**
	 * Get all possible position for the next step
	 * 
	 * @param chessBoard the chess board we are now on
	 */
	@Override
	public void getpossibleNextPositions(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPositions.clear();
		
		if(this.getType() == "white") {
			if(this.moved == false) {
				// check if not moved at all. Pawn can move 2 steps forward
				this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(0, 2));
			}
			// Normal case for moved pawn. 
			this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(0, 1));
			this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(-1, 1));
			this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(1, 1));
		}
		else { // black
			if(this.moved == false) {
				// check if not moved at all. Pawn can move 2 steps forward
				this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(0, -2));
			}
			// Normal case for moved pawn. 
			this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(0, -1));
			this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(-1, -1));
			this.addIfAvaliable(chessBoard, this.getPosition().getRelativePosition(1, -1));
		}
	}

}

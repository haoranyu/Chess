/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPPawn extends ChessPiece {

	/**
	 * Constructor for default Pawn
	 * @param type
	 * @param number
	 */
	public CPPawn(String type, int number) {
		if(type == "white") {
			this.position = new Position(2, number);
		}
		else { // black
			this.position = new Position(7, number);
		}
		this.number = number;
		this.type = type;
		this.moved = false;
	}
	
	/**
	 * Constructor for Pawn with specified position
	 * @param type
	 * @param position
	 * @param number
	 */
	public CPPawn(String type, Position position, int number) {
		this.position = position;
		this.type = type;
		this.number = number;
		this.moved = true;
	}
	
	/**
	 * This override for Pawn case which is special
	 * If the cell is valid & is not self-occupied & not duplicates, 
	 * Then add to possible position
	 * @param chessBoard
	 * @param position
	 */
	@Override
	public boolean addIfAvaliable(ChessBoard chessBoard, Position position) {
		if(position.valid()){
			if(this.position.col == position.col) {
				// go in a line
				if(!occupied(chessBoard, position)) {
					// should be empty for going straightforward
					if(!this.possibleNextPosition.contains(position)) {
						this.possibleNextPosition.add(position);
					}
				}
			}
			else {
				// go in diagonal  
				if(occupied(chessBoard, position) && !selfOccupied(chessBoard, position)) {
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
		
		if(this.type == "white") {
			if(this.moved == false) {
				// check if not moved at all. Pawn can move 2 steps forward
				this.addIfAvaliable(chessBoard, this.position.getUp(2));
			}
			// Normal case for moved pawn. 
			this.addIfAvaliable(chessBoard, this.position.getUp(1));
			this.addIfAvaliable(chessBoard, this.position.getUp(1).getLeft(1));
			this.addIfAvaliable(chessBoard, this.position.getUp(1).getRight(1));
		}
		else { // black
			if(this.moved == false) {
				// check if not moved at all. Pawn can move 2 steps forward
				this.addIfAvaliable(chessBoard, this.position.getDown(2));
			}
			// Normal case for moved pawn. 
			this.addIfAvaliable(chessBoard, this.position.getDown(1));
			this.addIfAvaliable(chessBoard, this.position.getDown(1).getLeft(1));
			this.addIfAvaliable(chessBoard, this.position.getDown(1).getRight(1));
		}
	}

}

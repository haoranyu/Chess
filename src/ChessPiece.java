import java.util.ArrayList;

/**
 * @author haoranyu
 *
 */
public abstract class ChessPiece {
	
	boolean 	moved; 	// is chess piece moved or not
	String 		type;   // the color or null
	int 		number;	// the numbering for the same kind of chess piece
	Position 	position; // the position of the chess piece
	
	ArrayList<Position> possibleNextPosition = new ArrayList<>(); 
	// the list for storing the next possible positions
	
	/**
	 * The move function for a chessPiece to move
	 * @param chessBoard
	 * @param newPosition
	 * @return
	 */
	public boolean move(ChessBoard chessBoard, Position newPosition) {
		this.getPossibleNextPosition(chessBoard);
		if(this.possibleNextPosition.contains(newPosition)){
			// TODO add the original dead piece to the stack
			
			// Mark this chess piece as moved
			if(this.moved == false) {
				this.moved = true;
			}
			
			// Add a record for this movement
			Record moveRecord = new Record(
					this.position,
					chessBoard.getChessPieceInPosition(this.position), 
					newPosition,
					chessBoard.getChessPieceInPosition(newPosition)
					);
			
			chessBoard.records.push(moveRecord);
			
			chessBoard.setChessPieceInPosition(newPosition, this);
			chessBoard.clearPosition(this.position);
			
			this.position = newPosition;
			
			return true;
		}
		else{
			// will be handled by controller. Now just print error out
			System.out.print("WARNING: You cannot move to ");
			newPosition.show();
			System.out.print("\n");
			return false;
		}
	}
	
	/**
	 * Check whether the expected position is occupied by the same color
	 * @param chessBoard
	 * @param position
	 * @return
	 */
	public boolean selfOccupied(ChessBoard chessBoard, Position position) {
		if(this.type.equals(chessBoard.getChessPieceInPosition(position).type)){
			// check non-empty, color equal to color of itself
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Check if the position is occupied by any chess piece
	 * @param chessBoard
	 * @param position
	 * @return
	 */
	public boolean occupied(ChessBoard chessBoard, Position position) {
		if(!chessBoard.getChessPieceInPosition(position).type.equals("null")){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * If the cell is vaild & is not self-occupied & not duplicates, 
	 * Then add to possible position
	 * @param chessBoard
	 * @param position
	 */
	public boolean addIfAvaliable(ChessBoard chessBoard, Position position) {
		boolean shouldGoOn = true;
		
		if(position.valid()){
			if(occupied(chessBoard, position)) {
				shouldGoOn = false;
			}
			if(!this.selfOccupied(chessBoard, position)) {
				// do not add available if self occupied
				if(!this.possibleNextPosition.contains(position)) {
					// get rid of duplicates
					this.possibleNextPosition.add(position);
				}
			}
		}

		return shouldGoOn;
	}
	
	/**
	 * Iteratively checking the cells to see if available and then add 
	 * @param chessBoard
	 * @param startPosition
	 * @param maxIteration
	 * @param toRight
	 * @param toUp
	 */
	public void iterativeAddPossiblePosition(ChessBoard chessBoard, Position startPosition, int maxIteration, int toRight, int toUp) {
		boolean shouldGoOn = true;
		Position position = new Position(startPosition);
		while(maxIteration > 0) {
			position = new Position(position.getRight(toRight).getUp(toUp));
			shouldGoOn = addIfAvaliable(chessBoard, position);
			if(!shouldGoOn) {
				break;
			}
			maxIteration--;
		}
	}
	
	/**
	 * Help function to show all possible function
	 * WILL BE REMOVED LATER
	 */
	public void showPossibleNextPosition(ChessBoard chessBoard) {
		System.out.print("All possible next positions are:\n");
		this.getPossibleNextPosition(chessBoard);
		for (int counter = 0; counter < this.possibleNextPosition.size(); counter++) {
			this.possibleNextPosition.get(counter).show();
		}
	}
	
	/**
	 * According to the type of chessPiece and than calculate the possibleNextPosition
	 * @param chessBoard
	 */
	public abstract void getPossibleNextPosition(ChessBoard chessBoard);
	
}

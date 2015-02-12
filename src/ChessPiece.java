import java.util.ArrayList;

/**
 * @author haoranyu
 *
 */
public abstract class ChessPiece {
	String type;
	int number;
	Position position;
	ArrayList<Position> possibleNextPosition = new ArrayList<>();
	
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
			// will be handled for GUI
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
	
	public boolean occupied(ChessBoard chessBoard, Position position) {
		if(!chessBoard.getChessPieceInPosition(position).type.equals("null")){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * If the cell is not occupied by itself, we add the cell to possibleNextPosition list
	 * @param chessBoard
	 * @param position
	 */
	public boolean addIfAvaliable(ChessBoard chessBoard, Position position) {
		boolean shouldGoOn = true;
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
		return shouldGoOn;
	}
	
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
	public void showPossibleNextPosition() {
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

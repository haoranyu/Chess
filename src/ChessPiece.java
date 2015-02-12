import java.util.ArrayList;

/**
 * @author haoranyu
 *
 */
public abstract class ChessPiece {
	String color;
	Position position;
	ArrayList<Position> possibleNextPosition = new ArrayList<>();
	
	/**
	 * The move function for a chessPiece to movev
	 * @param chessBoard
	 * @param newPosition
	 * @return
	 */
	public boolean move(ChessBoard chessBoard, Position newPosition) {
		this.getPossibleNextPosition(chessBoard);
		if(this.possibleNextPosition.contains(newPosition)){
			// TODO add the original dead piece to the stack
			
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
		if(chessBoard.getChessPieceInPosition(position) == null) {
			// check if is an empty cell
			return false;
		}
		else if(this.color.equals(chessBoard.getChessPieceInPosition(position).color)){
			// check non-empty color equal to color of itself
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
	public void addIfNotSelfOccupied(ChessBoard chessBoard, Position position) {
		if(!this.selfOccupied(chessBoard, position)) {
			// do not add available if self occupied
			if(!this.possibleNextPosition.contains(position)) {
				// get rid of duplicates
				this.possibleNextPosition.add(position);
			}
		}
	}
	
	/**
	 * Help function to show all possible function
	 * WILL BE REMOVED LATER
	 */
	public void showPossibleNextPosition() {
		for (int i = 0; i < this.possibleNextPosition.size(); i++) {
			this.possibleNextPosition.get(i).show();
		}
	}
	
	/**
	 * According to the type of chessPiece and than calculate the possibleNextPosition
	 * @param chessBoard
	 */
	public abstract void getPossibleNextPosition(ChessBoard chessBoard);
	
}

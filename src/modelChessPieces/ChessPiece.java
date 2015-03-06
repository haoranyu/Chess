package modelChessPieces;

/**
 * Any empty cell in the chess board will be viewed as empty chess piece.
 */

import java.util.ArrayList;

import modelCore.ChessBoard;
import modelCore.Position;


/**
 * @author haoranyu
 * @since  2015-02-16 03:56:20
 * @version 1.1
 */
public abstract class ChessPiece {
	
	protected 	boolean 	moved; 	/**< is chess piece moved or not */
	protected 	String 		name;	/**< the name of the chess piece */
	protected 	String 		type;   /**< the color or null */
	protected 	int 		number;	/**< the numbering for the same kind of chess piece */
	protected 	Position 	position; /**< the position of the chess piece */ 
	
	public ArrayList<Position> possibleNextPositions = new ArrayList<>(); /**< the list for storing the next possible positions */ 
	
	
	
	/**
	 * Check whether the expected position is occupied by the same color
	 * 
	 * @param chessBoard	The object of chess board
	 * @param position		The position we see into
	 * @return				Return true if occupied by player himself
	 */
	protected boolean selfOccupied(ChessBoard chessBoard, Position position) {
		if(this.getType().equals(chessBoard.getChessPieceInPosition(position).getType())){
			// check non-empty, color equal to color of itself
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * If the cell is valid AND is not self-occupied AND not duplicates, 
	 * Then add to possible position
	 * 
	 * @param chessBoard	The object of chess board
	 * @param position		The position we see into
	 * @return				Return true if the outer iteration should going on
	 */
	protected boolean addIfAvaliable(ChessBoard chessBoard, Position position) {
		boolean shouldGoOn = true;
		
		if(position.valid(chessBoard)){
			if(chessBoard.occupied(position)) {
				shouldGoOn = false;
			}
			if(!this.selfOccupied(chessBoard, position)) {
				// do not add available if self occupied
				if(!this.possibleNextPositions.contains(position)) {
					// get rid of duplicates

//					ChessBoard pusedoChessBoard = new ChessBoard(chessBoard);
//					pusedoChessBoard.setChessPieceInPosition(position, this);
//					pusedoChessBoard.clearPosition(this.getPosition());
//					
//					if(!pusedoChessBoard.selfChecked(this)) {
//						position.show();

						this.possibleNextPositions.add(position);
//					}
				}
			}
		}

		return shouldGoOn;
	}
	
	/**
	 * Iteratively checking the cells to see if available and then add 
	 * 
	 * @param chessBoard	The object of chess board
	 * @param startPosition	The position where iteration starts
	 * @param xDelta		In each iteration we move how many step on x
	 * @param yDelta		In each iteration we move how many step on y
	 */
	protected void iterativeAddPossiblePosition(ChessBoard chessBoard, 
							Position startPosition, int xDelta, int yDelta) {
		boolean shouldGoOn = true;
		Position position = new Position(startPosition);
		while(position.valid(chessBoard)) {
			position = new Position(position.getRelativePosition(xDelta, yDelta));
			shouldGoOn = addIfAvaliable(chessBoard, position);
			if(!shouldGoOn) {
				break;
			}
		}
	}
	
	/**
	 * Help function to show all possible function
	 * WILL BE REMOVED LATER
	 * 
	 * @param chessBoard	The object of chess board
	 */
	public void showpossibleNextPositions(ChessBoard chessBoard) {
		System.out.print("All possible next positions are:\n");
		this.getPossibleNextPositions(chessBoard);
		for( Position possibleNextPosition : this.possibleNextPositions) {
			possibleNextPosition.show();
		}
	}
	
	
	/**
	 * According to the type of chessPiece and than calculate the possibleNextPositions
	 * 
	 * @param chessBoard	The object of chess board
	 */
	public abstract void getPossibleNextPositions(ChessBoard chessBoard);

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the enemy type
	 */
	public String getEnemyType() {
		if(this.type.equals("white")) {
			return "black";
		}
		else if(this.type.equals("black")){
			return "white";
		}
		else {
			return "null";
		}
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the moved
	 */
	public boolean isMoved() {
		return moved;
	}

	/**
	 * @param moved the moved to set
	 */
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	
}

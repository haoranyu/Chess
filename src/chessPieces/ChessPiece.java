package chessPieces;

/**
 * @author haoranyu
 * @since  2015-02-13 16:48:21
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;

import models.ChessBoard;
import models.Position;



public abstract class ChessPiece {
	
	protected 	boolean 	moved; 	// is chess piece moved or not
	protected 	String 		name;	// the name of the chess piece
	protected 	String 		type;   // the color or null
	protected 	int 		number;	// the numbering for the same kind of chess piece
	private 	Position 	position; // the position of the chess piece
	
	ArrayList<Position> possibleNextPosition = new ArrayList<>(); 
	// the list for storing the next possible positions
	
	/**
	 * The move function for a chessPiece to move
	 * 
	 * @param chessBoard	The object of chess board
	 * @param newPosition	The position we are moving to
	 * @return				Return true if it is possible
	 */
	public boolean move(ChessBoard chessBoard, Position newPosition) {
		this.getPossibleNextPosition(chessBoard);
		if(this.possibleNextPosition.contains(newPosition)){
			// TODO add the original dead piece to the stack
			
			// Mark this chess piece as moved
			if(this.moved == false) {
				this.moved = true;
			}

			if(chessBoard.getChessPieceInPosition(newPosition).getName().equals("king") &&
				!chessBoard.getChessPieceInPosition(newPosition).getType().equals(this.getType())) {
				chessBoard.setWin(this.getType());
				System.out.print("WARNING: "+this.getType()+" win!\n");
			}

			// Add a record for this movement
			chessBoard.addRecord(this.getPosition(), chessBoard.getChessPieceInPosition(this.getPosition()), 
					newPosition, chessBoard.getChessPieceInPosition(newPosition));
			
			
			chessBoard.setChessPieceInPosition(newPosition, this);
			chessBoard.clearPosition(this.getPosition());
			
			this.setPosition(newPosition);
			
			if(this.checkOtherKing(chessBoard)) {
				System.out.print("WARNING: Other's king get checked\n");
			}
			
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
	 * 
	 * @param chessBoard	The object of chess board
	 * @param startPosition	The position where iteration starts
	 * @param maxIteration	The maximum iterations we are expecting
	 * @param toRight		In each iteration we move how many step to right
	 * @param toUp			In each iteration we move how many step to top
	 */
	protected void iterativeAddPossiblePosition(ChessBoard chessBoard, Position startPosition, 
						int maxIteration, int toRight, int toUp) {
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
	 * 
	 * @param chessBoard	The object of chess board
	 */
	public void showPossibleNextPosition(ChessBoard chessBoard) {
		System.out.print("All possible next positions are:\n");
		this.getPossibleNextPosition(chessBoard);
		for (int counter = 0; counter < this.possibleNextPosition.size(); counter++) {
			this.possibleNextPosition.get(counter).show();
		}
	}
	
	/**
	 * See whether the chess piece is now checking the other king
	 * 
	 * @param chessBoard	The object of chess board
	 * @return	True if there king of others is under checking
	 */
	public boolean checkOtherKing(ChessBoard chessBoard) {
		this.getPossibleNextPosition(chessBoard);
		
		Iterator<Position> nextPositionItr = possibleNextPosition.iterator();
		while (nextPositionItr.hasNext()) {
			Position aimPosition = nextPositionItr.next();
			if(chessBoard.getChessPieceInPosition(aimPosition).getName().equals("king") &&
				!chessBoard.getChessPieceInPosition(aimPosition).getType().equals(this.getType())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * According to the type of chessPiece and than calculate the possibleNextPosition
	 * 
	 * @param chessBoard	The object of chess board
	 */
	public abstract void getPossibleNextPosition(ChessBoard chessBoard);

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
	
}

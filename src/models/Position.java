package models;




/**
 * This is the class for position on the chess board
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:47
 * @version 1.0
 */

public class Position {
	
	private int row;	// row number
	private int col;	// column number
	
	/**
	 * Constructor with no parameters
	 * Get a position without meaning
	 */
	public Position() {
		this.row = 0;
		this.col = 0;
	}
	
	/**
	 * Copy constructor
	 * 
	 * @param position	The position to copy from
	 */
	public Position(Position position) {
		this.row = position.row;
		this.col = position.getCol();
	}
	
	/**
	 * Constructor of Position with initial row and column
	 * 
	 * @param row	The row of position to initialize from
	 * @param col	The column of position to initialize from
	 */
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Get the position to #step away to the right
	 * 
	 * @param step	The number of steps
	 * @return		The new position after calucation
	 */
	public Position getRight(int step) {
		Position newPosition = new Position(this.row, this.getCol() + step);
		return newPosition;
	}
	
	/**
	 * Get the position to #step away to the left
	 * 
	 * @param step	The number of steps
	 * @return		The new position after calucation
	 */
	public Position getLeft(int step) {
		return this.getRight(-step);
	}
	
	/**
	 * Get the position to #step away to the top
	 * 
	 * @param step	The number of steps
	 * @return		The new position after calucation
	 */
	public Position getUp(int step) {
		Position newPosition = new Position(this.row + step, this.getCol());
		return newPosition;
	}
	
	/**
	 * Get the position to #step away to the bottom
	 * 
	 * @param step	The number of steps
	 * @return		The new position after calucation
	 */
	public Position getDown(int step) {
		return this.getUp(-step);
	}
	
	/**
	 * A print out help function that print the pair of position
	 * WILL BE REMOVED LATER
	 */
	public void show() {
		System.out.print("(" + row + "," + getCol() + ")\n");
	}
	
	/**
	 * Test whether the position is in the chess board
	 * 
	 * @param chessBoard	The chess board we see into
	 * @return				True if the row and column specified exist in the chess board
	 */
	public boolean valid(ChessBoard chessBoard){
		if(this.row > 0 && this.getCol() > 0 && this.row <= chessBoard.row && this.getCol() <= chessBoard.col) {
			return true;
		}
		return false;
	}
	
	/**
	 * Override original equals function
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		Position position = (Position) object;
		
		if(this.row == position.row && 
		   this.getCol() == position.getCol()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Override original hashCode function
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.row * 10 + this.getCol();
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}


}

/**
 * @author haoranyu
 *
 */
public class Position {
	
	int row;	// row number
	int col;	// column number
	
	/**
	 * Constructor with no parameters
	 * Get a position without meaning
	 */
	public Position() {
		this.row = 0;
		this.col = 0;
	}
	
	/**
	 * Constructor with no parameters
	 */
	public Position(Position position) {
		this.row = position.row;
		this.col = position.col;
	}
	
	/**
	 * Constructor of Position with initial row and column
	 * @param row
	 * @param col
	 */
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Get the position to #step away to the right
	 * @param step
	 * @return
	 */
	public Position getRight(int step) {
		int newCol;
		
		if(this.col + step > 8) {
			newCol = 8;
		}
		else if(this.col + step < 1) {
			newCol = 1;
		}
		else {
			newCol = this.col + step;
		}
		
		Position newPosition = new Position(this.row, newCol);
		return newPosition;
	}
	
	/**
	 * Get the position to #step away to the left
	 * @param step
	 * @return
	 */
	public Position getLeft(int step) {
		return this.getRight(-step);
	}
	
	/**
	 * Get the position to #step away to the top
	 * @param step
	 * @return
	 */
	public Position getUp(int step) {
		int newRow;
		
		if(this.row + step > 8) {
			newRow = 8;
		}
		else if(this.row + step < 1) {
			newRow = 1;
		}
		else {
			newRow = this.row + step;
		}
		
		Position newPosition = new Position(newRow, this.col);
		return newPosition;
	}
	
	/**
	 * Get the position to #step away to the bottom
	 * @param step
	 * @return
	 */
	public Position getDown(int step) {
		return this.getUp(-step);
	}
	
	/**
	 * A print out function that print the pair of position
	 */
	public void show() {
		System.out.print("(" + row + "," + col + ")\n");
	}
	
	/**
	 * Override original equals function
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		Position position = (Position) object;
		
		if(this.row == position.row && 
		   this.col == position.col) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Override original hashCode function
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.row * 10 + this.col;
	}
}

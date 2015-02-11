/**
 * @author haoranyu
 *
 */
public class Position {
	
	int row;	// row number
	int col;	// column number
	
	/* 
	 * Constructor with no parameters
	 */
	public Position() {
		this.row = 0;
		this.col = 0;
	}
	
	/* 
	 * Constructor of Position with initial row and column
	 */
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/*
	 *  A print out function that print the pair of position
	 */
	public void show() {
		System.out.print("(" + row + "," + col + ")");
	}
}

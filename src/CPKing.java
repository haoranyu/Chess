/**
 * This is the class for king
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:22
 * @version 1.0
 */

public class CPKing extends ChessPiece {

	/**
	 * Constructor for default King
	 * 
	 * @param type		the color or null
	 */
	public CPKing(String type) {
		if(type == "white") {
			this.position = new Position(1, 5);
		}
		else { // black
			this.position = new Position(8, 5);
		}
		
		this.type = type;
		this.number = 1;
		this.moved = false;
	}
	
	/**
	 * Constructor for King with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this king
	 */
	public CPKing(String type, Position position) {
		this.position = position;
		this.type = type;
		this.moved = true;
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, -1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, 1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, 0, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, 0, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, 1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, 1, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, -1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, -1, 1);
	}

}

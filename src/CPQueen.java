/**
 * This is the class for queen
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:38
 * @version 1.0
 */

public class CPQueen extends ChessPiece {

	/**
	 * Constructor for default Queen
	 * 
	 * @param type		the color or null
	 */
	public CPQueen(String type) {
		if(type == "white") {
			this.position = new Position(1, 4);
		}
		else { // black
			this.position = new Position(8, 4);
		}
		
		this.type = type;
		this.number = 1;
		this.moved = false;
	}
	
	/**
	 * Constructor for Queen with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this queen
	 */
	public CPQueen(String type, Position position) {
		this.position = position;
		this.type = type;
		this.moved = true;
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, -1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 0, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 0, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 1, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, -1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, -1, 1);
	}

}

/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPQueen extends ChessPiece {

	/**
	 * Constructor for default Queen
	 * @param type
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
	 * @param type
	 * @param position
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

/**
 * This is the class for bishop
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:13
 * @version 1.0
 */


public class CPBishop extends ChessPiece {

	/**
	 * Constructor for default Bishop
	 * 
	 * @param type		the color or null
	 * @param number	the numbering of bishop
	 */
	public CPBishop(String type, int number) {
		if(type == "white") {
			switch(number){
			case 1: this.position = new Position(1, 3); break;
			case 2: this.position = new Position(1, 6); 
			}
		}
		else { // black
			switch(number){
			case 1: this.position = new Position(8, 3); break;
			case 2: this.position = new Position(8, 6); 
			}
		}
		
		this.number = number;
		this.type = type;
		this.moved = false;
	}
	
	/**
	 * Constructor for Bishop with specified position
	 * 
	 * @param type		the color or null
	 * @param position	the position of this bishop
	 * @param number	the numbering of bishop
	 */
	public CPBishop(String type, Position position, int number) {
		this.position = position;
		this.type = type;
		this.number = number;
		this.moved = true;
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 1, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, -1, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, -1, 1);
	}

}

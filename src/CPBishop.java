/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPBishop extends ChessPiece {

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
	}
	
	public CPBishop(String type, Position position, int number) {
		this.position = position;
		this.type = type;
		this.number = number;
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

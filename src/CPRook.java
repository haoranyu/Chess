/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPRook extends ChessPiece {

	public CPRook(String type, int number) {
		if(type == "white") {
			switch(number){
			case 1: this.position = new Position(1, 1); break;
			case 2: this.position = new Position(1, 8); 
			}
		}
		else { // black
			switch(number){
			case 1: this.position = new Position(8, 1); break;
			case 2: this.position = new Position(8, 8); 
			}
		}
		this.number = number;
		this.type = type;
	}
	
	public CPRook(String type, Position position, int number) {
		this.position = position;
		this.type = type;
		this.number = number;
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, -1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 1, 0);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 0, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 0, -1);
	}

}

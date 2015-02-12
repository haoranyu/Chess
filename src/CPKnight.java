/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPKnight extends ChessPiece {

	public CPKnight(String type, int number) {
		if(type == "white") {
			switch(number){
			case 1: this.position = new Position(1, 2); break;
			case 2: this.position = new Position(1, 7); 
			}
		}
		else { // black
			switch(number){
			case 1: this.position = new Position(8, 2); break;
			case 2: this.position = new Position(8, 7); 
			}
		}
		this.number = number;
		this.type = type;
	}
	
	public CPKnight(String type, Position position, int number) {
		this.position = position;
		this.type = type;
		this.number = number;
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, 1, 2);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, 1, -2);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, -1, 2);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, -1, -2);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, 2, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, 2, -1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, -2, 1);
		this.iterativeAddPossiblePosition(chessBoard, this.position, 1, -2, -1);
	}

}

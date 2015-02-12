/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPKing extends ChessPiece {

	public CPKing(String type) {
		if(type == "white") {
			this.position = new Position(1, 5);
		}
		else { // black
			this.position = new Position(8, 5);
		}
		
		this.type = type;
		this.number = 1;
	}
	
	public CPKing(String type, Position position) {
		this.position = position;
		this.type = type;
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

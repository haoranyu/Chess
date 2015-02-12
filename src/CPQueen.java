/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPQueen extends ChessPiece {

	public CPQueen(String type) {
		if(type == "white") {
			this.position = new Position(1, 4);
		}
		else { // black
			this.position = new Position(8, 4);
		}
		
		this.type = type;
		this.number = 1;
	}
	
	public CPQueen(String type, Position position) {
		this.position = position;
		this.type = type;
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

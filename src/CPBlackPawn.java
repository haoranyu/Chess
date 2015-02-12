/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPBlackPawn extends ChessPiece {

	
	
	public CPBlackPawn(int number) {
		this.position = new Position(7, number);
		this.number = number;
		this.type = "black";
	}
	
	public CPBlackPawn(Position position, int number) {
		this.position = position;
		this.type = "black";
		this.number = number;
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 0, -1);
	}

}

/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPWhitePawn extends ChessPiece {

	public CPWhitePawn(int number) {
		this.position = new Position(2, number);
		this.number = number;
		this.type = "white";
	}
	
	public CPWhitePawn(Position position, int number) {
		this.position = position;
		this.type = "white";
		this.number = number;
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.iterativeAddPossiblePosition(chessBoard, this.position, 7, 0, 1);
	}

}

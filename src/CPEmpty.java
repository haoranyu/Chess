/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class CPEmpty extends ChessPiece {

	public CPEmpty() {
		this.type = "null";
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
	}

}

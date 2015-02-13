/**
 * This is the class for no chess piece
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:17
 * @version 1.0
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

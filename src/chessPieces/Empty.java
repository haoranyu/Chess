package chessPieces;
import models.ChessBoard;
import models.Position;






/**
 * This is the class for no chess piece
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:17
 * @version 1.0
 */

public class Empty extends ChessPiece {

	public Empty() {
		this.setType("null");
		this.setName("null");
		this.moved = false;
		this.number = 0;
		this.setPosition(new Position());
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
	}

}

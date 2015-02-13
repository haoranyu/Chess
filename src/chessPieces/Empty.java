package chessPieces;
import models.ChessBoard;
import models.Position;


/**
 * This is the class for no chess piece (a special chess piece called Empty)
 * Any empty cell in the chess board will be viewed as empty chess piece.
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:19:17
 * @version 1.0
 */

public class Empty extends ChessPiece {

	public Empty() {
		this.type = "null";
		this.name = "null";
		this.moved = false;
		this.number = 0;
		this.position = new Position();
	}
	
	@Override
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
	}

}

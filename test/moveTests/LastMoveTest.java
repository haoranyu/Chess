package moveTests;
import static org.junit.Assert.*;
import models.ChessBoard;
import models.Position;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class LastMoveTest {

	ChessBoard chessBoard;
	Position[] testPosition;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chessBoard = new ChessBoard();
		testPosition = new Position[10];
		testPosition[0] = new Position(1, 2);
		testPosition[1] = new Position(7, 3);
	}

	@Test
	public void chessWhiteMove() {
		chessBoard.getChessPieceInPosition(testPosition[0]).move(this.chessBoard, testPosition[0].getUp(2).getRight(1));
		assertEquals("White move", "white", chessBoard.lastRecord().fromChessPiece.getType());
	}
	
	public void chessBlackMove() {
		chessBoard.getChessPieceInPosition(testPosition[1]).move(this.chessBoard, testPosition[1].getDown(2));
		assertEquals("Black move", "black", chessBoard.lastRecord().fromChessPiece.getType());
	}

}

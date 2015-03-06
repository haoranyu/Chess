package moveTests;
import static org.junit.Assert.*;
import modelCore.ChessBoard;
import modelCore.Position;

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
		chessBoard = new ChessBoard(false);
		testPosition = new Position[10];
		testPosition[0] = new Position(1, 2);
		testPosition[1] = new Position(7, 3);
	}

	@Test
	public void chessWhiteMove() {
		chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[0]), testPosition[0].getRelativePosition(1, 2));
		assertEquals("White move", "white", chessBoard.lastRecord().fromChessPiece.getType());
	}
	
//	public void chessBlackMove() {
//		chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[1]), testPosition[1].getRelativePosition(0, -2));
//		assertEquals("Black move", "black", chessBoard.lastRecord().fromChessPiece.getType());
//	}

}

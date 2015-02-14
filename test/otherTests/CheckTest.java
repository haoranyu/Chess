package otherTests;
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
public class CheckTest {

	ChessBoard chessBoard;
	Position[] testPosition;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chessBoard = new ChessBoard();
		testPosition = new Position[10];
		testPosition[0] = new Position(7, 4);
		testPosition[1] = new Position(2, 5);
		testPosition[2] = new Position(1, 6);
		testPosition[3] = new Position(5, 2);
		chessBoard.getChessPieceInPosition(testPosition[0]).move(this.chessBoard, testPosition[0].getDown(1));
		chessBoard.getChessPieceInPosition(testPosition[1]).move(this.chessBoard, testPosition[1].getUp(1));
	}

	@Test
	public void testNotCheck() {
		assertEquals("Check", false, chessBoard.getChessPieceInPosition(testPosition[2]).checkOtherKing(chessBoard));
	}
	
	@Test
	public void testCheck() {
		chessBoard.getChessPieceInPosition(testPosition[2]).move(this.chessBoard, testPosition[3]);
		assertEquals("Check", true, chessBoard.getChessPieceInPosition(testPosition[3]).checkOtherKing(chessBoard));
	}

}

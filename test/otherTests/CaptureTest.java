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
public class CaptureTest {

	ChessBoard chessBoard;
	Position[] testPosition;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chessBoard = new ChessBoard(false);
		testPosition = new Position[10];
		testPosition[0] = new Position(7, 4);
		testPosition[1] = new Position(2, 5);
		testPosition[2] = new Position(1, 6);
		testPosition[3] = new Position(5, 2);
		testPosition[4] = new Position(8, 5);
		chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[0]), testPosition[0].getRelativePosition(0, -1));
		chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[1]), testPosition[1].getRelativePosition(0, 1));
		chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[2]), testPosition[3]);
	}
	
	@Test
	public void testapture() {
		chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[3]), testPosition[4]);
		assertEquals("Original Empty", "null", chessBoard.getChessPieceInPosition(testPosition[3]).getType());
		assertEquals("King Replaced - type", "white", chessBoard.getChessPieceInPosition(testPosition[4]).getType());
		assertEquals("King Replaced - name", "bishop", chessBoard.getChessPieceInPosition(testPosition[4]).getName());
	}

}

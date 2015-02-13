package otherTests;
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
public class CaptureTest {

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
		testPosition[4] = new Position(8, 5);
		chessBoard.getChessPieceInPosition(testPosition[0]).move(this.chessBoard, testPosition[0].getDown(1));
		chessBoard.getChessPieceInPosition(testPosition[1]).move(this.chessBoard, testPosition[1].getUp(1));
		chessBoard.getChessPieceInPosition(testPosition[2]).move(this.chessBoard, testPosition[3]);
	}
	
	@Test
	public void testapture() {
		chessBoard.getChessPieceInPosition(testPosition[3]).move(this.chessBoard, testPosition[4]);
		assertEquals("Original Empty", "null", chessBoard.getChessPieceInPosition(testPosition[3]).getType());
		assertEquals("King Replaced - type", "white", chessBoard.getChessPieceInPosition(testPosition[4]).getType());
		assertEquals("King Replaced - name", "bishop", chessBoard.getChessPieceInPosition(testPosition[4]).getName());
	}

}

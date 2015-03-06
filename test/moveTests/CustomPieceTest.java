/**
 * 
 */
package moveTests;

import static org.junit.Assert.*;
import modelCore.ChessBoard;
import modelCore.Position;

import org.junit.Before;
import org.junit.Test;

/**
 * @author haoranyu
 *
 */
public class CustomPieceTest {

	ChessBoard chessBoard;
	Position[] testPosition;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chessBoard = new ChessBoard();
		testPosition = new Position[10];
		testPosition[0] = new Position(4, 3);
		testPosition[1] = new Position(3, 1);
	}

	@Test
	public void positionTest() {
		assertEquals("White", "white", chessBoard.getChessPieceInPosition(testPosition[0]).getType());
		assertEquals("White", "white", chessBoard.getChessPieceInPosition(testPosition[1]).getType());
	}
	
	@Test
	public void moveTest() {
		assertEquals("White", true, chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[0]), testPosition[0].getRelativePosition(1, 2)));
		assertEquals("White", false, chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[0]), testPosition[0].getRelativePosition(-2, -2)));
		assertEquals("White", true, chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[1]), testPosition[1].getRelativePosition(1, 2)));
		assertEquals("White", false, chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[1]), testPosition[1].getRelativePosition(-2, -1)));
	}

}

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
public class MoveToInvalidTest {

	ChessBoard chessBoard;
	Position[] testPosition;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chessBoard = new ChessBoard();
		testPosition = new Position[10];
		testPosition[0] = new Position(2, 1);
		testPosition[1] = new Position(2, 0);
	}

	@Test
	public void chessPieceTest() {
		assertEquals("Chess piece name", "pawn", chessBoard.getChessPieceInPosition(testPosition[0]).getName());
		assertEquals("Chess piece type", "white", chessBoard.getChessPieceInPosition(testPosition[0]).getType());
	}
	
	@Test
	public void invalidTest() {
		assertEquals("Invalid test", null, chessBoard.getChessPieceInPosition(testPosition[1]));
	}
	
	@Test
	public void moveToEmptyTest() {
		chessBoard.getChessPieceInPosition(testPosition[0]).move(this.chessBoard, testPosition[1]);
		
		assertEquals("Still chess piece name", "pawn", chessBoard.getChessPieceInPosition(testPosition[0]).getName());
		assertEquals("Still chess piece type", "white", chessBoard.getChessPieceInPosition(testPosition[0]).getType());
		assertEquals("Still invalid", null, chessBoard.getChessPieceInPosition(testPosition[1]));
	}

}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class MoveToEmptyTest {

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
		testPosition[1] = new Position(3, 1);
	}

	@Test
	public void chessPieceTest() {
		assertEquals("Chess piece name", "pawn", chessBoard.getChessPieceInPosition(testPosition[0]).name);
		assertEquals("Chess piece type", "white", chessBoard.getChessPieceInPosition(testPosition[0]).type);
	}
	
	@Test
	public void emptyTest() {
		assertEquals("Empty test", "null", chessBoard.getChessPieceInPosition(testPosition[1]).type);
	}
	
	@Test
	public void moveToEmptyTest() {
		chessBoard.getChessPieceInPosition(testPosition[0]).move(this.chessBoard, testPosition[1]);
		
		assertEquals("New Empty test", "null", chessBoard.getChessPieceInPosition(testPosition[0]).type);
		assertEquals("New Chess piece name", "pawn", chessBoard.getChessPieceInPosition(testPosition[1]).name);
		assertEquals("New Chess piece type", "white", chessBoard.getChessPieceInPosition(testPosition[1]).type);
	}

}

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
public class MoveToSelfOccupiedTest {

	ChessBoard chessBoard;
	Position[] testPosition;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chessBoard = new ChessBoard();
		testPosition = new Position[10];
		testPosition[0] = new Position(1, 1);
		testPosition[1] = new Position(1, 2);
	}

	@Test
	public void chessPieceTest1() {
		assertEquals("Chess piece 1 name", "rook", chessBoard.getChessPieceInPosition(testPosition[0]).getName());
		assertEquals("Chess piece 1 type", "white", chessBoard.getChessPieceInPosition(testPosition[0]).getType());
	}
	
	@Test
	public void chessPieceTest2() {
		assertEquals("Chess piece 2 name", "knight", chessBoard.getChessPieceInPosition(testPosition[1]).getName());
		assertEquals("Chess piece 2 type", "white", chessBoard.getChessPieceInPosition(testPosition[1]).getType());
	}
	
	@Test
	public void moveToEmptyTest() {
		chessBoard.move(chessBoard.getChessPieceInPosition(testPosition[0]), testPosition[1]);
		
		assertEquals("Still chess piece 1 name", "rook", chessBoard.getChessPieceInPosition(testPosition[0]).getName());
		assertEquals("Still chess piece 1 type", "white", chessBoard.getChessPieceInPosition(testPosition[0]).getType());
		assertEquals("Still chess piece 2 name", "knight", chessBoard.getChessPieceInPosition(testPosition[1]).getName());
		assertEquals("Still chess piece 2 type", "white", chessBoard.getChessPieceInPosition(testPosition[1]).getType());
	}

}

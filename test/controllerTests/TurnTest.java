/**
 * 
 */
package controllerTests;

import static org.junit.Assert.*;
import modelCore.Position;

import org.junit.Before;
import org.junit.Test;

import controller.Chess;

/**
 * @author haoranyu
 *
 */
public class TurnTest {
	Chess chess;
	Position testPosition;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chess = new Chess();
		testPosition = new Position(1, 2);
	}

	@Test
	public void initTurnTest() {
		assertEquals("White turn", "white", this.chess.chessBoard.getTurn());
	}
	
	@Test
	public void moveTurnTest() {
		this.chess.move(testPosition, testPosition.getRelativePosition(1, 2));
		assertEquals("Black turn", "black", this.chess.chessBoard.getTurn());
	}
	
	@Test
	public void undoTurnTest() {
		this.chess.move(testPosition, testPosition.getRelativePosition(1, 2));
		this.chess.revertMove();
		assertEquals("White turn", "white", this.chess.chessBoard.getTurn());
	}
}

/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class Chess {

	/**
	 * @param args not specified
	 */
	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		Position position = new Position(3, 1);
		System.out.println(chessBoard.getChessPieceInPosition(position).type);
	}
	
}

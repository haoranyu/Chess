/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class Chess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		Position position = new Position(7, 5);
		System.out.print(chessBoard.getChessPieceInPosition(position));
		System.out.print(chessBoard.getChessPieceInPosition(position).type);
	}
}

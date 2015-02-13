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
		Position position = new Position(8, 3);
		System.out.println(chessBoard.getChessPieceInPosition(position));
		chessBoard.getChessPieceInPosition(position).showPossibleNextPosition(chessBoard);
		chessBoard.getChessPieceInPosition(position).move(chessBoard, position.getDown(1));
		System.out.println(chessBoard.getChessPieceInPosition(position.getDown(1)));
		chessBoard.getChessPieceInPosition(position.getDown(1)).showPossibleNextPosition(chessBoard);
	}
	
}

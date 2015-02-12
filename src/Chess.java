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
		Position position = new Position(1, 5);
		chessBoard.getPosition(position).getPossibleNextPosition(chessBoard);
		chessBoard.getPosition(position).showPossibleNextPosition();
		chessBoard.getPosition(position).move(chessBoard, position.getLeft(1));
		System.out.print("-------------\n");
		chessBoard.getPosition(position.getLeft(1)).getPossibleNextPosition(chessBoard);
		chessBoard.getPosition(position.getLeft(1)).showPossibleNextPosition();
	}
}

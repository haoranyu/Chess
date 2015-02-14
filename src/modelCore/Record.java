package modelCore;
import modelChessPieces.ChessPiece;

/**
 * This is the class for record
 */

/**
 * 
 * @author haoranyu
 * @since  2015-02-13 01:19:51
 * @version 1.0
 * 
 */
public class Record {
	public Position 	fromPosition; /**< the starting position of movement */
	public Position 	toPosition; /**< the ending position of movement */
	public ChessPiece 	fromChessPiece; /**< the chess piece on starting position */
	public ChessPiece 	toChessPiece; /**< the chess piece on ending position */
	
	/**
	 * Constructor for Record
	 * 
	 * @param fromPosition		the starting position of movement
	 * @param fromChessPiece	the ending position of movement
	 * @param toPosition		the chess piece on starting position
	 * @param toChessPiece		the chess piece on ending position
	 */
	public Record(Position fromPosition, ChessPiece fromChessPiece, Position toPosition, ChessPiece toChessPiece) {
		this.fromPosition = fromPosition;
		this.fromChessPiece = fromChessPiece;
		this.toPosition = toPosition;
		this.toChessPiece = toChessPiece;
	}
}

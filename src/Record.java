/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class Record {
	Position 	fromPosition; // the starting position of movement
	Position 	toPosition;	// the ending position of movement
	ChessPiece 	fromChessPiece; // the chess piece on starting position
	ChessPiece 	toChessPiece; // the chess piece on ending position
	
	/**
	 * Constructor for Record
	 * @param fromPosition
	 * @param fromChessPiece
	 * @param toPosition
	 * @param toChessPiece
	 */
	public Record(Position fromPosition, ChessPiece fromChessPiece, Position toPosition, ChessPiece toChessPiece) {
		this.fromPosition = fromPosition;
		this.fromChessPiece = fromChessPiece;
		this.toPosition = toPosition;
		this.toChessPiece = toChessPiece;
	}
}

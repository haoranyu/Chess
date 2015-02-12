/**
 * 
 */

/**
 * @author haoranyu
 *
 */
public class Record {
	Position fromPosition;
	Position toPosition;
	ChessPiece fromChessPiece;
	ChessPiece toChessPiece;
	
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

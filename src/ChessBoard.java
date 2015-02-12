import java.util.Hashtable;


public class ChessBoard {
	Hashtable<Position, ChessPiece> cells;
	
	/**
	 * Constructor for a new chessBoard
	 */
	public ChessBoard() {
		this.cells = new Hashtable<Position, ChessPiece>();
		
		King whiteKing = new King("white");
		this.cells.put(whiteKing.position, whiteKing);
		
		King blackKing = new King("black");
		this.cells.put(blackKing.position, blackKing);
		
	}
	
	/**
	 * Get the chessPiece in the position
	 * @param position
	 * @return
	 */
	public ChessPiece getChessPieceInPosition(Position position) {
		return this.cells.get(position);
	}
	
	/**
	 * Set a chessPiece into the chessBoard
	 * @param position
	 * @param chessPiece
	 */
	public void setChessPieceInPosition(Position position, ChessPiece chessPiece) {
		this.cells.put(position, chessPiece);
	}
	
	/**
	 * Make the cell of position null
	 * @param position
	 */
	public void clearPosition(Position position) {
		this.cells.remove(position);
	}
	
	/**
	 * Use position on board to get the cell status
	 * @param position
	 * @return
	 */
	public Hashtable<Position, ChessPiece> getCellByPosition(Position position) {
		return this.cells;
	}
}

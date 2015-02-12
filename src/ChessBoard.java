import java.util.Hashtable;
import java.util.Stack;

public class ChessBoard {
	Hashtable<Position, ChessPiece> cells;
	Stack<Record>  records;
	String[] colors;
	
	/**
	 * Constructor for a new chessBoard with chess pieces defined
	 */
	public ChessBoard() {
		this.cells = new Hashtable<Position, ChessPiece>();
		this.records = new Stack<Record>();
		
		this.initilizeKings();
		this.initilizeQueens();
		this.initilizeRooks();
		this.initilizePawns();
		
		this.setEmpty();
	}
	
	public void initilizeKings() {
		CPKing whiteKing = new CPKing("white");
		this.cells.put(whiteKing.position, whiteKing);
		CPKing blackKing = new CPKing("black");
		this.cells.put(blackKing.position, blackKing);
	}
	public void initilizeQueens() {
		CPQueen whiteQueen = new CPQueen("white");
		this.cells.put(whiteQueen.position, whiteQueen);
		CPQueen blackQueen = new CPQueen("black");
		this.cells.put(blackQueen.position, blackQueen);
	}
	public void initilizeRooks() {
		for(int count = 1; count <= 2; count++) {
			CPRook whiteRook = new CPRook("white", count);
			this.cells.put(whiteRook.position, whiteRook);
			CPRook blackRook = new CPRook("black", count);
			this.cells.put(blackRook.position, blackRook);
		}
	}
	public void initilizePawns() {
		for(int count = 1; count <= 8; count++) {
			CPWhitePawn whitePawn = new CPWhitePawn(count);
			this.cells.put(whitePawn.position, whitePawn);
			CPBlackPawn blackPawn = new CPBlackPawn(count);
			this.cells.put(blackPawn.position, blackPawn);
		}
	}
	
	public void setEmpty() {
		for(int row = 1; row <= 8; row++) {
			for(int col = 1; col <= 8; col++) {
				Position position = new Position(row, col);
				if(this.getChessPieceInPosition(position) == null) {
					CPEmpty empty = new CPEmpty();
					this.cells.put(position, empty);
				}
			}
		}
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
		CPEmpty empty = new CPEmpty();
		this.cells.put(position, empty);
	}
	
}

import java.util.Hashtable;
import java.util.Stack;

public class ChessBoard {
	Hashtable<Position, ChessPiece> cells;	// store the chess piece in each cell by position
	Stack<Record>  	records;  // store the record of movement on chess board
	
	/**
	 * Constructor for a new chessBoard with chess pieces defined
	 */
	public ChessBoard() {
		this.cells = new Hashtable<Position, ChessPiece>();
		this.records = new Stack<Record>();
		
		this.initilizeKings();
		this.initilizeQueens();
		this.initilizeRooks();
		this.initilizeBishops();
		this.initilizeKnights();
		this.initilizePawns();
		
		this.setEmpty();
	}
	
	/**
	 * Initialize kings on chess board
	 */
	public void initilizeKings() {
		CPKing whiteKing = new CPKing("white");
		this.cells.put(whiteKing.position, whiteKing);
		CPKing blackKing = new CPKing("black");
		this.cells.put(blackKing.position, blackKing);
	}
	
	/**
	 * Initialize queens on chess board
	 */
	public void initilizeQueens() {
		CPQueen whiteQueen = new CPQueen("white");
		this.cells.put(whiteQueen.position, whiteQueen);
		CPQueen blackQueen = new CPQueen("black");
		this.cells.put(blackQueen.position, blackQueen);
	}
	
	/**
	 * Initialize rooks on chess board
	 */
	public void initilizeRooks() {
		for(int count = 1; count <= 2; count++) {
			CPRook whiteRook = new CPRook("white", count);
			this.cells.put(whiteRook.position, whiteRook);
			CPRook blackRook = new CPRook("black", count);
			this.cells.put(blackRook.position, blackRook);
		}
	}
	
	/**
	 * Initialize bishops on chess board
	 */
	public void initilizeBishops() {
		for(int count = 1; count <= 2; count++) {
			CPBishop whiteBishop = new CPBishop("white", count);
			this.cells.put(whiteBishop.position, whiteBishop);
			CPBishop blackBishop = new CPBishop("black", count);
			this.cells.put(blackBishop.position, blackBishop);
		}
	}
	
	/**
	 * Initialize knights on chess board
	 */
	public void initilizeKnights() {
		for(int count = 1; count <= 2; count++) {
			CPKnight whiteKnight = new CPKnight("white", count);
			this.cells.put(whiteKnight.position, whiteKnight);
			CPKnight blackKnight = new CPKnight("black", count);
			this.cells.put(blackKnight.position, blackKnight);
		}
	}
	
	/**
	 * Initialize pawns on chess board
	 */
	public void initilizePawns() {
		for(int count = 1; count <= 8; count++) {
			CPPawn whitePawn = new CPPawn("white", count);
			this.cells.put(whitePawn.position, whitePawn);
			CPPawn blackPawn = new CPPawn("black", count);
			this.cells.put(blackPawn.position, blackPawn);
		}
	}
	
	/**
	 * Set a cell in the chess board as empty
	 */
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

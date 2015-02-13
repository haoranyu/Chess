/**
 * This is the class for chess board
 */

/**
 * @author haoranyu
 * @since  2015-02-13 01:16:02
 * @version 1.0
 */

import java.util.Hashtable;
import java.util.Stack;

public class ChessBoard {
	Hashtable<Position, ChessPiece> cells;	// store the chess piece in each cell by position
	Stack<Record>  	records;  // store the record of movement on chess board
	String win;  // who win
	int	row; // how many rows for the chessboard
	int col; // how many columns for the chessboard
	
	/**
	 * Constructor for a new chessBoard with chess pieces defined
	 */
	public ChessBoard() {
		this.cells = new Hashtable<Position, ChessPiece>();
		this.records = new Stack<Record>();
		this.win = "nobody";
		this.row = 8;
		this.col = 8;
		
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
	private void initilizeKings() {
		CPKing whiteKing = new CPKing("white");
		this.cells.put(whiteKing.position, whiteKing);
		CPKing blackKing = new CPKing("black");
		this.cells.put(blackKing.position, blackKing);
	}
	
	/**
	 * Initialize queens on chess board
	 */
	private void initilizeQueens() {
		CPQueen whiteQueen = new CPQueen("white");
		this.cells.put(whiteQueen.position, whiteQueen);
		CPQueen blackQueen = new CPQueen("black");
		this.cells.put(blackQueen.position, blackQueen);
	}
	
	/**
	 * Initialize rooks on chess board
	 */
	private void initilizeRooks() {
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
	private void initilizeBishops() {
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
	private void initilizeKnights() {
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
	private void initilizePawns() {
		for(int count = 1; count <= 8; count++) {
			CPPawn whitePawn = new CPPawn("white", count);
			this.cells.put(whitePawn.position, whitePawn);
			CPPawn blackPawn = new CPPawn("black", count);
			this.cells.put(blackPawn.position, blackPawn);
		}
	}
	
	/**
	 * Set all other cells with no chess piece as empty
	 */
	private void setEmpty() {
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
	 * 
	 * @param position		The position we see into
	 * @return chessPiece	Return the chess piece in this position
	 */
	public ChessPiece getChessPieceInPosition(Position position) {
		return this.cells.get(position);
	}
	
	/**
	 * Set a chessPiece into the chessBoard
	 * 
	 * @param position		The position we see into
	 * @param chessPiece	The chess piece we want to put into the position
	 */
	public void setChessPieceInPosition(Position position, ChessPiece chessPiece) {
		this.cells.put(position, chessPiece);
	}
	
	/**
	 * Make the cell of position null
	 * 
	 * @param position	The position we want to clear
	 */
	public void clearPosition(Position position) {
		CPEmpty empty = new CPEmpty();
		this.cells.put(position, empty);
	}
	
	/**
	 * Check if the position is occupied by any chess piece
	 * 
	 * @param position	The position we see into
	 * @return			True if any chess piece in this position
	 */
	public boolean occupied(Position position) {
		if(!this.getChessPieceInPosition(position).type.equals("null")){
			return true;
		}
		else {
			return false;
		}
	}
	
}

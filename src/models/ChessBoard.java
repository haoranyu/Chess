package models;

/**
 * @author haoranyu
 * @since  2015-02-13 01:16:02
 * @version 1.0
 */

import java.util.Hashtable;
import java.util.Stack;

import chessPieces.CPBishop;
import chessPieces.CPEmpty;
import chessPieces.CPKing;
import chessPieces.CPKnight;
import chessPieces.CPPawn;
import chessPieces.CPQueen;
import chessPieces.CPRook;
import chessPieces.ChessPiece;

public class ChessBoard {
	Hashtable<Position, ChessPiece> cells;	// store the chess piece in each cell by position
	private Stack<Record>  	records;  // store the record of movement on chess board
	private String win;  // who win
	int	row; // how many rows for the chess board
	int col; // how many columns for the chess board
	
	/**
	 * Constructor for a new chessBoard with chess pieces defined
	 */
	public ChessBoard() {
		this.cells = new Hashtable<Position, ChessPiece>();
		this.records = new Stack<Record>();
		this.setWin(null);
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
		this.cells.put(whiteKing.getPosition(), whiteKing);
		CPKing blackKing = new CPKing("black");
		this.cells.put(blackKing.getPosition(), blackKing);
	}
	
	/**
	 * Initialize queens on chess board
	 */
	private void initilizeQueens() {
		CPQueen whiteQueen = new CPQueen("white");
		this.cells.put(whiteQueen.getPosition(), whiteQueen);
		CPQueen blackQueen = new CPQueen("black");
		this.cells.put(blackQueen.getPosition(), blackQueen);
	}
	
	/**
	 * Initialize rooks on chess board
	 */
	private void initilizeRooks() {
		for(int count = 1; count <= 2; count++) {
			CPRook whiteRook = new CPRook("white", count);
			this.cells.put(whiteRook.getPosition(), whiteRook);
			CPRook blackRook = new CPRook("black", count);
			this.cells.put(blackRook.getPosition(), blackRook);
		}
	}
	
	/**
	 * Initialize bishops on chess board
	 */
	private void initilizeBishops() {
		for(int count = 1; count <= 2; count++) {
			CPBishop whiteBishop = new CPBishop("white", count);
			this.cells.put(whiteBishop.getPosition(), whiteBishop);
			CPBishop blackBishop = new CPBishop("black", count);
			this.cells.put(blackBishop.getPosition(), blackBishop);
		}
	}
	
	/**
	 * Initialize knights on chess board
	 */
	private void initilizeKnights() {
		for(int count = 1; count <= 2; count++) {
			CPKnight whiteKnight = new CPKnight("white", count);
			this.cells.put(whiteKnight.getPosition(), whiteKnight);
			CPKnight blackKnight = new CPKnight("black", count);
			this.cells.put(blackKnight.getPosition(), blackKnight);
		}
	}
	
	/**
	 * Initialize pawns on chess board
	 */
	private void initilizePawns() {
		for(int count = 1; count <= 8; count++) {
			CPPawn whitePawn = new CPPawn("white", count);
			this.cells.put(whitePawn.getPosition(), whitePawn);
			CPPawn blackPawn = new CPPawn("black", count);
			this.cells.put(blackPawn.getPosition(), blackPawn);
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
	 * @return chessPiece	Return the chess piece in this position | Null if not valid
	 */
	public ChessPiece getChessPieceInPosition(Position position) {
		if(position.valid(this)){
			return this.cells.get(position);
		}
		return null;
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
		if(!this.getChessPieceInPosition(position).getType().equals("null")){
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * A function for adding a new record
	 * @param fromPosition
	 * @param fromChessPiece
	 * @param toPosition
	 * @param toChessPiece
	 */
	public void addRecord(Position fromPosition, ChessPiece fromChessPiece, Position toPosition, ChessPiece toChessPiece) {
		Record newRecord = new Record(fromPosition, fromChessPiece, toPosition, toChessPiece);
		this.records.push(newRecord);
	}
	
	
	public Record lastRecord() {
		return this.records.pop();
	}
	
	/**
	 * @return the win
	 */
	public String getWin() {
		return win;
	}

	/**
	 * @param win the win to set
	 */
	public void setWin(String win) {
		this.win = win;
	}
	
}

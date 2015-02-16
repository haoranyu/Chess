package modelCore;
/**
 * Note:
 * This is the class for chess board. You may notice that there is a function called setEmpty.
 * It will set all cells without normal pieces as a special chess piece called Empty.
 */

import java.util.Hashtable;
import java.util.Stack;

import modelChessPieces.Bishop;
import modelChessPieces.ChessPiece;
import modelChessPieces.Empty;
import modelChessPieces.King;
import modelChessPieces.Knight;
import modelChessPieces.Pawn;
import modelChessPieces.Queen;
import modelChessPieces.Rook;

/**
 * @author haoranyu
 * @since  2015-02-13 18:02:29
 * @version 1.0
 */
public class ChessBoard {
	Hashtable<Position, ChessPiece> cells;	/**< store the chess piece in each cell by position */
	private Stack<Record>  	records;  /**< store the record of movement on chess board */
	private String win;  /**< who win */
	public int	row; /**< how many rows for the chess board */
	public int col; /**< how many columns for the chess board */
	
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
		King whiteKing = new King("white");
		this.cells.put(whiteKing.getPosition(), whiteKing);
		King blackKing = new King("black");
		this.cells.put(blackKing.getPosition(), blackKing);
	}
	
	/**
	 * Initialize queens on chess board
	 */
	private void initilizeQueens() {
		Queen whiteQueen = new Queen("white");
		this.cells.put(whiteQueen.getPosition(), whiteQueen);
		Queen blackQueen = new Queen("black");
		this.cells.put(blackQueen.getPosition(), blackQueen);
	}
	
	/**
	 * Initialize rooks on chess board
	 */
	private void initilizeRooks() {
		for(int count = 1; count <= 2; count++) {
			Rook whiteRook = new Rook("white", count);
			this.cells.put(whiteRook.getPosition(), whiteRook);
			Rook blackRook = new Rook("black", count);
			this.cells.put(blackRook.getPosition(), blackRook);
		}
	}
	
	/**
	 * Initialize bishops on chess board
	 */
	private void initilizeBishops() {
		for(int count = 1; count <= 2; count++) {
			Bishop whiteBishop = new Bishop("white", count);
			this.cells.put(whiteBishop.getPosition(), whiteBishop);
			Bishop blackBishop = new Bishop("black", count);
			this.cells.put(blackBishop.getPosition(), blackBishop);
		}
	}
	
	/**
	 * Initialize knights on chess board
	 */
	private void initilizeKnights() {
		for(int count = 1; count <= 2; count++) {
			Knight whiteKnight = new Knight("white", count);
			this.cells.put(whiteKnight.getPosition(), whiteKnight);
			Knight blackKnight = new Knight("black", count);
			this.cells.put(blackKnight.getPosition(), blackKnight);
		}
	}
	
	/**
	 * Initialize pawns on chess board
	 */
	private void initilizePawns() {
		for(int count = 1; count <= 8; count++) {
			Pawn whitePawn = new Pawn("white", count);
			this.cells.put(whitePawn.getPosition(), whitePawn);
			Pawn blackPawn = new Pawn("black", count);
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
					Empty empty = new Empty();
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
		Empty empty = new Empty();
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
	 * The move function for a chessPiece to move
	 * 
	 * @param chessBoard	The object of chess board
	 * @param newPosition	The position we are moving to
	 * @return				Return true if it is possible
	 */
	public boolean move(ChessPiece chessPiece, Position newPosition) {
		chessPiece.getpossibleNextPositions(this);
		if(chessPiece.possibleNextPositions.contains(newPosition)){
			// TODO add the original dead piece to the stack
			
			// Mark this chess piece as moved
			if(chessPiece.isMoved() == false) {
				chessPiece.setMoved(true);
			}

			if(this.getChessPieceInPosition(newPosition).getName().equals("king") &&
				!this.getChessPieceInPosition(newPosition).getType().equals(chessPiece.getType())) {
				this.setWin(chessPiece.getType());
				System.out.print("WARNING: "+chessPiece.getType()+" win!\n");
			}

			// Add a record for this movement
			this.addRecord(chessPiece.getPosition(), this.getChessPieceInPosition(chessPiece.getPosition()), 
					newPosition, this.getChessPieceInPosition(newPosition));
			
			
			this.setChessPieceInPosition(newPosition, chessPiece);
			this.clearPosition(chessPiece.getPosition());
			
			chessPiece.setPosition(newPosition);
			
			if(chessPiece.checkOtherKing(this)) {
				System.out.print("WARNING: Other's king get checked\n");
			}
			
			return true;
		}
		else{
			// will be handled by controller. Now just print error out
			System.out.print("WARNING: You cannot move to ");
			newPosition.show();
			System.out.print("\n");
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
	
	/**
	 * @return the last pushed in record
	 */
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

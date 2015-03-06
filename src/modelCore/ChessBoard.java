package modelCore;
/**
 * Note:
 * This is the class for chess board. You may notice that there is a function called setEmpty.
 * It will set all cells without normal pieces as a special chess piece called Empty.
 */

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayList;

import modelChessPieces.Bishop;
import modelChessPieces.ChessPiece;
import modelChessPieces.Empress;
import modelChessPieces.Empty;
import modelChessPieces.King;
import modelChessPieces.Knight;
import modelChessPieces.Pawn;
import modelChessPieces.Princess;
import modelChessPieces.Queen;
import modelChessPieces.Rook;

/**
 * @author haoranyu
 * @since  2015-02-16 03:56:14
 * @version 1.1
 */
public class ChessBoard {
	Hashtable<Position, ChessPiece> cells;	/**< store the chess piece in each cell by position */
	private Stack<Record>  	records;  /**< store the record of movement on chess board */
	private String win;  /**< who win */
	private String turn;
	public int	row; /**< how many rows for the chess board */
	public int col; /**< how many columns for the chess board */
	
	public King whiteKing; /**< since king is unique we set it as a member of ChessBoard which is also easier to access */
	public King blackKing; /**< since king is unique we set it as a member of ChessBoard which is also easier to access */
	
	/**
	 * Constructor for a new chessBoard with chess pieces defined
	 */
	public ChessBoard() {
		this.cells = new Hashtable<Position, ChessPiece>();
		this.records = new Stack<Record>();
		this.win = null;
		this.row = 8;
		this.col = 8;
		this.turn = "white";
		
		this.initilizeKings();
		this.initilizeQueens();
		this.initilizeRooks();
		this.initilizeBishops();
		this.initilizeKnights();
		this.initilizePawns();
		this.initilizeEmpress();
		this.initilizePrincess();
		
		this.setEmpty();
	}
	
	/**
	 * Copy Constructor
	 */
	public ChessBoard(ChessBoard chessBoard) {
		this.cells = chessBoard.cells;
		this.records = chessBoard.records;
		this.win = chessBoard.getWin();
		this.row = chessBoard.row;
		this.col = chessBoard.col;
		this.turn = "white";
		
		this.whiteKing = new King(chessBoard.whiteKing);
		this.blackKing = new King(chessBoard.blackKing);
	}
	
	/**
	 * Initialize kings on chess board
	 */
	private void initilizeKings() {
		whiteKing = new King("white");
		this.cells.put(whiteKing.getPosition(), whiteKing);
		blackKing = new King("black");
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
	 * Initialize expresses on chess board
	 */
	private void initilizeEmpress() {
		for(int count = 1; count <= 2; count++) {
			Empress whiteEmpress = new Empress("white", count);
			this.cells.put(whiteEmpress.getPosition(), whiteEmpress);
			Empress blackEmpress = new Empress("black", count);
			this.cells.put(blackEmpress.getPosition(), blackEmpress);
		}
	}
	
	/**
	 * Initialize princesses on chess board
	 */
	private void initilizePrincess() {
		for(int count = 1; count <= 2; count++) {
			Princess whitePrincess = new Princess("white", count);
			this.cells.put(whitePrincess.getPosition(), whitePrincess);
			Princess blackPrincess = new Princess("black", count);
			this.cells.put(blackPrincess.getPosition(), blackPrincess);
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
	 * @param chessPiece	The chessPiece to move
	 * @param newPosition	The position we are moving to
	 * @return				Return true if it is possible
	 */
	
	public boolean move(ChessPiece chessPiece, Position newPosition) {
		chessPiece.getPossibleNextPositions(this);
		
		// chessPiece.showpossibleNextPositions(this);
		
		
		if(chessPiece.possibleNextPositions.contains(newPosition)){
			
			// Mark this chess piece as moved
			if(chessPiece.isMoved() == false) {
				chessPiece.setMoved(true);
			}

			// Add a record for this movement
			this.addRecord(chessPiece.getPosition(), this.getChessPieceInPosition(chessPiece.getPosition()), 
					newPosition, this.getChessPieceInPosition(newPosition));
			
			this.setChessPieceInPosition(newPosition, chessPiece);
			this.clearPosition(chessPiece.getPosition());
			
			chessPiece.setPosition(newPosition);
			
			if(this.checkOtherKing(chessPiece)) {
				this.win = chessPiece.getType();
			}
			
			if(this.selfChecked(chessPiece)) {
				this.revertMove();
				System.out.print("WARNING: You cannot move to ");
				newPosition.show();
				System.out.print(". It will cause chassmate on your own king\n");
				return false;
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
	 * Judge whether 
	 * @param chessPiece
	 * @return
	 */
	public boolean selfChecked(ChessPiece chessPiece) {
		if(chessPiece.getType().equals("white")) {
			return isKingChecked(this.whiteKing);
		}
		else { // black
			return isKingChecked(this.blackKing);
		}
	}
		
	/**
	 * See whether the chess piece is now checking the other king and 
	 * should win the game
	 * 
	 * @param chessPiece	the chessPiece it is now moving
	 * @return	True if there king of others is under check-mate
	 */
	public boolean checkOtherKing(ChessPiece chessPiece) {
		chessPiece.getPossibleNextPositions(this);
		
		Iterator<Position> nextPositionItr = chessPiece.possibleNextPositions.iterator();
		while (nextPositionItr.hasNext()) {
			Position aimPosition = nextPositionItr.next();
			if(this.getChessPieceInPosition(aimPosition).getName().equals("king") &&
				!this.getChessPieceInPosition(aimPosition).getType().equals(chessPiece.getType())) {
				if(!isKingChecked(this.getChessPieceInPosition(aimPosition))) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check whether a king is under check
	 * @param king
	 * @return 
	 */
	public boolean isKingChecked(ChessPiece king) {
		king.getPossibleNextPositions(this);
		// add the original position which is for staying
		king.possibleNextPositions.add(king.getPosition());
		for(Position possibleKingNextPositions : king.possibleNextPositions) {
			if(!allPossiblePositionsOf(king.getEnemyType()).contains(possibleKingNextPositions)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Revert the last move
	 */
	public boolean revertMove(){
		if(this.records.isEmpty()) {
			return false;
		}
		else {
			Record lastRecord = this.records.pop();
			lastRecord.fromChessPiece.setPosition(lastRecord.fromPosition);
			this.setChessPieceInPosition(lastRecord.fromPosition, lastRecord.fromChessPiece);
			
			lastRecord.toChessPiece.setPosition(lastRecord.fromPosition);
			this.setChessPieceInPosition(lastRecord.toPosition, lastRecord.toChessPiece);
			this.changeTurn();
			return true;
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
	 * Find all possible positions for the chess pieces of player of COLOR to move
	 * @param color the player color 
	 * @return all possible positions for the chess pieces of player of COLOR to move
	 */
	public ArrayList<Position> allPossiblePositionsOf(String color) {
		ArrayList<Position> possiblePositions = new ArrayList<>(); 
		for(int row = 1; row <= this.row; row++) {
			for(int col = 1; col <= this.row; col++){
				Position position = new Position(row, col);
				if(this.getChessPieceInPosition(position).getType().equals(color)) {
					this.getChessPieceInPosition(position).getPossibleNextPositions(this);
					for(Position possiblePosition : this.getChessPieceInPosition(position).possibleNextPositions) {
						if(!possiblePositions.contains(possiblePosition)) {
							possiblePositions.add(possiblePosition);
						}
					}
				}
			}
		}
		return possiblePositions;
	}
	
	/**
	 * @return the last pushed in record
	 */
	public Record lastRecord() {
		return this.records.peek();
	}
	
	/**
	 * @return the win
	 */
	public String getWin() {
		return win;
	}
	
	public String getTurn() {
		return turn;
	}
	
	public void changeTurn() {
		if(this.turn.equals("white")) {
			this.turn = "black";
		}
		else {
			this.turn = "white";
		}
	}
}

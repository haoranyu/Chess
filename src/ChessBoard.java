import java.util.Map;
import java.util.HashMap;

public class ChessBoard {
	Map<Position, ChessPiece> cells;
	
	public ChessBoard() {
		this.cells = new HashMap();
		
		King whiteKing = new King("white");
		this.cells.put(whiteKing.position, whiteKing);
		King blackKing = new King("black");
		this.cells.put(blackKing.position, blackKing);
	}
	
	public ChessPiece getPosition(Position position) {
		
	}
}

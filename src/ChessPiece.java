import java.util.ArrayList;

/**
 * @author haoranyu
 *
 */
public abstract class ChessPiece {
	String color;
	Position position;
	ArrayList<Position> possibleNextPosition = new ArrayList<>();
	
	public ChessPiece(){
		
	}
	
	public void move(Position newPosition) {
		
	}
	
	public abstract void getPossibleNextPosition();
	
}

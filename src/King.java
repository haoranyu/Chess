
public class King extends ChessPiece {

	public King(String color) {
		if(color == "white") {
			this.position = new Position(1, 5);
		}
		else {
			this.position = new Position(8, 5);
		}
		
		this.color = color;
	}
	
	public King(String color, Position position) {
		this.position = position;
		this.color = color;
	}
	
	@Override
	public void getPossibleNextPosition() {
		// TODO Auto-generated method stub
		
	}

}


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
	public void getPossibleNextPosition(ChessBoard chessBoard) {
		// remove all before computing new possible next position
		this.possibleNextPosition.clear();
		
		this.addIfNotSelfOccupied(chessBoard, this.position.getLeft(1));
		this.addIfNotSelfOccupied(chessBoard, this.position.getRight(1));
		this.addIfNotSelfOccupied(chessBoard, this.position.getUp(1));
		this.addIfNotSelfOccupied(chessBoard, this.position.getDown(1));
		
		this.addIfNotSelfOccupied(chessBoard, this.position.getLeft(1).getUp(1));
		this.addIfNotSelfOccupied(chessBoard, this.position.getRight(1).getUp(1));
		this.addIfNotSelfOccupied(chessBoard, this.position.getLeft(1).getDown(1));
		this.addIfNotSelfOccupied(chessBoard, this.position.getRight(1).getDown(1));
	}

}

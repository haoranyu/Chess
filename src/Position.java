
public class Position {
	int row;
	int col;
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public void printPosition() {
		System.out.print("(" + row + "," + col + ")");
	}
}

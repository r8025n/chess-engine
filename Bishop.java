
public class Bishop extends Piece {

	private String whiteCode = "\u2657";
	private String blackCode = "\u265D";

	static int[][] possibleMoves={
		{1, 1}, {-1, -1},
		{1, -1}, {-1, 1}
	};
	
	Bishop(String c) {

		this.pieceColor = c;
	}
	
	String getCode() {

		if(pieceColor.equals("black")) {
			return blackCode;
		}
		else {
			return whiteCode;
		}
	}
}

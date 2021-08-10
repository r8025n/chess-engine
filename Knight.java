
public class Knight extends Piece {

	private String whiteCode = "\u2658";
	private String blackCode = "\u265E";
	private String pieceColor;
	
	static int[][] possibleMoves = {
		{2, 1}, {2, -1}, {-2, 1}, {-2, -1},
		{1, 2}, {1, -2}, {-1, 2}, {-1, -2}
	};
	
	Knight(String c) {
		this.pieceColor = c;
	}
	
	String getCode() {
		if(pieceColor.equals("black")){
			return blackCode;
		}
		else {
			return whiteCode;
		}
	}

}

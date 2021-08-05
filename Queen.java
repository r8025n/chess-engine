
public class Queen extends Piece {
	private String whiteCode="\u2655";
	private String blackCode="\u265B";
	private String pieceColor;
	
	static int[][] possibleMoves = {
		{0, 1}, {0, -1},
		{1, 0}, {-1, 0}
	};

	Queen(String c){
		this.pieceColor=c;
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

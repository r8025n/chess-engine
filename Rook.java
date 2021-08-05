
public class Rook extends Piece {
	private String whiteCode="\u2656";
	private String blackCode="\u265C";
	private String pieceColor;
	
	static int[][] possibleMoves = {{0, 1}, {0, -1},
		{1, 0}, {-1, 0}};

	Rook(String c){
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

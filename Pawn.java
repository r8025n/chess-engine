
public class Pawn extends Piece {
	private String whiteCode="\u2659";
	private String blackCode="\u265F";
	private String pieceColor;
	
	static int[][] possibleMoves = {{1, 0}};
		
	
	Pawn(String c){
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

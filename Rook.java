
public class Rook extends Piece {
	private String whiteCode="\u2656";
	private String blackCode="\u265C";
	private String pieceColor;
	
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

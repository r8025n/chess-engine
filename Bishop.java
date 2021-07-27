
public class Bishop extends Piece {
	private String whiteCode="\u2657";
	private String blackCode="\u265D";
	private String pieceColor;
	
	Bishop(String c){
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

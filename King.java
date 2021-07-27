public class King extends Piece{
	private String whiteCode="\u2654";
	private String blackCode="\u265A";
	//private String pieceColor;
	
	King(String color){
		this.pieceColor=color;
		//System.out.println(this.pieceColor);
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

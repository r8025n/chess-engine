import java.util.*;

public class Pawn extends Piece {
	
	private String whiteCode="\u2659";
	private String blackCode="\u265F";
	
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

	static ArrayList<IntPair> possibleMoves(int x,int y) {
		ArrayList<IntPair> pawnMoves = new ArrayList<>();
		pawnMoves.add(new IntPair(x + 1, y));
		
		return pawnMoves;
	}

}

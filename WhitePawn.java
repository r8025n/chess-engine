import java.util.*;

public class WhitePawn extends Piece {

	private String whiteCode="\u2659";
	//private String blackCode="\u265F";
		
	String getCode() {
		return whiteCode;
	}

	static ArrayList<IntPair> possibleMoves(int x,int y) {
		ArrayList<IntPair> whitePawnMoves = new ArrayList<>();
		whitePawnMoves.add(new IntPair(x - 1, y));
		
		return whitePawnMoves;
	}

}

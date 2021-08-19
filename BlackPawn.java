import java.util.*;

public class BlackPawn extends Piece {
	
	//private String whiteCode="\u2659";
	private String blackCode="\u265F";
		
	String getCode() {
		return blackCode;
	}

	static ArrayList<IntPair> possibleMoves(int x,int y) {
		ArrayList<IntPair> blackPawnMoves = new ArrayList<>();
		blackPawnMoves.add(new IntPair(x + 1, y));
		
		return blackPawnMoves;
	}

}

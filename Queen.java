import java.util.*;

public class Queen extends Piece {
	private String whiteCode="\u2655";
	private String blackCode="\u265B";
	private String pieceColor;

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

	static int[] xx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] yy = {1, -1, 0, 1, -1, 0, -1, 1};

	static ArrayList<IntPair> possibleMoves(int x,int y) {
		ArrayList<IntPair> kingMoves = new ArrayList<>();

		for(int i = 0; i < 8; i++){
			kingMoves.add(new IntPair(x + xx[i], y + yy[i]));
		}

		return kingMoves;
	}

}

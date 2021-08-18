import java.util.*;

public class Rook extends Piece {
	private String whiteCode="\u2656";
	private String blackCode="\u265C";
	private String pieceColor;
	
	// static int[][] possibleMoves = {{0, 1}, {0, -1},
	// 	{1, 0}, {-1, 0}};

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

	static int[] xx = {0, 1, 2, 3, 4, 5, 6, 7};
	static int[] yy = {0, 1, 2, 3, 4, 5, 6, 7};

	static ArrayList<IntPair> possibleMoves(int x,int y) {
		ArrayList<IntPair> rookMoves = new ArrayList<>();

		for(int i = 0; i < 8 && i != x; i++){
			rookMoves.add(new IntPair(i, y));

		}

		for(int i = 0; i < 8 && i != y; i++){
			rookMoves.add(new IntPair(x, i));
		}

		return rookMoves;
	}

}

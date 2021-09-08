import java.util.*;

public class EmptyPiece extends Piece {
	
	static int[][] possibleMoves={};

	@Override
	String getCode() {
		
		// TODO Auto-generated method stub
		String emptyString="";
		return emptyString;
	}

	static int[] xx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] yy = {1, -1, 0, 1, -1, 0, -1, 1};

	static ArrayList<IntPair> possibleMoves(int x, int y) {
		ArrayList<IntPair> emptyMoves = new ArrayList<>();

		return emptyMoves;
	}

}

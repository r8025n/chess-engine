import java.util.*;

public class Knight extends Piece {

	private String whiteCode = "\u2658";
	private String blackCode = "\u265E";
	private String pieceColor;
	
	Knight(String c) {
		this.pieceColor = c;
	}
	
	String getCode() {
		if(pieceColor.equals("black")){
			return blackCode;
		}
		else {
			return whiteCode;
		}
	}

	static int[] xx = {2, 2, -2, -2, 1, 1, -1, -1};
	static int[] yy = {1, -1, 1, -1, 2, -2, 2, -2};

	static ArrayList<IntPair> possibleMoves(int x, int y) {
		ArrayList<IntPair> knightMoves = new ArrayList<>();

		for(int i = 0; i < 8; i++) {
			if(Spot.isMoveLegal(x + xx[i], y + yy[i]) && Board.boardArray[x + xx[i]][y + yy[i]] == " ") {
				knightMoves.add(new IntPair(x + xx[i], y + yy[i]));
				System.out.println((x + xx[i]) + " " + (y + yy[i]));
			}
		}

		return knightMoves;
	}

}

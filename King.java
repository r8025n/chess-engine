import java.util.*;

public class King extends Piece{
	
	private String whiteCode = "\u2654";
	private String blackCode = "\u265A";
	private String pieceColor;

	static int[] xx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] yy = {1, -1, 0, 1, -1, 0, -1, 1};


	static ArrayList<IntPair> possibleMoves(int x, int y) {
		ArrayList<IntPair> kingMoves = new ArrayList<>();

		for(int i = 0; i < 8; i++){
			if(Spot.isMoveLegal(x + xx[i], y + yy[i]) && Board.boardArray[x + xx[i]][y + yy[i]] == " ")
				kingMoves.add(new IntPair(x + xx[i], y + yy[i]));
		}

		return kingMoves;
	}
	
	King(String color) {

		this.pieceColor = color;
		//System.out.println(this.pieceColor);
	}
	
	String getCode() {
		
		if(pieceColor.equals("black")) {
			return blackCode;
		}
		else {
			return whiteCode;
		}
	}
}

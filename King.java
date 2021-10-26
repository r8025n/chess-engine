import java.util.*;

public class King extends Piece{
	
	private String whiteCode = "\u2654";
	private String blackCode = "\u265A";
	private String pieceColor;

	static int[] xx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] yy = {1, -1, 0, 1, -1, 0, -1, 1};


	String possibleMoves(int x, int y) {
		String kingMoves = "";
		String temp = "";
		
		for(int i = 0; i < 8; i++){
			if(isMoveLegal(x, y, xx[i], yy[i])) {
				// kingMoves.add(new IntPair(x + xx[i], y + yy[i]));
				temp = "" + x + y + (x + xx[i]) + (y + yy[i]) + Board.boardArray[x + xx[i]][y + yy[i]];
				kingMoves += temp;
			}
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

	String getColor() {
		return this.pieceColor;
	}
}

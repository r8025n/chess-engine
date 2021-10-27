import java.util.*;

public class King extends Piece{
	
	private String whiteCode = "\u2654";
	private String blackCode = "\u265A";
	private String pieceColor;
	private String name;

	static int[] xx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] yy = {1, -1, 0, 1, -1, 0, -1, 1};

	static int king_X_Comp = 0, king_Y_Comp = 4;
	static int king_X_Human = 7, king_Y_Human = 4;

	static void updateComputerKingPosition(int x, int y) {
		king_X_Comp = x;
		king_Y_Comp = y;
	}

	static void updateHumanKingPosition(int x, int y) {
		king_X_Human = x;
		king_Y_Human = y;
	}


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
	
	King(String color, String name) {

		this.pieceColor = color;
		//System.out.println(this.pieceColor);
		this.name = name;
	}
	
	String getCode() {
		if(pieceColor.equals("black")) {
			return blackCode;
		}
		else {
			return whiteCode;
		}
	}

	String getName() {
		return name;
	}

	String getColor() {
		return this.pieceColor;
	}
}

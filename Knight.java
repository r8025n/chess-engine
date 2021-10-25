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

	String getColor() {
		return this.pieceColor;
	}

	static int[] xx = {2, 2, -2, -2, 1, 1, -1, -1};
	static int[] yy = {1, -1, 1, -1, 2, -2, 2, -2};

	static String possibleMoves(int x, int y) {
		String knightMoves = "";
		String temp = "";
		
		for(int i = 0; i < 8; i++) {
			// if(MoveControl.isMoveLegal(x + xx[i], y + yy[i]) && Board.boardArray[x + xx[i]][y + yy[i]] == " ") {
			// 	knightMoves.add(new IntPair(x + xx[i], y + yy[i]));
			// 	System.out.println((x + xx[i]) + " " + (y + yy[i]));
			// }
			if(MoveControl.isMoveLegal(x, y, xx[i], yy[i])) {
				// kingMoves.add(new IntPair(x + xx[i], y + yy[i]));
				temp = "" + x + y + (x + xx[i]) + (y + yy[i]) + Board.boardArray[x + xx[i]][y + yy[i]];
				knightMoves += temp;
			}
		}

		return knightMoves;
	}

}

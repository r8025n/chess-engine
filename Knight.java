import java.util.*;

public class Knight extends Piece {

	private String whiteCode = "\u2658";
	private String blackCode = "\u265E";
	private String pieceColor;
	private String name;
	
	Knight(String c, String name) {
		this.pieceColor = c;
		this.name = name;
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

	String getName() {
		return name;
	}

	// static int[] xx = {2, 2, -2, -2, 1, 1, -1, -1};
	// static int[] yy = {1, -1, 1, -1, 2, -2, 2, -2};

	// String possibleMoves(int x, int y) {
	// 	String knightMoves = "";
	// 	String temp = "";
		
	// 	for(int i = 0; i < 8; i++) {
	// 		// if(isMoveLegal(x + xx[i], y + yy[i]) && Board.boardArray[x + xx[i]][y + yy[i]] == " ") {
	// 		// 	knightMoves.add(new IntPair(x + xx[i], y + yy[i]));
	// 		// 	System.out.println((x + xx[i]) + " " + (y + yy[i]));
	// 		// }
	// 		if(isMoveLegal(x, y, xx[i], yy[i])) {
	// 			// kingMoves.add(new IntPair(x + xx[i], y + yy[i]));
	// 			temp = "" + x + y + (x + xx[i]) + (y + yy[i]) + Board.boardArray[x + xx[i]][y + yy[i]];
	// 			knightMoves += temp;
	// 		}
	// 	}
	// 	System.out.println(knightMoves);
	// 	return knightMoves;
	// }

}

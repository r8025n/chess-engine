import java.util.*;

public class HumanPawn extends Piece {

	private String whiteCode="\u2659";
	private String blackCode="\u265F";
	private String pieceColor;
	private String name;
	private int moves = 0;

	HumanPawn(String c, String name){
		this.pieceColor = c;
		this.name = name;
		moves = 0;
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

	int getMoves() {
		return moves;
	}

	void incrementMove() {
		moves++;
	}

	void decrementMove() {
		moves--;
	}

	// String possibleMoves(int x, int y) {
	// 	String humanPawnMoves = "";
	// 	String temp = "";

	// 	if(isMoveInBound(x - 1, y) && Board.boardArray[x - 1][y] == " ") {
	// 		// humanPawnMoves.add(new IntPair(x - 1, y));
	// 		temp = "" + x + y + (x - 1) + y + Board.boardArray[x - 1][y];
	// 		humanPawnMoves += temp;
	// 	}

	// 	if(isMoveInBound(x - 1, y - 1) && isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y - 1])) {
	// 		// humanPawnMoves.add(new IntPair(x - 1, y - 1));
	// 		temp = "" + x + y + (x - 1) + (y - 1) + Board.boardArray[x - 1][y - 1];
	// 		humanPawnMoves += temp;
	// 	}
			
	// 	if(isMoveInBound(x - 1, y + 1) && isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y + 1])) {
	// 		// humanPawnMoves.add(new IntPair(x - 1, y + 1));
	// 		temp = "" + x + y + (x - 1) + (y + 1) + Board.boardArray[x - 1][y + 1];
	// 		humanPawnMoves += temp;
	// 	}
			
	// 	return humanPawnMoves;
	// }

}

import java.util.*;

public class WhitePawn extends Piece {

	private String whiteCode="\u2659";
	//private String blackCode="\u265F";
		
	String getCode() {
		return whiteCode;
	}

	String getColor() {
		return this.pieceColor;
	}

	static String possibleMoves(int x, int y) {
		String whitePawnMoves = "";
		String temp = "";

		if(MoveControl.isMoveInBound(x - 1, y) && Board.boardArray[x - 1][y] == " ") {
			// whitePawnMoves.add(new IntPair(x - 1, y));
			temp = "" + x + y + (x - 1) + y + Board.boardArray[x - 1][y];
			whitePawnMoves += temp;
		}

		if(MoveControl.isMoveInBound(x - 1, y - 1) && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y - 1])) {
			// whitePawnMoves.add(new IntPair(x - 1, y - 1));
			temp = "" + x + y + (x - 1) + (y - 1) + Board.boardArray[x - 1][y - 1];
			whitePawnMoves += temp;
		}
			
		if(MoveControl.isMoveInBound(x - 1, y + 1) && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y + 1])) {
			// whitePawnMoves.add(new IntPair(x - 1, y + 1));
			temp = "" + x + y + (x - 1) + (y + 1) + Board.boardArray[x - 1][y + 1];
			whitePawnMoves += temp;
		}
			
		return whitePawnMoves;
	}

}

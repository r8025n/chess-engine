import java.util.*;

public class HumanPawn extends Piece {

	private String whiteCode="\u2659";
	private String blackCode="\u265F";
	private String pieceColor;

	HumanPawn(String c){
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

	static String possibleMoves(int x, int y) {
		String humanPawnMoves = "";
		String temp = "";

		if(MoveControl.isMoveInBound(x - 1, y) && Board.boardArray[x - 1][y] == " ") {
			// humanPawnMoves.add(new IntPair(x - 1, y));
			temp = "" + x + y + (x - 1) + y + Board.boardArray[x - 1][y];
			humanPawnMoves += temp;
		}

		if(MoveControl.isMoveInBound(x - 1, y - 1) && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y - 1])) {
			// humanPawnMoves.add(new IntPair(x - 1, y - 1));
			temp = "" + x + y + (x - 1) + (y - 1) + Board.boardArray[x - 1][y - 1];
			humanPawnMoves += temp;
		}
			
		if(MoveControl.isMoveInBound(x - 1, y + 1) && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y + 1])) {
			// humanPawnMoves.add(new IntPair(x - 1, y + 1));
			temp = "" + x + y + (x - 1) + (y + 1) + Board.boardArray[x - 1][y + 1];
			humanPawnMoves += temp;
		}
			
		return humanPawnMoves;
	}

}

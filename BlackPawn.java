import java.util.*;

public class BlackPawn extends Piece {
	
	//private String whiteCode="\u2659";
	private String blackCode="\u265F";
		
	String getCode() {
		return blackCode;
	}

	static String possibleMoves(int x, int y) {
		String blackPawnMoves = "";
		String temp = "";
		
		if(MoveControl.isMoveInBound(x + 1, y) && Board.boardArray[x + 1][y] == " ") {
			// blackPawnMoves.add(new IntPair(x + 1, y));\
			temp = "" + x + y + (x + 1) + y + Board.boardArray[x + 1][y];
			//temp = String.format("%s%s%s%s%s",x,y,(x+1),y,Board.boardArray[x+1][y]);
			System.out.println("bp move= " + temp);
			blackPawnMoves += temp;
		}

		if(MoveControl.isMoveInBound(x + 1, y - 1) && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x + 1][y - 1])) {
			// blackPawnMoves.add(new IntPair(x + 1, y - 1));
			temp = "" + x + y + (x + 1) + (y - 1) + Board.boardArray[x + 1][y - 1];
			blackPawnMoves += temp;
		}

		if(MoveControl.isMoveInBound(x + 1, y + 1) && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x + 1][y + 1])) {
			// blackPawnMoves.add(new IntPair(x + 1, y + 1));
			temp = "" + x + y + (x + 1) + (y + 1) + Board.boardArray[x + 1][y + 1];
			blackPawnMoves += temp;
		}
		
		return blackPawnMoves;
	}

}

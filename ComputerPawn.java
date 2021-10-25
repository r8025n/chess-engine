import java.util.*;

public class ComputerPawn extends Piece {
	
	private String whiteCode="\u2659";
	private String blackCode="\u265F";
	private String pieceColor;

	ComputerPawn(String c) {
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

	String getColor() {
		return this.pieceColor;
	}

	static String possibleMoves(int x, int y) {
		String computerPawnMoves = "";
		String temp = "";
		
		if(MoveControl.isMoveInBound(x + 1, y) && Board.boardArray[x + 1][y] == " ") {
			// computerPawnMoves.add(new IntPair(x + 1, y));\
			temp = "" + x + y + (x + 1) + y + Board.boardArray[x + 1][y];
			//temp = String.format("%s%s%s%s%s",x,y,(x+1),y,Board.boardArray[x+1][y]);
			System.out.println("bp move= " + temp);
			computerPawnMoves += temp;
		}

		if(MoveControl.isMoveInBound(x + 1, y - 1) && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x + 1][y - 1])) {
			// computerPawnMoves.add(new IntPair(x + 1, y - 1));
			temp = "" + x + y + (x + 1) + (y - 1) + Board.boardArray[x + 1][y - 1];
			computerPawnMoves += temp;
		}

		if(MoveControl.isMoveInBound(x + 1, y + 1) && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x + 1][y + 1])) {
			// computerPawnMoves.add(new IntPair(x + 1, y + 1));
			temp = "" + x + y + (x + 1) + (y + 1) + Board.boardArray[x + 1][y + 1];
			computerPawnMoves += temp;
		}
		
		return computerPawnMoves;
	}

}

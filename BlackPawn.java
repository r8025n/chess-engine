import java.util.*;

public class BlackPawn extends Piece {
	
	//private String whiteCode="\u2659";
	private String blackCode="\u265F";
		
	String getCode() {
		return blackCode;
	}

	static ArrayList<IntPair> possibleMoves(int x, int y) {
		ArrayList<IntPair> blackPawnMoves = new ArrayList<>();
		
		if(MoveControl.isMoveLegal(x + 1, y) && Board.boardArray[x + 1][y] == " ")
			blackPawnMoves.add(new IntPair(x + 1, y));

		if(MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x + 1][y - 1]))
			blackPawnMoves.add(new IntPair(x + 1, y - 1));

		if(MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x + 1][y + 1]))
			blackPawnMoves.add(new IntPair(x + 1, y + 1));
		
		return blackPawnMoves;
	}

}

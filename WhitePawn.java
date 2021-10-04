import java.util.*;

public class WhitePawn extends Piece {

	private String whiteCode="\u2659";
	//private String blackCode="\u265F";
		
	String getCode() {
		return whiteCode;
	}

	static ArrayList<IntPair> possibleMoves(int x, int y) {
		ArrayList<IntPair> whitePawnMoves = new ArrayList<>();

		if(MoveControl.isMoveLegal(x - 1, y) && Board.boardArray[x - 1][y] == " ")
			whitePawnMoves.add(new IntPair(x - 1, y));

		if(MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y - 1]))
			whitePawnMoves.add(new IntPair(x - 1, y - 1));

		if(MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y + 1]))
			whitePawnMoves.add(new IntPair(x - 1, y + 1));
		
		return whitePawnMoves;
	}

}

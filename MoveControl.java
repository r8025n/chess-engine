import java.util.*;

public class MoveControl {

	static boolean isMoveLegal(int x, int y) {
		if((x >= 0 && x < 8) && (y >= 0 && y < 8))
			return true;
		else
			return false;
	}

	static boolean noMovePossible(ArrayList<IntPair> currentPossibleMoves){
		if(currentPossibleMoves.size() == 0)
			return true;

		return false;
	}


	static ArrayList<IntPair> returnPossibleMoves(Piece occupyingPiece, int x, int y) {
		if(occupyingPiece instanceof King)
			return King.possibleMoves(x, y);
		else if(occupyingPiece instanceof Queen)
			return Queen.possibleMoves(x, y);
		else if(occupyingPiece instanceof Bishop)
			return Bishop.possibleMoves(x, y);
		else if(occupyingPiece instanceof Knight)
			return Knight.possibleMoves(x, y);
		else if(occupyingPiece instanceof Rook)
			return Rook.possibleMoves(x, y);
		else if(occupyingPiece instanceof BlackPawn)
			return BlackPawn.possibleMoves(x, y);
		else if(occupyingPiece instanceof WhitePawn)
			return WhitePawn.possibleMoves(x, y);
		else
			return EmptyPiece.possibleMoves(x, y);
	}

	static boolean isOppositeColor(String s1, String s2) {
		char c1 = s1.charAt(0);
		char c2 = s2.charAt(0);
		
		if((c1 >= 65 && c1 <= 90) && (c2 >= 97 && c2 <= 122))
			return true;

		else if((c1 >= 97 && c1 <= 122) && (c2 >= 65 && c2 <= 90))
			return true;

		else
			return false;

	}
}
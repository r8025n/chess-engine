import java.util.*;

public class MoveControl {

	// boolean isMoveInBound(int x, int y) {
	// 	if((x >= 0 && x < 8) && (y >= 0 && y < 8))
	// 		return true;
	// 	else
	// 		return false;
	// }

	// boolean isMoveLegal(int x, int y, int xx, int yy) {
	// 	if(MoveControl.isMoveInBound(x + xx, y + yy)) {
	// 		if(Board.boardArray[x + xx][y + yy] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[x + xx][y + yy]))
	// 			return true;
	// 	}

	// 	return false;
	// }


	// boolean noMovePossible(ArrayList<IntPair> currentPossibleMoves) {
	// 	if(currentPossibleMoves.size() == 0)
	// 		return true;

	// 	return false;
	// }


	// static String returnPossibleMoves(Piece occupyingPiece, int x, int y) {
	// 	// if(occupyingPiece instanceof King)
	// 	// 	return occupyingPiece.possibleMoves(x, y);
	// 	// else if(occupyingPiece instanceof Queen)
	// 	// 	return occupyingPiece.possibleMoves(x, y);
	// 	// else if(occupyingPiece instanceof Bishop)
	// 	// 	return occupyingPiece.possibleMoves(x, y);
	// 	// else if(occupyingPiece instanceof Knight)
	// 	// 	return occupyingPiece.possibleMoves(x, y);
	// 	// else if(occupyingPiece instanceof Rook)
	// 	// 	return occupyingPiece.possibleMoves(x, y);
	// 	// else if(occupyingPiece instanceof ComputerPawn)
	// 	// 	return occupyingPiece.possibleMoves(x, y);
	// 	// else if(occupyingPiece instanceof HumanPawn)
	// 	// 	return occupyingPiece.possibleMoves(x, y);
	// 	// else
	// 	// 	return EmptyPiece.possibleMoves(x, y);

	// 	return occupyingPiece.possibleMoves(x, y);
	// }

	// boolean isOppositeColor(String s1, String s2) {
	// 	char c1 = s1.charAt(0);
	// 	char c2 = s2.charAt(0);
		
	// 	if((c1 >= 65 && c1 <= 90) && (c2 >= 97 && c2 <= 122))
	// 		return true;

	// 	else if((c1 >= 97 && c1 <= 122) && (c2 >= 65 && c2 <= 90))
	// 		return true;

	// 	else
	// 		return false;
	// }
}
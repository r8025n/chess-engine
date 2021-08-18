import java.util.*;

public abstract class Piece {

	String whiteCode, blackCode;
	String pieceColor = "";
	
	abstract String getCode();

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
		else if(occupyingPiece instanceof Pawn)
			return Pawn.possibleMoves(x, y);
		else
			return EmptyPiece.possibleMoves(x, y);
	}

	//abstract ArrayList possibleMoves(int x, int y);
	
}

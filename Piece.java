public abstract class Piece {

	String whiteCode,blackCode;
	String pieceColor = "";
	//int[][] possibleMoves;
	
	
	abstract String getCode();

	static int[][] returnPossibleMoves(Piece occupyingPiece) {
		if(occupyingPiece instanceof King)
			return King.possibleMoves;
		else if(occupyingPiece instanceof Queen)
			return Queen.possibleMoves;
		else if(occupyingPiece instanceof Bishop)
			return Bishop.possibleMoves;
		else if(occupyingPiece instanceof Knight)
			return Knight.possibleMoves;
		else if(occupyingPiece instanceof Rook)
			return Rook.possibleMoves;
		else if(occupyingPiece instanceof Pawn)
			return Pawn.possibleMoves;
		else
			return EmptyPiece.possibleMoves;
	}
	
}

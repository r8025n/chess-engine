public class Computer extends ChessEngine implements Player{
	@Override
	public void makeMove(){
		String move  = alphaBetaPruning(globalDepth, Integer.MIN_VALUE, Integer.MAX_VALUE, " ", 0);
		System.out.println(move);
		int sourceX = move.charAt(0) - '0';
		int sourceY = move.charAt(1) - '0';
		int targetX = move.charAt(2) - '0';
		int targetY = move.charAt(3) - '0';
		char capturedPiece = move.charAt(4);
		Spot sourceSpot = Board.spots[sourceX][sourceY];
		Spot targetSpot = Board.spots[targetX][targetY];
		Piece tempPiece = sourceSpot.occupyingPiece;
		String tempCode = sourceSpot.drawCode;
		targetSpot.occupyingPiece = tempPiece;
		targetSpot.drawCode = tempCode;
		targetSpot.pieceColor = Board.computerColor;
		sourceSpot.toggleEmpty();
		targetSpot.toggleEmpty();
		
		if(capturedPiece != ' ')
			targetSpot.toggleEmpty();

		Board.removePieceLabel(sourceSpot, sourceSpot.pieceLabel);
		Board.removePieceLabel(targetSpot, targetSpot.pieceLabel);
		targetSpot.pieceLabel = Board.drawPieceLabel(targetSpot, targetSpot.drawCode);
		Board.updateBoardArray(sourceSpot.getXX(), sourceSpot.getYY(), targetSpot.getXX(), targetSpot.getYY());
	}	
}
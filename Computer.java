public class Computer extends ChessEngine implements Player{
	@Override
	public void makeMove(){
		// int temp_king_human_X = King.king_X_Human,temp_king_human_y = King.king_Y_Human;
		// int temp_king_comp_X = King.king_X_Comp,temp_king_comp_y = King.king_Y_Comp;
		Board.copyArray(Board.backupArray, Board.boardArray);
		String move  = alphaBetaPruning(globalDepth, Integer.MIN_VALUE, Integer.MAX_VALUE, " ", 0);
		System.out.println("output from alpha beta pruning " + move + " ===");
		Board.copyArray(Board.boardArray, Board.backupArray);

		// King.king_X_Human = temp_king_human_X;
		// King.king_Y_Human = temp_king_human_y;
		// King.king_X_Comp = temp_king_comp_X;
		// King.king_Y_Comp = temp_king_comp_y;

		int sourceX = move.charAt(0) - '0';
		int sourceY = move.charAt(1) - '0';
		int targetX = move.charAt(2) - '0';
		int targetY = move.charAt(3) - '0';
		char capturedPiece = move.charAt(4);

		// if(king move hoitese taile king_X_comp update koro)
		if(Board.boardArray[sourceX][sourceY].equals("a")){
			King.king_X_Comp = targetX;
			King.king_Y_Comp = targetY;
		}
			
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
public class HumanPlayer implements Player{
	@Override
	public void makeMove(){
		Spot src = Board.sourceSpot;
		Spot dest = Board.destinationSpot;
		// new Thread(new Runnable() {
		//      @Override
		//      public void run() {
		//      	Board.removePieceLabel(dest, dest.pieceLabel);
		// 		setValues(dest, Board.tempPiece, Board.tempCode);
		// 		dest.pieceLabel = Board.drawPieceLabel(dest, dest.drawCode);
		// 		Board.removePieceLabel(src, Board.tempLabel);
		// 		Board.tempCode = null;
		// 		dest.pieceColor = Board.tempColor;
		// 		dest.unHighlightAll(src.currentPossibleMoves);
		// 		src.currentPossibleMoves.clear();
		//      }
		// }).start();
		Board.removePieceLabel(dest, dest.pieceLabel);
		setValues(dest, Board.tempPiece, Board.tempCode);
		dest.pieceLabel = Board.drawPieceLabel(dest, dest.drawCode);
		Board.removePieceLabel(src, Board.tempLabel);
		Board.tempCode = null;
		dest.pieceColor = Board.tempColor;
		dest.unHighlightAll(src.currentPossibleMoves);
		src.currentPossibleMoves.clear();
		
		if(!(Board.boardArray[dest.x][dest.y].equals(" ")))
			dest.toggleEmpty();
		Board.updateBoardArray(Board.temp_x, Board.temp_y, dest.x, dest.y);
		dest.toggleEmpty();
		//System.out.println(ChessEngine.calculateComputerMoves());
		// System.out.println("Piece Name = " + this.occupyingPiece.getName());
		if(dest.occupyingPiece.getName().equals("a"))
			King.updateComputerKingPosition(dest.x, dest.y);
		else if(dest.occupyingPiece.getName().equals("A"))
			King.updateHumanKingPosition(dest.x, dest.y);

		// ChessEngine.makeComputerMove();
		// new Thread(new Runnable() {
		//      @Override
		//      public void run() {
		//      	ChessEngine.makeComputerMove();
		//      }
		// }).start();
	}

	void setValues(Spot spot, Piece piece, String code) {
		spot.occupyingPiece = piece;
		spot.drawCode = code; 
	}
}
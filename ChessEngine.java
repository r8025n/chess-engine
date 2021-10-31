import java.util.*;
import java.util.Random;

public class ChessEngine {
	
	static String calculateComputerMoves() {
		String allComputerMoves = "";

		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(Character.isLowerCase(Board.boardArray[i][j].charAt(0)))
					allComputerMoves += Board.spots[i][j].occupyingPiece.possibleMoves(i, j);
			}
		}
		System.out.println("Computer Moves = " + allComputerMoves);
		return allComputerMoves;
	}

	static String alphaBeta() {
		String s = calculateComputerMoves();
		int i;
		int limit = s.length()/5;
		Random random = new Random();
		i = random.nextInt(limit);
		// i = limit - 1;
		System.out.println("random number = " + i);
		int si = i*5, ei = si + 5;
		String answer = s.substring(si, ei);
		System.out.println("random move = " + answer);

		return answer;
	}

	// static string alphabeta(int depth, int alpha, int beta) {
	// 	String str = calculateComputerMoves();

	// 	if(depth == 0 || str.size() == 0)
	// 		return

		
	// }

	static void makeComputerMove() {
		String move  = alphaBeta();
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
import java.util.*;
import java.util.Random;

public class ChessEngine {
	
	static int globalDepth = 4;
	static String calculateComputerMoves() {
		String allComputerMoves = "";
		boolean kingSafe = true;
		// if(Game.turn == 1){
		// 	flipBoard();
		// 	kingSafe = King.isKingSafe(7-King.king_X_Comp, 7-King.king_Y_Comp);
		// 	flipBoard();
		// 	Game.turn = 0;	
		// }
		// else{
		// 	kingSafe = King.isKingSafe(King.king_X_Human, King.king_Y_Human);
		// 	Game.turn = 1;
		// }
		
		flipBoard();
		kingSafe = King.isKingSafe(7 - King.king_X_Comp, 7 - King.king_Y_Comp);
		flipBoard();

		if(! kingSafe){
			allComputerMoves += MoveGeneration.kingPossibleMoves(King.king_X_Comp, King.king_Y_Comp);	
			// if(allComputerMoves.length() == 0)
			// 	board.setGameOver();
		}
		else{
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					if(Character.isLowerCase(Board.boardArray[i][j].charAt(0))){
						allComputerMoves += MoveGeneration.returnPossibleMoves(i, j);
					}
				}
			}
		}

		return allComputerMoves;
	}

	static String alphaBetaPruning(int depth, int alpha, int beta, String move, int player) {
		String moves = calculateComputerMoves();
		System.out.println("Computer Moves "+ moves);

		if(depth == 0 || moves.length() == 0){
			// System.out.println("at return logic " + move + ""+ Rating.rating());
			return move + Rating.rating();
		}
		player = 1 - player;

		for(int i = 0; i < moves.length(); i+=5) {
			String temp = makeMove(moves.substring(i, i + 5));
			flipBoard();
			String returnString = alphaBetaPruning(depth - 1, alpha, beta, moves.substring(i, i + 5), player);
			int value = Integer.valueOf(returnString.substring(5));
			// String move = returnString.subString(0, 5);
			flipBoard();
			undoMove(moves.substring(i, i + 5), temp);
			
			if(player == 1){
				if(alpha < value) {
					alpha = value;
					if(depth == globalDepth){
						move = returnString.substring(0, 5);
						System.out.println("final move = " + move);
					}
				}
			}
			else{
				if(beta > value) {
					beta = value;
					if(depth == globalDepth){
						move = returnString.substring(0, 5);
						System.out.println("final move = " + move);
					}
				}
			}
			if(alpha >= beta){
				if(player == 0)
					return move + beta;
				else
					return move + alpha;
			}
		}
		if(player == 0)
			return move + beta;
		else
			return move + alpha;
	}

	static void flipBoard() {
		String temp = "";

		for(int i = 0; i < 32; i++){
			int r = i/8 , c = i%8 ; 
			temp = Board.boardArray[r][c];
			Board.boardArray[r][c] = flipCase(Board.boardArray[7-r][7-c]);
			Board.boardArray[7-r][7-c] = flipCase(temp);
		}
	}

	static String flipCase(String str){
		char c = str.charAt(0);
		String ret = "";

		if(Character.isUpperCase(c))
			ret = Character.toString(Character.toLowerCase(c));
		else
			ret = Character.toString(Character.toUpperCase(c));

		return ret;
	}

	static String makeMove(String move) {
		// String temp = Board.boardArray[move.charAt(2) - '0'][move.charAt(3) - '0'];
		//Piece tempPiece= Board.spots[move.charAt(2) - '0'][move.charAt(3) - '0'].occupyingPiece;
		// if(Board.boardArray[move.charAt(0) - '0'][move.charAt(1) - '0'].equals("A") && Game.turn == 0){
		// 	King.king_X_Human = move.charAt(0) - '0';
		// 	King.king_Y_Human = move.charAt(1) - '0';
		// }

		// if(Board.boardArray[move.charAt(0) - '0'][move.charAt(1) - '0'].equals("A") && Game.turn == 1){
		// 	King.king_X_Comp = move.charAt(0) - '0';
		// 	King.king_Y_Comp = move.charAt(1) - '0';
		// }

		String returnString = move.substring(4);
		Board.boardArray[move.charAt(2) - '0'][move.charAt(3) - '0'] = Board.boardArray[move.charAt(0) - '0'][move.charAt(1) - '0'];
		Board.boardArray[move.charAt(0) - '0'][move.charAt(1) - '0'] = " ";
		// Board.printBoardArray();
		return returnString;
	}

	static void undoMove(String move, String temp) {
		Board.boardArray[move.charAt(0) - '0'][move.charAt(1) - '0'] = Board.boardArray[move.charAt(2) - '0'][move.charAt(3) - '0'];
		Board.boardArray[move.charAt(2) - '0'][move.charAt(3) - '0'] = temp;
	}

	// static void makeComputerMove() {
	// 	String move  = alphaBetaPruning(globalDepth, Integer.MIN_VALUE, Integer.MAX_VALUE, " ", 0);
	// 	System.out.println(move);
	// 	int sourceX = move.charAt(0) - '0';
	// 	int sourceY = move.charAt(1) - '0';
	// 	int targetX = move.charAt(2) - '0';
	// 	int targetY = move.charAt(3) - '0';
	// 	char capturedPiece = move.charAt(4);
	// 	Spot sourceSpot = Board.spots[sourceX][sourceY];
	// 	Spot targetSpot = Board.spots[targetX][targetY];
	// 	Piece tempPiece = sourceSpot.occupyingPiece;
	// 	String tempCode = sourceSpot.drawCode;
	// 	targetSpot.occupyingPiece = tempPiece;
	// 	targetSpot.drawCode = tempCode;
	// 	targetSpot.pieceColor = Board.computerColor;
	// 	sourceSpot.toggleEmpty();
	// 	targetSpot.toggleEmpty();
		
	// 	if(capturedPiece != ' ')
	// 		targetSpot.toggleEmpty();

	// 	Board.removePieceLabel(sourceSpot, sourceSpot.pieceLabel);
	// 	Board.removePieceLabel(targetSpot, targetSpot.pieceLabel);
	// 	targetSpot.pieceLabel = Board.drawPieceLabel(targetSpot, targetSpot.drawCode);
	// 	Board.updateBoardArray(sourceSpot.getXX(), sourceSpot.getYY(), targetSpot.getXX(), targetSpot.getYY());
	// }
	
}
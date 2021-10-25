import java.util.*;

public class Bishop extends Piece {

	private String whiteCode = "\u2657";
	private String blackCode = "\u265D";
	private String pieceColor;
	
	Bishop(String c) {

		this.pieceColor = c;
	}
	
	String getCode() {

		if(pieceColor.equals("black")) {
			return blackCode;
		}
		else {
			return whiteCode;
		}
	}

	String getColor() {
		return this.pieceColor;
	}

	static String possibleMoves(int x, int y) {
		String bishopMoves = "";
		String temp = "";

		for(int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
			if(Board.boardArray[i][j] == " " && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				// bishopMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
			}
			else
				break;
		}

		for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if(Board.boardArray[i][j] == " " && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				// bishopMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
			}
			else
				break;
		}

		for(int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
			if(Board.boardArray[i][j] == " " && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				// bishopMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
			}
			else
				break;
		}

		for(int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++){
			if(Board.boardArray[i][j] == " " && MoveControl.isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				// bishopMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
			}
			else
				break;
		}

		return bishopMoves;
	}
}

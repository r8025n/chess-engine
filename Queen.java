import java.util.*;

public class Queen extends Piece {
	private String whiteCode="\u2655";
	private String blackCode="\u265B";
	private String pieceColor;
	private String name;

	Queen(String c, String name){
		this.pieceColor=c;
		this.name = name;
	}
	
	String getCode() {
		if(pieceColor.equals("black")){
			return blackCode;
		}
		else {
			return whiteCode;
		}
	}

	String getColor() {
		return this.pieceColor;
	}

	String getName() {
		return name;
	}

	String possibleMoves(int x, int y) {
		String queenMoves = "";
		String temp = "";
		
		// horizontal moves
		for(int i = x + 1; i < 8; i++) {
			if(Board.boardArray[i][y] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][y])) {
				// queenMoves.add(new IntPair(i, y));
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				queenMoves += temp;
			}
			else
				break;

		}

		for(int i = x - 1; i >= 0; i--) {
			if(Board.boardArray[i][y] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][y])) {
				// queenMoves.add(new IntPair(i, y));
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				queenMoves += temp;
			}
			else
				break;

		}

		for(int i = y + 1; i < 8; i++) {
			if(Board.boardArray[x][i] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[x][i])) {
				// queenMoves.add(new IntPair(x, i));
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				queenMoves += temp;	
			}
			else
				break;
		}

		for(int i = y - 1; i >= 0; i--) {
			if(Board.boardArray[x][i] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[x][i])) {
				// queenMoves.add(new IntPair(x, i));
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				queenMoves += temp;
			}
			else
				break;
		}

		// diagonal moves

		for(int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
			if(Board.boardArray[i][j] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				// queenMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
			}
			else
				break;
		}

		for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if(Board.boardArray[i][j] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				// queenMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
			}
			else
				break;
		}

		for(int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
			if(Board.boardArray[i][j] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				// queenMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
			}
			else
				break;
		}

		for(int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
			if(Board.boardArray[i][j] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				// queenMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
			}
			else
				break;
		}

		return queenMoves;
	}

}

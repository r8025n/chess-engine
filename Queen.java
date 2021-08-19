import java.util.*;

public class Queen extends Piece {
	private String whiteCode="\u2655";
	private String blackCode="\u265B";
	private String pieceColor;

	Queen(String c){
		this.pieceColor=c;
	}
	
	String getCode() {
		if(pieceColor.equals("black")){
			return blackCode;
		}
		else {
			return whiteCode;
		}
	}

	static ArrayList<IntPair> possibleMoves(int x,int y) {
		ArrayList<IntPair> queenMoves = new ArrayList<>();

		for(int i = x + 1; i < 8; i++) {
			if(Board.boardArray[i][y] == " ")
				queenMoves.add(new IntPair(i, y));
			else
				break;

		}

		for(int i = x - 1; i >= 8; i--) {
			if(Board.boardArray[i][y] == " ")
				queenMoves.add(new IntPair(i, y));
			else
				break;

		}

		for(int i = y + 1; i < 8; i++) {
			if(Board.boardArray[x][i] == " ")
				queenMoves.add(new IntPair(x, i));
			else
				break;
		}

		for(int i = y - 1; i >= 0; i--) {
			if(Board.boardArray[x][i] == " ")
				queenMoves.add(new IntPair(x, i));
			else
				break;
		}

		for(int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
			if(Board.boardArray[i][j] == " ")
				queenMoves.add(new IntPair(i, j));
			else
				break;
		}

		for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if(Board.boardArray[i][j] == " ")
				queenMoves.add(new IntPair(i, j));
			else
				break;
		}

		for(int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
			if(Board.boardArray[i][j] == " ")
				queenMoves.add(new IntPair(i, j));
			else
				break;
		}

		for(int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
			if(Board.boardArray[i][j] == " ")
				queenMoves.add(new IntPair(i, j));
			else
				break;
		}

		return queenMoves;
	}

}

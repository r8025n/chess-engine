import java.util.*;

public class Rook extends Piece {
	private String whiteCode="\u2656";
	private String blackCode="\u265C";
	private String pieceColor;
	private String name;

	Rook(String c, String name){
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
		String rookMoves = "";
		String temp = "";

		for(int i = x + 1; i < 8; i++) {
			if(Board.boardArray[i][y] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][y])) {
				// rookMoves.add(new IntPair(i, y));
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				rookMoves += temp;
			}
			else
				break;

		}

		for(int i = x - 1; i >= 0; i--) {
			if(Board.boardArray[i][y] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][y])) {
				// rookMoves.add(new IntPair(i, y));
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				rookMoves += temp;
			}
			else
				break;

		}

		for(int i = y + 1; i < 8; i++) {
			if(Board.boardArray[x][i] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[x][i])) {
				// rookMoves.add(new IntPair(x, i));
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				rookMoves += temp;
			}
			else
				break;
		}

		for(int i = y - 1; i >= 0; i--) {
			if(Board.boardArray[x][i] == " " || isOppositeColor(Board.boardArray[x][y], Board.boardArray[x][i])) {
				// rookMoves.add(new IntPair(x, i));
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				rookMoves += temp;
			}
			else
				break;
		}

		return rookMoves;
	}

}

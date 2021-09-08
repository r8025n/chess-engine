import java.util.*;

public class Rook extends Piece {
	private String whiteCode="\u2656";
	private String blackCode="\u265C";
	private String pieceColor;

	Rook(String c){
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

	static ArrayList<IntPair> possibleMoves(int x, int y) {
		ArrayList<IntPair> rookMoves = new ArrayList<>();

		for(int i = x + 1; i < 8; i++){
			if(Board.boardArray[i][y] == " ")
				rookMoves.add(new IntPair(i, y));
			else
				break;

		}

		for(int i = x - 1; i >= 0; i--){
			if(Board.boardArray[i][y] == " ")
				rookMoves.add(new IntPair(i, y));
			else
				break;

		}

		for(int i = y + 1; i < 8; i++){
			if(Board.boardArray[x][i] == " ")
				rookMoves.add(new IntPair(x, i));
			else
				break;
		}

		for(int i = y - 1; i >= 0; i--){
			if(Board.boardArray[x][i] == " ")
				rookMoves.add(new IntPair(x, i));
			else
				break;
		}

		return rookMoves;
	}

}

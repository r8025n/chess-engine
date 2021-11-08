import java.util.*;

public abstract class Piece {

	String whiteCode, blackCode;
	String pieceColor = "";
	String name = "";
	
	abstract String getCode();

	abstract String getColor();

	abstract String getName();

	// abstract String possibleMoves(int x, int y);

	// String getCode() {
		
	// 	if(pieceColor.equals("black")) {
	// 		return this.blackCode;
	// 	}
	// 	else {
	// 		return this.whiteCode;
	// 	}
	// }

	// String getColor() {
	// 	return this.pieceColor;
	// }

	static Piece pieceSelector(String str) {
		char c = str.charAt(0);
		Piece piece = null;

		if(c >= 65 && c <= 90){
			switch(c) {
				case 'A':
					piece = new King(Board.humanColor, "A");
					break;
				case 'Q':
					piece = new Queen(Board.humanColor, "Q");
					break;
				case 'B':
					piece = new Bishop(Board.humanColor, "B");
					break;
				case 'K':
					piece = new Knight(Board.humanColor, "K");
					break;
				case 'R':
					piece = new Rook(Board.humanColor, "R");
					break;
				case 'P':
					piece = new HumanPawn(Board.humanColor, "P");
					break;
			}
		}
		else if(c >= 97 && c <= 122) {
			switch(c) {
				case 'a':
					piece = new King(Board.computerColor, "a");
					break;
				case 'q':
					piece = new Queen(Board.computerColor, "q");
					break;
				case 'b':
					piece = new Bishop(Board.computerColor, "b");
					break;
				case 'k':
					piece = new Knight(Board.computerColor, "k");
					break;
				case 'r':
					piece = new Rook(Board.computerColor, "r");
					break;
				case 'p':
					piece = new ComputerPawn(Board.computerColor, "p");
					break;
			}
		}
		else
			piece = new EmptyPiece();

		return piece;
	}
}

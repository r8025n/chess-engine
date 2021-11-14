import java.util.*;

public class King extends Piece{
	
	private String whiteCode = "\u2654";
	private String blackCode = "\u265A";
	private String pieceColor;
	private String name;

	// static int[] xx = {0, 0, 1, 1, 1, -1, -1, -1};
	// static int[] yy = {1, -1, 0, 1, -1, 0, -1, 1};

	// static int king_X_Comp = 0, king_Y_Comp = 4;
	static int king_X_Human = 7, king_Y_Human = 4;
	static int king_X_Comp = 2, king_Y_Comp = 4;


	static void updateComputerKingPosition(int x, int y) {
		king_X_Comp = x;
		king_Y_Comp = y;
	}

	static void updateHumanKingPosition(int x, int y) {
		king_X_Human = x;
		king_Y_Human = y;
	}

	
	King(String color, String name) {

		this.pieceColor = color;
		//System.out.println(this.pieceColor);
		this.name = name;
	}
	
	String getCode() {
		if(pieceColor.equals("black")) {
			return blackCode;
		}
		else {
			return whiteCode;
		}
	}

	String getName() {
		return name;
	}

	String getColor() {
		return this.pieceColor;
	}

	static boolean kingSafeLeftDiagonally(int x, int y) {
		for(int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
			if(Board.boardArray[i][j].equals("q") || Board.boardArray[i][j].equals("b"))
				return false;
			else if(! Board.boardArray[i][j].equals(" "))
				break;
		}

		for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--,j--) {
			if(Board.boardArray[i][j].equals("q") || Board.boardArray[i][j].equals("b"))
				return false;
			else if(! Board.boardArray[i][j].equals(" "))
				break;
		}
		// Computer.flipBoard();
		return true;
	}

	static boolean kingSafeRightDiagonally(int x, int y) {
		for(int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
			if(Board.boardArray[i][j].equals("q") || Board.boardArray[i][j].equals("b"))
				return false;
			else if(! Board.boardArray[i][j].equals(" "))
				break;
		}

		for(int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
			if(Board.boardArray[i][j].equals("q") || Board.boardArray[i][j].equals("b"))
				return false;
			else if(! Board.boardArray[i][j].equals(" "))
				break;
		}

		// Computer.flipBoard();

		return true;	
	}

	static boolean kingSafeHorizontally(int x, int y) {
		for(int i = y + 1; i < 8; i++) {
			if(Board.boardArray[x][i].equals("q") || Board.boardArray[x][i].equals("r"))
				return false;
			else if(! Board.boardArray[x][i].equals(" "))
				break;
		}

		for(int i = y - 1; i >= 0; i--) {
			if(Board.boardArray[x][i].equals("q") || Board.boardArray[x][i].equals("r"))
				return false;
			else if(! Board.boardArray[x][i].equals(" "))
				break;
		}

		return true;
	}

	static boolean kingSafeVertically(int x, int y) {
		for(int i = x + 1; i < 8; i++) {
			if(Board.boardArray[i][y].equals("q") || Board.boardArray[i][y].equals("r")){
				return false;
			}
			else if(! Board.boardArray[i][y].equals(" ")){
				break;
			}
		}

		for(int i = x - 1; i >= 0; i--) {
			if(Board.boardArray[i][y].equals("q") || Board.boardArray[i][y].equals("r")){
				return false;
			}
			else if(! Board.boardArray[i][y].equals(" ")){
				break;
			}
		}
		return true;
	}

	static boolean isKingSafe(int x, int y) {

		// safe feom knight
		int[] xx = {2, 2, -2, -2, 1, 1, -1, -1};
		int[] yy = {1, -1, 1, -1, 2, -2, 2, -2};

		for(int i = 0; i < 8; i++) {
			if(MoveValidation.isMoveLegal(x, y, xx[i], yy[i]) && Board.boardArray[x + xx[i]][y + yy[i]].equals("k"))
				return false;
		}

		//safe from pawns
		int xxx[] = {1, 1, -1, -1};
		int yyy[] = {1, -1, 1, -1};

		for(int i = 0; i < 4; i++) {
			if(MoveValidation.isMoveLegal(x, y, xxx[i], yyy[i]) && Board.boardArray[x + xxx[i]][y + yyy[i]].equals("p"))
				return false;
		}

		//safe from queen, bishop and rook
		if(!kingSafeLeftDiagonally(x, y))
			return false;
		if(!kingSafeRightDiagonally(x, y))
			return false;
		if(!kingSafeVertically(x, y))
			return false;
		if(!kingSafeHorizontally(x, y))
			return false;

		return true;

	}
}

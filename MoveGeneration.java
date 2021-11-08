public class MoveGeneration extends MoveValidation{

	static String returnPossibleMoves(int x, int y){
		String possibleMoves = "";
		String piece = Board.boardArray[x][y];
		// System.out.println("CurrentPiece " + piece);

		if("A".equals(piece) || "a".equals(piece))
			possibleMoves = kingPossibleMoves(x, y);
		else if("Q".equals(piece) || "q".equals(piece))
			possibleMoves = queenPossibleMoves(x, y);
		else if("B".equals(piece) || "b".equals(piece))
			possibleMoves = bishopPossibleMoves(x, y);
		else if("K".equals(piece) || "k".equals(piece))
			possibleMoves = knightPossibleMoves(x, y);
		else if("R".equals(piece) || "r".equals(piece))
			possibleMoves = rookPossibleMoves(x, y);
		else if("p".equals(piece))
			possibleMoves = computerPawnPossibleMoves(x, y);
		else if("P".equals(piece))
			possibleMoves = humanPawnPossibleMoves(x, y);

		return possibleMoves;
	}

	static String kingPossibleMoves(int x, int y) {
		String kingMoves = "";
		String temp = "";
		int[] xx = {0, 0, 1, 1, 1, -1, -1, -1};
		int[] yy = {1, -1, 0, 1, -1, 0, -1, 1};

		for(int i = 0; i < 8; i++){
			if(isMoveLegal(x, y, xx[i], yy[i])) {
				// kingMoves.add(new IntPair(x + xx[i], y + yy[i]));
				temp = "" + x + y + (x + xx[i]) + (y + yy[i]) + Board.boardArray[x + xx[i]][y + yy[i]];
				kingMoves += temp;
			}
		}

		return kingMoves;
	}

	static String queenPossibleMoves(int x, int y) {
		String queenMoves = "";
		String temp = "";
		
		// horizontal moves
		for(int i = x + 1; i < 8; i++) {
			if(Board.boardArray[i][y].equals(" ")) {
				// queenMoves.add(new IntPair(i, y));
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				queenMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][y])) {
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				queenMoves += temp;
				break;
			}
			else
				break;

		}

		for(int i = x - 1; i >= 0; i--) {
			if(Board.boardArray[i][y].equals(" ")) {
				// queenMoves.add(new IntPair(i, y));
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				queenMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][y])){
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				queenMoves += temp;
				break;
			}
			else
				break;

		}

		for(int i = y + 1; i < 8; i++) {
			if(Board.boardArray[x][i].equals(" ")) {
				// queenMoves.add(new IntPair(x, i));
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				queenMoves += temp;	
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[x][i])) {
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				queenMoves += temp;
				break;	
			}
			else
				break;
		}

		for(int i = y - 1; i >= 0; i--) {
			if(Board.boardArray[x][i].equals(" ")) {
				// queenMoves.add(new IntPair(x, i));
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				queenMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[x][i])) {
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				queenMoves += temp;
				break;	
			}
			else
				break;
		}

		// diagonal moves

		for(int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
			if(Board.boardArray[i][j].equals(" ")) {
				// queenMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
				break;
			}
			else
				break;
		}

		for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if(Board.boardArray[i][j].equals(" ")) {
				// queenMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
				break;
			}
			else
				break;
		}

		for(int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
			if(Board.boardArray[i][j].equals(" ")) {
				// queenMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
				break;
			}
			else
				break;
		}

		for(int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
			if(Board.boardArray[i][j].equals(" ")) {
				// queenMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				queenMoves += temp;
				break;
			}
			else
				break;
		}

		return queenMoves;
	}

	static String bishopPossibleMoves(int x, int y) {
		String bishopMoves = "";
		String temp = "";

		for(int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
			if(Board.boardArray[i][j].equals(" ")) {
			// if(Board.spots[i][j].isEmpty() || )
				// bishopMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
				// if(!Board.spots[i][j].isEmpty())
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])){
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
				break;	
			}
			else
				break;
		}

		for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if(Board.boardArray[i][j].equals(" ")) {
				// bishopMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])) {
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
				break;	
			}
			else
				break;
		}

		for(int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
			if(Board.boardArray[i][j].equals(" ")) {
				// bishopMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])){
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
				break;	
			}
			else
				break;
		}

		for(int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++){
			if(Board.boardArray[i][j].equals(" ")) {
				// bishopMoves.add(new IntPair(i, j));
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][j])){
				temp = "" + x + y + i + j + Board.boardArray[i][j];
				bishopMoves += temp;
				break;	
			}
			else
				break;
		}

		return bishopMoves;
	}

	static String knightPossibleMoves(int x, int y) {
		String knightMoves = "";
		String temp = "";
		int[] xx = {2, 2, -2, -2, 1, 1, -1, -1};
		int[] yy = {1, -1, 1, -1, 2, -2, 2, -2};
		
		for(int i = 0; i < 8; i++) {
			// if(isMoveLegal(x + xx[i], y + yy[i]) && Board.boardArray[x + xx[i]][y + yy[i]] == " ") {
			// 	knightMoves.add(new IntPair(x + xx[i], y + yy[i]));
			// 	System.out.println((x + xx[i]) + " " + (y + yy[i]));
			// }
			if(isMoveLegal(x, y, xx[i], yy[i])) {
				// kingMoves.add(new IntPair(x + xx[i], y + yy[i]));
				temp = "" + x + y + (x + xx[i]) + (y + yy[i]) + Board.boardArray[x + xx[i]][y + yy[i]];
				knightMoves += temp;
			}
		}
		System.out.println(knightMoves);
		return knightMoves;
	}

	static String rookPossibleMoves(int x, int y) {
		String rookMoves = "";
		String temp = "";

		for(int i = x + 1; i < 8; i++) {
			if(Board.boardArray[i][y].equals(" ") || isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][y])) {
				// rookMoves.add(new IntPair(i, y));
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				rookMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][y])) {
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				rookMoves += temp;
				break;
			}
			else
				break;

		}

		for(int i = x - 1; i >= 0; i--) {
			if(Board.boardArray[i][y].equals(" ")) {
				// rookMoves.add(new IntPair(i, y));
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				rookMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[i][y])) {
				temp = "" + x + y + i + y + Board.boardArray[i][y];
				rookMoves += temp;
				break;
			}
			else
				break;

		}

		for(int i = y + 1; i < 8; i++) {
			if(Board.boardArray[x][i].equals(" ")) {
				// rookMoves.add(new IntPair(x, i));
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				rookMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[x][i])) {
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				rookMoves += temp;
				break;
			}
			else
				break;
		}

		for(int i = y - 1; i >= 0; i--) {
			if(Board.boardArray[x][i].equals(" ") || isOppositeColor(Board.boardArray[x][y], Board.boardArray[x][i])) {
				// rookMoves.add(new IntPair(x, i));
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				rookMoves += temp;
			}
			else if(isOppositeColor(Board.boardArray[x][y], Board.boardArray[x][i])) {
				temp = "" + x + y + x + i + Board.boardArray[x][i];
				rookMoves += temp;
				break;
			}
			else
				break;
		}

		return rookMoves;
	}

	static String computerPawnPossibleMoves(int x, int y) {
		String computerPawnMoves = "";
		String temp = "";
		// System.out.println("pawn_X pawn_Y " + x +" "+ y);
		// System.out.println(isMoveInBound(x + 1, y));
		// System.out.println()
		// ComputerPawn pawn = (ComputerPawn)Board.spots[x][y].occupyingPiece;
		// int moves = pawn.getMoves();
		// pawn.incrementMove();
		// Syste.out.println(moves);

		if(isMoveInBound(x + 1, y) && Board.boardArray[x + 1][y].equals(" ")) {
			// computerPawnMoves.add(new IntPair(x + 1, y));\
			// System.out.println("Dhuksi");
			temp = "" + x + y + (x + 1) + y + Board.boardArray[x + 1][y];
			//temp = String.format("%s%s%s%s%s",x,y,(x+1),y,Board.boardArray[x+1][y]);
			// System.out.println("bp move= " + temp);
			computerPawnMoves += temp;
		}

		// if(moves == 0 && isMoveInBound(x + 2, y) && Board.boardArray[x + 2][y].equals(" ")){
		// 	temp = "" + x + y + (x + 2) + y + Board.boardArray[x + 2][y];
		// 	computerPawnMoves += temp;
		// }

		if(isMoveInBound(x + 1, y - 1) && isOppositeColor(Board.boardArray[x][y], Board.boardArray[x + 1][y - 1])) {
			// computerPawnMoves.add(new IntPair(x + 1, y - 1));
			temp = "" + x + y + (x + 1) + (y - 1) + Board.boardArray[x + 1][y - 1];
			computerPawnMoves += temp;
		}

		if(isMoveInBound(x + 1, y + 1) && isOppositeColor(Board.boardArray[x][y], Board.boardArray[x + 1][y + 1])) {
			// computerPawnMoves.add(new IntPair(x + 1, y + 1));
			temp = "" + x + y + (x + 1) + (y + 1) + Board.boardArray[x + 1][y + 1];
			computerPawnMoves += temp;
		}
		
		return computerPawnMoves;
	}

	static String humanPawnPossibleMoves(int x, int y) {
		String humanPawnMoves = "";
		String temp = "";

		HumanPawn pawn = (HumanPawn)Board.spots[x][y].occupyingPiece;
		int moves = pawn.getMoves();
		pawn.incrementMove();
		// System.out.println("pawn moves" + moves);

		if(isMoveInBound(x - 1, y) && Board.boardArray[x - 1][y].equals(" ")) {
			// humanPawnMoves.add(new IntPair(x - 1, y));
			temp = "" + x + y + (x - 1) + y + Board.boardArray[x - 1][y];
			humanPawnMoves += temp;
		}

		if(moves == 0 && isMoveInBound(x - 2, y) && Board.boardArray[x - 2][y].equals(" ")){
			temp = "" + x + y + (x - 2) + y + Board.boardArray[x - 2][y];
			humanPawnMoves += temp;
		}

		if(isMoveInBound(x - 1, y - 1) && isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y - 1])) {
			// humanPawnMoves.add(new IntPair(x - 1, y - 1));
			temp = "" + x + y + (x - 1) + (y - 1) + Board.boardArray[x - 1][y - 1];
			humanPawnMoves += temp;
		}
			
		if(isMoveInBound(x - 1, y + 1) && isOppositeColor(Board.boardArray[x][y], Board.boardArray[x - 1][y + 1])) {
			// humanPawnMoves.add(new IntPair(x - 1, y + 1));
			temp = "" + x + y + (x - 1) + (y + 1) + Board.boardArray[x - 1][y + 1];
			humanPawnMoves += temp;
		}
			
		return humanPawnMoves;
	}
}
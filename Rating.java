public class Rating {
	static int stateRating;
	static int len;

	static int rating(/*String moveList, int depth*/) {
		// int len = moveList.length();
		int rate = 0;
		
		int	stateRating = rateState();
		rate += stateRating;
		// rate += rateMovability(len, depth, stateRating);
		ChessEngine.flipBoard();
		stateRating = rateState();
		rate -= stateRating;
		// rate -= rateMovability(len, depth, stateRating);
		ChessEngine.flipBoard();

		return (rate * -1);
	}

	static int rateState() {
		int counter = 0; 
		int bishopCounter = 0;

		for(int i = 0; i <= 63; i++) {
			int r = i/8, c = i%8;

			switch(Board.boardArray[r][c]) {
				case "P": counter += 100;
					break;
                case "R": counter += 500;
                    break;
                case "K": counter += 300;
                    break;
                case "B": bishopCounter += 1;
                    break;
                case "Q": counter += 900;
                    break;
			}			
		}

		if (bishopCounter>=2)
            counter+=300*bishopCounter;
        else
            if(bishopCounter==1)
            	counter+=250;

        return counter;
	} 

	// public static int rateMoveablitly(int listLength, int depth, int stateRating) {
 //        int counter=0;
 //        counter+=listLength;//5 pointer per valid move
 //        if (listLength==0) {//current side is in checkmate or stalemate
 //            if (!AlphaBetaChess.kingSafe()) {//if checkmate
 //                counter+=-200000*depth;
 //            } else {//if stalemate
 //                counter+=-150000*depth;
 //            }
 //        }
 //        return 0;
 //    }
}
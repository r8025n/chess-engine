public class Rating {

	static int rating() {
		int rate = 0;
		rate += rateState();
		ChessEngine.flipBoard();
		rate -= rateState();
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
}
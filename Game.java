import java.util.concurrent.TimeUnit;

public class Game {
	Board board;
	HumanPlayer humanPlayer;
	Computer computer;
	int counter = 0;
	static int turn ;//0 = human. 1 = computer
	
	Game(){
		board = new Board();
		humanPlayer = new HumanPlayer();
		computer = new Computer();
		Spot.setGame(this);
	}

	void moveVsmove(){
		turn = 0;
		humanPlayer.makeMove();
		
		turn  = 1;
		// Board.copyArray(Board.backupArray, Board.boardArray);
		new Thread(new Runnable() {
		     @Override
		     public void run() {
		  //    	try{
				// 	TimeUnit.SECONDS.sleep(5);
				// }catch(InterruptedException i){};
		     	try{
		     		computer.makeMove();
		     	}catch(Exception e){
		     		try{
						TimeUnit.SECONDS.sleep(3);
					}catch(InterruptedException i){};
					board.setGameOver();
		     	}
		     	// Board.copyArray(Board.boardArray, Board.backupArray);
		     }
		}).start();

		// computer.makeMove();

		// if(!King.isKingSafe(King.king_X_Human, King.king_Y_Human) && MoveGeneration.kingPossibleMoves(King.king_X_Human, King.king_Y_Human).length() == 0) {
		// 	board.setGameOver();	
		// }
	}
}
public class Game {
	Board board;
	HumanPlayer humanPlayer;
	Computer computer;

	Game(){
		board = new Board();
		humanPlayer = new HumanPlayer();
		computer = new Computer();
		Spot.setGame(this);
	}

	void moveVsmove(){
		humanPlayer.makeMove();
		new Thread(new Runnable() {
		     @Override
		     public void run() {
		  //    	try{
				// 	TimeUnit.SECONDS.sleep(2);
				// }catch(InterruptedException i){};

		     	computer.makeMove();
		     }
		}).start();
	}
}
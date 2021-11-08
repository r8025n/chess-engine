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

	void moveVmove(){
		humanPlayer.makeMove();
		new Thread(new Runnable() {
		     @Override
		     public void run() {
		     	computer.makeMove();
		     }
		}).start();
	}
}
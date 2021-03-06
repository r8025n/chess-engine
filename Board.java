import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Board {

	JFrame frame;
	static Spot spots[][] = new Spot[8][8];
	static Spot tempSpot;
	static String tempCode, tempColor;
	static JLabel tempLabel;
	static Piece tempPiece;
	static int temp_x, temp_y;
	static String humanColor = "", computerColor = "";
	static int selectedOption;
	static String[] option = {"black","white"};
	static Spot sourceSpot;
	static Spot destinationSpot;
	JLabel gameOver;

	// possible checkmate test

	static String boardArray[][] = {
		{"r", "k", " ", "q", "a", "b", "k", "r"},
		{"p", "p", "p", " ", "p", "p", "p", "p"},
		{" ", " ", " ", " ", "a", " ", " ", " "},
		{"R", " ", " ", " ", " ", " ", " ", " "},
		{" ", " ", " ", " ", " ", " ", " ", " "},
		{" ", " ", " ", " ", " ", "R", " ", " "},
		{"P", "P", "P", "P", "P", "P", "P", "P"},
		{"R", "K", "B", "Q", "A", "B", "K", "R"}
	};

	// static String boardArray[][] = {
	// 	{"r", "k", "b", "q", "a", "b", "k", "r"},
	// 	{"p", "p", "p", "p", "p", "p", "p", "p"},
	// 	{" ", " ", " ", " ", " ", " ", " ", " "},
	// 	{" ", " ", " ", " ", " ", " ", " ", " "},
	// 	{" ", " ", " ", " ", " ", " ", " ", " "},
	// 	{" ", " ", " ", " ", " ", " ", " ", " "},
	// 	{"P", "P", "P", "P", "P", "P", "P", "P"},
	// 	{"R", "K", "B", "Q", "A", "B", "K", "R"}
	// };

	static String backupArray[][] = {
		{"r", "k", "b", "q", "a", "b", "k", "r"},
		{"p", "p", "p", "p", "p", "p", "p", "p"},
		{" ", " ", " ", " ", " ", " ", " ", " "},
		{" ", " ", " ", " ", " ", " ", " ", " "},
		{" ", " ", " ", " ", " ", " ", " ", " "},
		{" ", " ", " ", " ", " ", " ", " ", " "},
		{"P", "P", "P", "P", "P", "P", "P", "P"},
		{"R", "K", "B", "Q", "A", "B", "K", "R"}
	};

	static void copyArray(String[][] a, String[][] b) {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				a[i][j] = b[i][j];
			}
		}
	}

	static void printBoardArray() {
		for(int i = 0; i < 8; i++){
			// for(int j = 0; j < 8; j++) {
			// 	System.out.print(boardArray[i][j] + " ");
			// }
			// System.out.println();
			System.out.println(Arrays.toString(boardArray[i]));
		}
	}

	static void setColor() {
    	if(selectedOption == 0){
    		humanColor = option[0];
    		computerColor = option[1];
    	}
    	else{
    		humanColor = option[1];
    		computerColor = option[0];	
    	}
    }
	
	// Piece[] computerChessPieces = new Piece[] {
	// 		new Rook(computerColor, "r"), new Knight(computerColor, "k"), new Bishop(computerColor, "b"),
	// 		new Queen(computerColor, "q"), new King(computerColor, "a"), new Bishop(computerColor, "b"),
	// 		new Knight(computerColor, "k"), new Rook(computerColor, "r")
	// };
	
	// Piece[] humanChessPieces = new Piece[] {
	// 		new Rook(humanColor, "R"), new Knight(humanColor, "K"), new Bishop(humanColor, "B"),
	// 		new Queen(humanColor, "Q"), new King(humanColor, "A"), new Bishop(humanColor, "B"),
	// 		new Knight(humanColor, "K"), new Rook(humanColor, "R")
	// };
	
	Board(){
		frame= new JFrame("Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLayout(new GridLayout(8, 8));
		// setComputerPieces();
		// setEmptySpots();
		// setHumanPieces();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		selectedOption = JOptionPane.showOptionDialog(null, "Which color you want to play with?", "ABC Options", 
    		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		setColor();
		setChessPieces();
		setBackgroundColors();
		frame.setVisible(true);
		frame.setResizable(false);
		// FinishingWindow finishingWindow = new FinishingWindow();
		// frame.add(finisher);
		gameOver = new JLabel();

	}

	void setGameOver(){
		// gameOver.setText("Game Over");
		// gameOver.setForeground(Color.yellow);
		// frame.add(gameOver);
		frame.setContentPane(new FinishingWindow());
		frame.getContentPane().setBackground(Color.black);
		frame.setVisible(true);
	}

	Board get(){
		return this;
	}

	static void updateBoardArray(int old_x, int old_y, int new_x, int new_y) {	
		boardArray[new_x][new_y] = boardArray[old_x][old_y];
		boardArray[old_x][old_y] = " ";
	}

	
	static void removePieceLabel(Spot spot, JLabel label) {
		spot.remove(label);
		spot.validate();
		spot.repaint();
	}

	static JLabel drawPieceLabel(Spot spot, String drawCode) {
		JLabel label = new JLabel(drawCode, JLabel.CENTER);
		label.setFont(label.getFont().deriveFont(60f));
		spot.add(label);
		spot.validate();
		spot.repaint();

		return label;
	} 
	
	static void setTempValues(Spot spot, Piece piece, JLabel label, String drawCode, String pieceColor, int x, int y) {
		tempSpot = spot;
		tempPiece = piece;
		tempCode = drawCode;
		tempColor = pieceColor;
		tempLabel = label;
		temp_x = x;
		temp_y = y; 
	}

	static void unsetTempValues() {
		tempSpot = null;
		tempPiece = null;
		tempCode = null;
		tempColor = null;
		tempLabel = null;
		temp_x = -1;
		temp_y = -1; 
	}


	// void setComputerPieces(){
	// 	for(int j = 0; j < 8; j++) {
	// 		spots[0][j] = new Spot(0, j, computerChessPieces[j], this);
	// 		spots[0][j].toggleEmpty();
	// 		frame.add(spots[0][j]);
	// 	}

	// 	for(int j = 0; j < 8; j++) {
	// 		spots[1][j] = new Spot(1, j, new ComputerPawn(computerColor, "p"), this);
	// 		spots[1][j].toggleEmpty();
	// 		frame.add(spots[1][j]);
	// 	}
	// }
	
	// void setHumanPieces(){	
	// 	for(int j = 0; j < 8; j++) {
	// 		spots[6][j] = new Spot(6, j, new HumanPawn(humanColor, "P"), this);
	// 		spots[6][j].toggleEmpty();
	// 		frame.add(spots[6][j]);
	// 	}

	// 	for(int j = 0; j < 8; j++) {
	// 		spots[7][j]=new Spot(7,j,humanChessPieces[j], this);
	// 		spots[7][j].toggleEmpty();
	// 		frame.add(spots[7][j]);
	// 	}
	// }
	
	// void setEmptySpots() {
	// 	for(int i = 2; i < 6; i++) {
	// 		for(int j = 0; j < 8; j++){
	// 			spots[i][j] = new Spot(i, j, new EmptyPiece(), this);
	// 			frame.add(spots[i][j]);
	// 		}
	// 	}
	// }

	
	void setBackgroundColors() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i%2 == 0) {
					if(j % 2 == 0) 
						spots[i][j].setBackground(Color.white);
					else
						spots[i][j].setBackground(Color.gray);
				}
				else {
					if(j % 2 == 0)
						spots[i][j].setBackground(Color.gray);
					else
						spots[i][j].setBackground(Color.white);
				}
			}
		}
	}

	void setChessPieces() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				String pieceChar = boardArray[i][j];
				spots[i][j] = new Spot(i, j, Piece.pieceSelector(pieceChar));
				frame.add(spots[i][j]);
				if(pieceChar != " ")
					spots[i][j].toggleEmpty();
			}
		}
	}
}

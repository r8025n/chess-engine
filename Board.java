import java.awt.*;
import javax.swing.*;

public class Board {

	JFrame frame;
	Spot spots[][] = new Spot[8][8];
	static Spot tempSpot;
	static String tempCode;
	static JLabel tempLabel;
	static Piece tempPiece;
	static int temp_x, temp_y;
	String humanColor = "white", computerColor = "black"; 

	static String boardArray[][] = {
		{"r", "k", "b", "q", "a", "b", "k", "r"},
		{"p", "p", "p", "p", "p", "p", "p", "p"},
		{" ", " ", " ", " ", " ", " ", " ", " "},
		{" ", " ", " ", " ", " ", " ", " ", " "},
		{" ", " ", " ", " ", " ", " ", " ", " "},
		{" ", " ", " ", " ", " ", " ", " ", " "},
		{"P", "P", "P", "P", "P", "P", "P", "P"},
		{"R", "K", "B", "Q", "A", "B", "K", "R"}
	};
	
	Piece[] computerChessPieces = new Piece[] {
			new Rook(computerColor), new Knight(computerColor), new Bishop(computerColor),
			new Queen(computerColor), new King(computerColor), new Bishop(computerColor),
			new Knight(computerColor), new Rook(computerColor)
	};
	
	Piece[] humanChessPieces = new Piece[] {
			new Rook(humanColor), new Knight(humanColor), new Bishop(humanColor),
			new Queen(humanColor), new King(humanColor), new Bishop(humanColor),
			new Knight(humanColor), new Rook(humanColor)
	};
	
	Board(){
		frame= new JFrame("Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.setLayout(new GridLayout(8, 8));
		setComputerPieces();
		setEmptySpots();
		setHumanPieces();
		setBackgroundColors();
		frame.setVisible(true);
		frame.setResizable(false);
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
	
	static void setTempValues(Spot spot, Piece piece, JLabel label, String drawCode, int x, int y) {
		tempSpot = spot;
		tempPiece = piece;
		tempCode = drawCode;
		tempLabel = label;
		temp_x = x;
		temp_y = y; 
	}


	void setComputerPieces(){
		for(int j = 0; j < 8; j++) {
			spots[0][j] = new Spot(0, j, computerChessPieces[j], this);
			spots[0][j].toggleEmpty();
			frame.add(spots[0][j]);
		}

		for(int j = 0; j < 8; j++) {
			spots[1][j] = new Spot(1, j, new ComputerPawn(computerColor), this);
			spots[1][j].toggleEmpty();
			frame.add(spots[1][j]);
		}
	}
	
	void setHumanPieces(){	
		for(int j = 0; j < 8; j++) {
			spots[6][j] = new Spot(6, j, new HumanPawn(humanColor), this);
			spots[6][j].toggleEmpty();
			frame.add(spots[6][j]);
		}

		for(int j = 0; j < 8; j++) {
			spots[7][j]=new Spot(7,j,humanChessPieces[j], this);
			spots[7][j].toggleEmpty();
			frame.add(spots[7][j]);
		}
	}
	
	void setEmptySpots() {
		for(int i = 2; i < 6; i++) {
			for(int j = 0; j < 8; j++){
				spots[i][j] = new Spot(i, j, new EmptyPiece(), this);
				frame.add(spots[i][j]);
			}
		}
	}
	
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
}

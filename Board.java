import java.awt.*;
import javax.swing.*;

public class Board {

	JFrame frame;
	Spot spots[][] = new Spot[8][8];
	static Spot tempSpot;
	static String tempCode, temp_x, temp_y;
	static JLabel tempLabel;
	static Piece tempPiece; 

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
	
	Piece[] blackChessPieces = new Piece[] {
			new Rook("black"), new Knight("black"), new Bishop("black"),
			new Queen("black"), new King("black"), new Bishop("black"),
			new Knight("black"), new Rook("black")
	};
	
	Piece[] whiteChessPieces = new Piece[] {
			new Rook("white"), new Knight("white"), new Bishop("white"),
			new Queen("white"), new King("white"), new Bishop("white"),
			new Knight("white"), new Rook("white")
	};
	
	Board(){

		frame= new JFrame("Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.setLayout(new GridLayout(8,8));
		setBlackPieces();
		setEmptySpots();
		setWhitePieces();
		setBackgroundColors();
		frame.setVisible(true);
		frame.setResizable(false);
	}

	Board get(){
		return this;
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
	static void setTempValues(Spot spot, Piece piece, JLabel label, String drawCode, String x, String y) {
		tempSpot = spot;
		tempPiece = piece;
		tempCode = drawCode;
		tempLabel = label;
		temp_x = x;
		temp_y = y; 
	}

	void setBlackPieces(){

		for(int j = 0; j < 8; j++) {
			spots[0][j] = new Spot(0, j, blackChessPieces[j], this);
			spots[0][j].toggleEmpty();
			frame.add(spots[0][j]);
		}

		for(int j = 0; j < 8; j++) {
			spots[1][j] = new Spot(1, j, new BlackPawn(), this);
			spots[1][j].toggleEmpty();
			frame.add(spots[1][j]);
		}
	}
	
	void setWhitePieces(){
		
		for(int j = 0; j < 8; j++) {
			spots[6][j] = new Spot(6, j, new WhitePawn(), this);
			spots[6][j].toggleEmpty();
			frame.add(spots[6][j]);
		}

		for(int j = 0; j < 8; j++) {
			spots[7][j]=new Spot(7,j,whiteChessPieces[j], this);
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

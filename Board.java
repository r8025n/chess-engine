import java.awt.*;
import javax.swing.*;

public class Board {
	JFrame frame;
	Spot spots[][]=new Spot[8][8];
	
	
	Piece[] blackChessPieces=new Piece[] {
			new Rook("black"),new Knight("black"),new Bishop("black"),
			new Queen("black"),new King("black"),new Bishop("black"),
			new Knight("black"),new Rook("black")
	};
	
	Piece[] whiteChessPieces=new Piece[] {
			new Rook("white"),new Knight("white"),new Bishop("white"),
			new Queen("white"),new King("white"),new Bishop("white"),
			new Knight("white"),new Rook("white")
	};
	
	Board(){
		frame=new JFrame("Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.setLayout(new GridLayout(8,8));
		setBlackPieces();
		setEmptySpots();
		setWhitePieces();
		setBackgroundColors();
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	void setBlackPieces(){
		for(int j=0;j<8;j++) {
			spots[0][j]=new Spot(0,j,blackChessPieces[j]);
			frame.add(spots[0][j]);
		}
		for(int j=0;j<8;j++) {
			spots[1][j]=new Spot(1,j,new Pawn("black"));
			frame.add(spots[1][j]);
		}
	}
	
	void setWhitePieces(){
		for(int j=0;j<8;j++) {
			spots[6][j]=new Spot(6,j,new Pawn("white"));
			frame.add(spots[6][j]);
		}
		for(int j=0;j<8;j++) {
			spots[7][j]=new Spot(7,j,whiteChessPieces[j]);
			frame.add(spots[7][j]);
		}
	}
	
	void setEmptySpots() {
		for(int i=2;i<6;i++) {
			for(int j=0;j<8;j++){
				spots[i][j]=new Spot(i,j,new EmptyPiece());
				frame.add(spots[i][j]);
			}
		}
	}
	
	void setBackgroundColors() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(i%2==0) {
					if(j%2==0) 
						spots[i][j].setBackground(Color.white);
					else
						spots[i][j].setBackground(Color.gray);
				}
				else {
					if(j%2==0)
						spots[i][j].setBackground(Color.gray);
					else
						spots[i][j].setBackground(Color.white);
				}
			}
		}
	}
}

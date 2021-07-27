import java.awt.*;
import javax.swing.*;

public class Board {
	JFrame frame;
	JPanel spots[][]=new JPanel[8][8];
	
	
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
		Spot temp;
		for(int i=0;i<2;i++) {
			for(int j=0;j<8;j++) {
				if(i==0) 
					temp=new Spot(i,j,blackChessPieces[j]);
				else
					temp=new Spot(i,j,new Pawn("black"));
				
				spots[i][j]=temp.getPanel();
				frame.add(spots[i][j]);
			}
		}
	}
	
	void setWhitePieces(){
		Spot temp;
		for(int i=7;i>5;i--) {
			for(int j=0;j<8;j++) {
				if(i==7) 
					temp=new Spot(i,j,whiteChessPieces[j]);
				else
					temp=new Spot(i,j,new Pawn("white"));
				
				spots[i][j]=temp.getPanel();
				frame.add(spots[i][j]);
			}
		}
	}
	
	void setEmptySpots() {
		Spot temp;
		for(int i=2;i<6;i++) {
			for(int j=0;j<8;j++){
				temp=new Spot(i,j,new EmptyPiece());
				spots[i][j]=temp.getPanel();
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

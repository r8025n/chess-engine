import javax.swing.*;

public class Spot extends JPanel{
	private int x,y;
	Spot(int x,int y,Piece piece){
		this.x=x;
		this.y=y;
		String drawCode=piece.getCode();
		JLabel pieceLabel=new JLabel(drawCode,JLabel.CENTER);
		pieceLabel.setFont(pieceLabel.getFont().deriveFont(60f));
		this.add(pieceLabel);
	}
}

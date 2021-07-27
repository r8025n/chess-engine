import javax.swing.*;

public class Spot {
	private int x,y;
	JPanel panel;
	Spot(int x,int y,Piece piece){
		this.x=x;
		this.y=y;
		String drawCode=piece.getCode();
		JLabel pieceLabel=new JLabel(drawCode,JLabel.CENTER);
		pieceLabel.setFont(pieceLabel.getFont().deriveFont(60f));
		panel=new JPanel();
		panel.add(pieceLabel);
	}
	
	JPanel getPanel() {
		return panel;
	}
}

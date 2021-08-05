import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class Spot extends JPanel implements MouseListener{

	private int x, y;
	private boolean empty = true, highlighted = false;
	Piece occupyingPiece;
	Border blackline = BorderFactory.createLineBorder(Color.red);
	Board board;

	Spot(int x,int y,Piece piece,Board board) {

		this.x = x;
		this.y = y;
		this.board = board.get();
		occupyingPiece = piece;
		String drawCode = piece.getCode();
		JLabel pieceLabel = new JLabel(drawCode, JLabel.CENTER);
		pieceLabel.setFont(pieceLabel.getFont().deriveFont(60f));
		this.add(pieceLabel);
		this.addMouseListener(this);
	}

	void toggleEmpty() {

		empty = ! empty;
	}

	boolean isEmpty() {

		return empty;
	}

	void toggleHighlighted() {

		highlighted = ! highlighted;
	}

	boolean isHighlighted() {

		return highlighted;
	}

	boolean isMoveLegal(int x, int y) {

		if(x >= 0 && x < 8 && y >= 0 && y < 8)
			return true;
		else
			return false;
	}

	void highlightSpots() {
		int xx, yy, len;
		int[][] currentPossibleMoves = Piece.returnPossibleMoves(occupyingPiece);
		len = currentPossibleMoves.length;
		System.out.println(len);
		for(int i = 0; i < len; i++) {
			xx = x + currentPossibleMoves[i][0];
			yy = y + currentPossibleMoves[i][1];
			System.out.println("xx= "+xx+"  yy="+yy);
			if(board.spots[xx][yy].isEmpty() && isMoveLegal(xx,yy)) {
				board.spots[xx][yy].toggleHighlighted();
				board.spots[xx][yy].setBorder(blackline);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("x= "+x+"  y="+y);
		this.highlightSpots();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

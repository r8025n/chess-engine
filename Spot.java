import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class Spot extends JPanel implements MouseListener{

	private int x, y;
	private boolean empty = true, highlighted = false;
	Piece occupyingPiece;
	Border blackline = BorderFactory.createLineBorder(Color.red);
	Board board;
	String drawCode;
	JLabel pieceLabel;

	Spot(int x,int y,Piece piece,Board board) {

		this.x = x;
		this.y = y;
		this.board = board.get();
		occupyingPiece = piece;
		drawCode = piece.getCode();
		this.pieceLabel = Board.drawPieceLabel(this, drawCode);
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
		ArrayList<IntPair> currentPossibleMoves = Piece.returnPossibleMoves(occupyingPiece, this.x, this.y);
		len = currentPossibleMoves.size();
		System.out.println(len);

		for(int i = 0; i < len; i++) {
			IntPair pair = currentPossibleMoves.get(i);
			xx = pair.x_val;
			yy = pair.y_val;

			System.out.println("xx= "+ xx +"  yy="+ yy);
			
			if(isMoveLegal(xx,yy) && board.spots[xx][yy].isEmpty()){
				board.spots[xx][yy].toggleHighlighted();
				board.spots[xx][yy].setBorder(blackline);
			}
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(! isHighlighted() && Board.tempCode == null){
			System.out.println("x= " + x + "  y=" + y);
			this.highlightSpots();
			Board.setTempValues(this, this.pieceLabel, this.drawCode);
		}
		else if(Board.tempCode != null){
			Board.removePieceLabel(this, this.pieceLabel);
			this.pieceLabel = Board.drawPieceLabel(this, Board.tempCode);
			Board.removePieceLabel(Board.tempSpot, Board.tempLabel);
			Board.tempCode = null;

		}

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

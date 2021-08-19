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
	Border redBorder = BorderFactory.createLineBorder(Color.red);
	Border emptyBorder = BorderFactory.createEmptyBorder();
	Board board;
	String drawCode;
	JLabel pieceLabel;
	ArrayList<IntPair> currentPossibleMoves;

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

	static boolean isMoveLegal(int x, int y) {

		if((x >= 0 && x < 8) && (y >= 0 && y < 8))
			return true;
		else
			return false;
	}

	void setValues(Piece piece, String code) {
		this.occupyingPiece = piece;
		this.drawCode = code; 
	}

	void highlightAll(ArrayList<IntPair> currentPossibleMoves) {
		int xx, yy;

		for(int i = 0; i < currentPossibleMoves.size(); i++) {
			IntPair pair = currentPossibleMoves.get(i);
			xx = pair.x_val;
			yy = pair.y_val;
			
			if(isMoveLegal(xx,yy) && board.spots[xx][yy].isEmpty()){
				//System.out.println("xx= "+ xx +"  yy="+ yy);
				board.spots[xx][yy].toggleHighlighted();
				board.spots[xx][yy].setBorder(redBorder);
			}
			else{
				currentPossibleMoves.remove(i);
				i--;
			}
		}
	}

	void unHighlightAll(ArrayList<IntPair> currentPossibleMoves) {
		int xx, yy;
		for(int i = 0; i < currentPossibleMoves.size(); i++) {
			IntPair pair = currentPossibleMoves.get(i);
			xx = pair.x_val;
			yy = pair.y_val;

			board.spots[xx][yy].toggleHighlighted();
			board.spots[xx][yy].setBorder(emptyBorder);
			
		}
	}


	void highlightSpots() {
		currentPossibleMoves = Piece.returnPossibleMoves(occupyingPiece, this.x, this.y);
		highlightAll(this.currentPossibleMoves);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(! isHighlighted() && Board.tempCode == null){
			System.out.println("x= " + x + "  y=" + y);
			this.highlightSpots();
			Board.setTempValues(this, this.occupyingPiece, this.pieceLabel, this.drawCode);
			this.toggleEmpty();
		}
		else if(Board.tempCode != null && isHighlighted()){
			Board.removePieceLabel(this, this.pieceLabel);
			setValues(Board.tempPiece, Board.tempCode);
			this.pieceLabel = Board.drawPieceLabel(this, this.drawCode);
			Board.removePieceLabel(Board.tempSpot, Board.tempLabel);
			Board.tempCode = null;
			unHighlightAll(Board.tempSpot.currentPossibleMoves);
			Board.tempSpot.currentPossibleMoves.clear();
			this.toggleEmpty();
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
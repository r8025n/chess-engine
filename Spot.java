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
	String drawCode, pieceColor;
	JLabel pieceLabel;
	ArrayList<IntPair> currentPossibleMoves = new ArrayList<>();

	Spot(int x,int y,Piece piece,Board board) {
		this.x = x;
		this.y = y;
		this.board = board.get();
		occupyingPiece = piece;
		drawCode = piece.getCode();
		pieceColor = piece.getColor();
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

	// static boolean isMoveLegal(int x, int y) {
	// 	if((x >= 0 && x < 8) && (y >= 0 && y < 8))
	// 		return true;
	// 	else
	// 		return false;
	// }

	void setValues(Piece piece, String code) {
		this.occupyingPiece = piece;
		this.drawCode = code; 
	}

	// boolean noMovePossible(){
	// 	if(currentPossibleMoves.size() == 0)
	// 		return true;

	// 	return false;
	// }

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
		String possibleMoves = MoveControl.returnPossibleMoves(occupyingPiece, this.x, this.y);
		System.out.println(possibleMoves);
		int moves = possibleMoves.length() / 5;
		int k = 0, xx, yy;;

		for(int i = 0; i < moves; i++) {
			xx = possibleMoves.charAt(k + 2) - '0';
			yy = possibleMoves.charAt(k + 3) - '0';
			currentPossibleMoves.add(new IntPair(xx, yy));
			k += 5;
		}

		if(! MoveControl.noMovePossible(currentPossibleMoves))
	 		for(int i = 0; i < this.currentPossibleMoves.size(); i++) {
				IntPair pair = currentPossibleMoves.get(i);
				xx = pair.x_val;
				yy = pair.y_val;
				board.spots[xx][yy].toggleHighlighted();
				board.spots[xx][yy].setBorder(redBorder);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// if(Board.humanColor.equals(this.pieceColor)){
		if(! isHighlighted() && Board.tempCode == null && ! isEmpty() && Board.humanColor.equals(this.pieceColor)){
			System.out.println("x= " + x + "  y=" + y);
			this.highlightSpots();

			if(! MoveControl.noMovePossible(currentPossibleMoves)) {
				Board.setTempValues(this, this.occupyingPiece, this.pieceLabel, this.drawCode, this.pieceColor, this.x, this.y);
				this.toggleEmpty();
			}
		}
		else if(Board.tempCode != null && isHighlighted()){
			Board.removePieceLabel(this, this.pieceLabel);
			setValues(Board.tempPiece, Board.tempCode);
			this.pieceLabel = Board.drawPieceLabel(this, this.drawCode);
			Board.removePieceLabel(Board.tempSpot, Board.tempLabel);
			Board.tempCode = null;
			this.pieceColor = Board.tempColor;
			unHighlightAll(Board.tempSpot.currentPossibleMoves);
			Board.tempSpot.currentPossibleMoves.clear();
			Board.updateBoardArray(Board.temp_x, Board.temp_y, this.x, this.y);
			this.toggleEmpty();
			Board.printBoardArray();
		}
		// }
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
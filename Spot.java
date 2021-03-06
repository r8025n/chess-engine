import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class Spot extends JPanel implements MouseListener{
	int x, y;
	private boolean empty = true;
	private boolean highlighted = false;
	Piece occupyingPiece;
	Border redBorder = BorderFactory.createLineBorder(Color.red, 5);
	Border emptyBorder = BorderFactory.createEmptyBorder();
	// Board board;
	String drawCode, pieceColor;
	JLabel pieceLabel;
	static Game game;
	ArrayList<IntPair> currentPossibleMoves = new ArrayList<>();
	int pressed = 0;

	Spot(int x,int y,Piece piece/*,Board board*/) {
		this.x = x;
		this.y = y;
		// this.board = board.get();
		occupyingPiece = piece;
		// if(!(occupyingPiece instanceof EmptyPiece))
		// 	toggleEmpty();
		drawCode = piece.getCode();
		pieceColor = piece.getColor();
		this.pieceLabel = Board.drawPieceLabel(this, drawCode);
		this.addMouseListener(this);
	}

	static void setGame(Game g){
		game = g;
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

	// void setValues(Piece piece, String code) {
	// 	this.occupyingPiece = piece;
	// 	this.drawCode = code; 
	// }

	// boolean noMovePossible(){
	// 	if(currentPossibleMoves.size() == 0)
	// 		return true;

	// 	return false;
	// }
	int getXX(){
		return this.x;
	}
	int getYY(){
		return this.y;
	}

	void unHighlightAll(ArrayList<IntPair> currentPossibleMoves) {
		int xx, yy;

		for(int i = 0; i < currentPossibleMoves.size(); i++) {
			IntPair pair = currentPossibleMoves.get(i);
			xx = pair.x_val;
			yy = pair.y_val;

			Board.spots[xx][yy].toggleHighlighted();
			Board.spots[xx][yy].setBorder(emptyBorder);
			
		}
	}

	void highlightSpots() {
		//String possibleMoves = MoveControl.returnPossibleMoves(occupyingPiece, this.x, this.y);
		// String possibleMoves = occupyingPiece.possibleMoves(x, y);
		String possibleMoves = MoveGeneration.returnPossibleMoves(x, y);
		// System.out.println(possibleMoves);
		int moves = possibleMoves.length() / 5;
		System.out.println("moves to be highlighted = " + moves);
		int k = 0, xx, yy;;

		for(int i = 0; i < moves; i++) {
			xx = possibleMoves.charAt(k + 2) - '0';
			yy = possibleMoves.charAt(k + 3) - '0';
			currentPossibleMoves.add(new IntPair(xx, yy));
			k += 5;
		}

		// if(! MoveControl.noMovePossible(currentPossibleMoves)) {
		if(currentPossibleMoves.size() != 0) {
	 		for(int i = 0; i < this.currentPossibleMoves.size(); i++) {
				IntPair pair = currentPossibleMoves.get(i);
				xx = pair.x_val;
				yy = pair.y_val;
				Board.spots[xx][yy].toggleHighlighted();
				Board.spots[xx][yy].setBorder(redBorder);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(this.isEmpty());
		Board.printBoardArray();
		// if(Board.humanColor.equals(this.pieceColor)){
		if(! isHighlighted() && Board.tempCode == null && ! isEmpty() && Board.humanColor.equals(this.pieceColor)){
		// if(! isHighlighted() && this.pressed <= 1 && Board.humanColor.equals(this.pieceColor)){
			System.out.println("x= " + x + "  y=" + y);
			// if(this.pressed == 1){
			// 	Board.unsetTempValues();
			// 	this.unHighlightAll(this.currentPossibleMoves);
			// 	this.currentPossibleMoves.clear();
			// 	this.pressed = 0;
			// 	this.toggleEmpty();
			// }
			this.highlightSpots();
			// this.pressed++;
			//System.out.println("Piece Name = " + this.occupyingPiece.getName());

			if(currentPossibleMoves.size() != 0) {
				Board.setTempValues(this, this.occupyingPiece, this.pieceLabel, this.drawCode, this.pieceColor, this.x, this.y);
				this.toggleEmpty();
				Board.sourceSpot = this;
			}
		}
		else if(Board.tempSpot == this){
			Board.unsetTempValues();
			this.toggleEmpty();
			unHighlightAll(currentPossibleMoves);
			this.currentPossibleMoves.clear();
			if(Board.boardArray[this.x][this.y].equals("P")){
				HumanPawn hp = (HumanPawn)this.occupyingPiece;
				hp.decrementMove();
			}
			if(Board.boardArray[this.x][this.y].equals("P")){
				ComputerPawn cp = (ComputerPawn)this.occupyingPiece;
				cp.decrementMove();
			}
		}
		else if(Board.tempCode != null && isHighlighted()) {
			Board.destinationSpot = this;
			game.moveVsmove();
			// Board.removePieceLabel(this, this.pieceLabel);
			// setValues(Board.tempPiece, Board.tempCode);
			// this.pieceLabel = Board.drawPieceLabel(this, this.drawCode);
			// Board.removePieceLabel(Board.tempSpot, Board.tempLabel);
			// Board.tempCode = null;
			// this.pieceColor = Board.tempColor;
			// unHighlightAll(Board.tempSpot.currentPossibleMoves);
			// Board.tempSpot.currentPossibleMoves.clear();
			
			// if(!(Board.boardArray[this.x][this.y].equals(" ")))
			// 	toggleEmpty();
			// Board.updateBoardArray(Board.temp_x, Board.temp_y, this.x, this.y);
			// this.toggleEmpty();
			// //System.out.println(ChessEngine.calculateComputerMoves());
			// // System.out.println("Piece Name = " + this.occupyingPiece.getName());
			// if(this.occupyingPiece.getName().equals("a"))
			// 	King.updateComputerKingPosition(this.x, this.y);
			// else if(this.occupyingPiece.getName().equals("A"))
			// 	King.updateHumanKingPosition(this.x, this.y);

			// // ChessEngine.makeComputerMove();
			// new Thread(new Runnable() {
			//      @Override
			//      public void run() {
			//      	ChessEngine.makeComputerMove();
			//      }
			// }).start();
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
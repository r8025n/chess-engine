import java.util.*;

public abstract class Piece extends MoveValidation{

	String whiteCode, blackCode;
	String pieceColor = "";
	String name = "";
	
	abstract String getCode();

	abstract String getColor();

	abstract String getName();

	abstract String possibleMoves(int x, int y);

	// String getCode() {
		
	// 	if(pieceColor.equals("black")) {
	// 		return this.blackCode;
	// 	}
	// 	else {
	// 		return this.whiteCode;
	// 	}
	// }

	// String getColor() {
	// 	return this.pieceColor;
	// }
}

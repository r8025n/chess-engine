import java.util.*;

public abstract class Piece extends MoveValidation{

	String whiteCode, blackCode;
	String pieceColor = "";
	
	abstract String getCode();

	abstract String getColor();

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

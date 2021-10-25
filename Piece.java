import java.util.*;

public abstract class Piece {

	String whiteCode, blackCode;
	String pieceColor = "";
	
	abstract String getCode();

	abstract String getColor();

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

package Move_Validation;

import java.util.ArrayList;
import java.util.Collection;

import Enums.ChessPieceType;
import Enums.GameColor;
import Interfaces.BoardIF;
import Interfaces.PieceIF;
import Model.Piece;
import Model.Position;
import Model.Board;

/**
 * Abstract class that is used for the decorator subclasses
 *
 * @author Tyler (100%)
 * @version 1.0
 */
public abstract class PieceValidator extends Piece{
	
	Board board;

	/**
	 * Constructor for PieceValidators
	 *
	 * @param board - An instance of the board object
	 */
	public PieceValidator(BoardIF board) {
		this.board = (Board)board;
	}

	/**
	 * Abstract method for making an array of valid moves of a piece
	 *
	 * @param position - The position of the piece to check
	 * @return An array of positions that are valid to move to
	 */
	public abstract Position[] showMoves(Position position);
	
	/**
	 * showMoves- To be used by subclasses. Checks if this validator is wrapped by another 
	 * validator, and if so, collects the movement options from the outer validator and sends them
	 * back down to the inner validator.
	 * @param moves
	 * @param position
	 * @return
	 */
	public Position[] showMoves(Collection<Position> moves, Position position) {
		ArrayList<Position> newMoves = new ArrayList<Position>();
		Position[] allMoves = new Position[moves.size()];

		/** If this validator is wrapped, we need to collect the moves of the wrapping validator**/
		if(this.getPieceValidator() != null) {
			Position[] moveArray = this.getPieceValidator().showMoves(position);
			for (int i = 0; i < moveArray.length; i++) {
				newMoves.add(moveArray[i]);
			}
		}
		
		/** Once we've gathered our movement options, cut out the ones that put us into check**/
		newMoves.addAll(moves);
		if(this.getPieceValidator() == null) {
			/**Base case- there are no more layers of validators
			 * This part can probably be threaded!?**/
			if(this.isWhite()) {
				PieceIF wKing = findKing(board.getPlayerPieces(1), GameColor.WHITE);
				for(PieceIF enemy : board.getPlayerPieces(2)) {
					for(Position option : enemy.showMoves()) {
						if(option.getSquare().getPiece() == wKing){
							newMoves.remove(option);
						}
					}					
				}
			}
		}
		return newMoves.toArray(allMoves);
	}

	/**
	 * findKing- For any given, valid color and piece type, this will attempt to return that
	 * piece. If that piece is not on the board, this returns null.
	 * @param color: The color of the desired piece
	 * @param chessPiece: The desired piece type
	 * @return: A piece on the board or null
	 */
	private PieceIF findKing(ArrayList<PieceIF> pieces, GameColor color){
		if(color.getColor() == 'w'){
			;
		}
		else if(color.getColor() == 'b'){
			;
		}
		return null;
	}
	
	/**
	 * inRange- Ensures two given integers are within the range of the board array
	 *
	 * @param i- Relates to an integer spanning the width of the board
	 * @param j- Relates to an integer spanning the height of the board
	 * @return- True if the given integers are within the range of the board array, otherwise false
	 **/
	public boolean inRange(int i, int j) {
		return (0 <= i && i < this.board.getWidth()) && (0 <= j && j < this.board.getHeight());
	}

}

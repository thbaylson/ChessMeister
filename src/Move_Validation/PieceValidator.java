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
 * @author Tyler 100% all
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
	 * @param from - The position of the piece to check
	 * @return An array of positions that are valid to move to
	 */
	public abstract Position[] showMoves(Position from);

	/**
	 * showMoves- To be used by subclasses. Checks if this validator is wrapped by another
	 * validator, and if so, collects the movement options from the outer validator and sends them
	 * back down to the inner validator.
	 * @param moves
	 * @param from
	 * @return
	 */
	public Position[] showMoves(Collection<Position> moves, Position from) {
		ArrayList<Position> newMoves = new ArrayList<Position>();
		Position[] allMoves = new Position[moves.size()];
		int player = (this.isWhite()) ? 1 : 2;

		/** If this validator is wrapped, we need to collect the moves of the wrapping validator**/
		if(this.getPieceValidator() != null) {
			Position[] moveArray = this.getPieceValidator().showMoves(from);
			for (int i = 0; i < moveArray.length; i++) {
				newMoves.add(moveArray[i]);
			}
		}

		/** Once we've gathered our movement options, cut out the ones that put us into check**/
		newMoves.addAll(moves);
		return newMoves.toArray(allMoves);
	}

	/**
	 * findKing- For any given, valid color and piece type, this will attempt to return that
	 * piece. If that piece is not on the board, this returns null.
	 * @param pieces: The pieces of a single person
	 * @param color: The color of the desired piece
	 * @return A piece on the board or null
	 */
	private PieceIF findKing(ArrayList<PieceIF> pieces, GameColor color){
		for(PieceIF p : pieces){
			if(p.getColor().equals(color) && p.getChessPieceType().equals(ChessPieceType.King)){
				return p;
			}
		}
		System.out.println("KING NOT FOUND. PANIC.");
		return null;
	}

	/**
	 * inRange- Ensures two given integers are within the range of the board array
	 *
	 * @param i- Relates to an integer spanning the width of the board
	 * @param j- Relates to an integer spanning the height of the board
	 * @return True if the given integers are within the range of the board array, otherwise false
	 **/
	boolean inRange(int i, int j) {
		return (0 <= i && i < this.board.getWidth()) && (0 <= j && j < this.board.getHeight());
	}

	/**
	 * Checks each move a piece can make to see if it puts the king in check
	 * @param moves - The list of moves to check
	 * @param piecePos - The position of the piece moving
	 * @return A list of valid moves
	 */
	public ArrayList<Position> checkForCheck(ArrayList<Position> moves, Position piecePos){
		int turn = 2;
		if(board.getTurn()){
			turn = 1;
		}
		ArrayList<Position> moveList = new ArrayList<>();
		for (Position move : moves){
			moveList.add(move);
		}
		for (Position pPos : moves) {
			int rank = piecePos.getRank().getRank();
			char file = piecePos.getFile().getFile();
			BoardIF newB = board.clone();
			Position newpPos = newB.getPosition(rank, file);
			Position endPos = newB.getPosition(pPos.getRank().getRank(), pPos.getFile().getFile());
			ArrayList<PieceIF> pieces = newB.getPlayerPieces(turn);
			newB.move(newpPos, endPos);
			for (PieceIF ePieces : pieces){
				for (Position ePos : ePieces.checkMoves()){
					int r1 = ePos.getRank().getRank();
					char f1 = ePos.getFile().getFile();
					int kr1 = newB.getCurKing().getPosition().getRank().getRank();
					char kf1 = newB.getCurKing().getPosition().getFile().getFile();
					if(r1 == kr1 && f1 == kf1) {
						moveList.remove(pPos);
					}
				}
			}
		}
		return moveList;
	}

	/**
	 * Checks the valid moves for a piece
	 * @param pos - The position of the piece
	 * @return A list of valid moves
	 */
	public abstract ArrayList<Position> checkMoves(Position pos);

	/**
	 * Clones this validator
	 *
	 * @param board - The game board
	 * @return Returns a clone of this validator using a new board
	 */
	public abstract PieceValidator clone(BoardIF board);
}

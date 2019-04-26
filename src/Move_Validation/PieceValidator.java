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
		int player = (this.isWhite()) ? 1 : 2;

		/** If this validator is wrapped, we need to collect the moves of the wrapping validator**/
		if(this.getPieceValidator() != null) {
			Position[] moveArray = this.getPieceValidator().showMoves(from);
			for (int i = 0; i < moveArray.length; i++) {
				newMoves.add(moveArray[i]);
			}
			newMoves.addAll(moves);

		}else{
			/**==============Recursion Base Case==================
			* Once we've gathered our movement options, cut out the ones that put us into check**/
			newMoves.addAll(moves);
			ArrayList<Position> removable = new ArrayList<Position>();
			for(Position to : newMoves){
				/** Calls ShowMoves, thus starts the recursion over from the top and leads to infinite recursion**/
				if(!checkSafe(from, to, player)){
					removable.add(to);
				}
			}
			newMoves.removeAll(removable);
		}
		

		Position[] allMoves = new Position[moves.size()];
		return newMoves.toArray(allMoves);
	}

	/**
	 * Will look at the current board state to ascertain if the given player is in check
	 * @return
	 */
	private boolean isChecked(PieceIF king, int player){
		PieceValidator old = king.getPieceValidator();
		GameColor myColor = (player == 1) ? GameColor.WHITE : GameColor.BLACK;

		//Check if the king is checked by an enemy rook
		king.changeValidator(new HortzVertzValidator(board));
		Position[] rookMoves = king.getPieceValidator().showMoves();
		for(Position p : rookMoves){
			System.out.println(p);
			if(p.getSquare().getPiece() != null){
				if(p.getSquare().getPiece().getChessPieceType() == ChessPieceType.Rook ||
						p.getSquare().getPiece().getChessPieceType() == ChessPieceType.Queen){
					if(p.getSquare().getPiece().getColor() != myColor){
						return true;
					}
				}
			}
		}
		//Check if the king is checked by an enemy bishop
		king.changeValidator(new DiagonalValidator(board));
		Position[] bishopMoves = king.getPieceValidator().showMoves();
		for(Position p : bishopMoves){
			if(p.getSquare().getPiece() != null){
				if(p.getSquare().getPiece().getChessPieceType() == ChessPieceType.Bishop ||
						p.getSquare().getPiece().getChessPieceType() == ChessPieceType.Queen){
					if(p.getSquare().getPiece().getColor() != myColor){
						return true;
					}
				}
			}
		}

		//Check if the king is checked by an enemy knight
		king.changeValidator(new KnightValidator(board));
		Position[] knightMoves = king.getPieceValidator().showMoves();
		for(Position p : knightMoves){
			System.out.println(p);
			if(p.getSquare().getPiece() != null){
				if(p.getSquare().getPiece().getChessPieceType() == ChessPieceType.Knight){
					if(p.getSquare().getPiece().getColor() != myColor){
						return true;
					}
				}
			}
		}
		//Check if the king is checked by an enemy pawn
		king.changeValidator(new PawnValidator(board));
		Position[] pawnMoves = king.getPieceValidator().showMoves();
		for(Position p : pawnMoves){
			if(p.getSquare().getPiece() != null){
				if(p.getSquare().getPiece().getChessPieceType() == ChessPieceType.Pawn){
					if(p.getSquare().getPiece().getColor() != myColor){
						return true;
					}
				}
			}
		}



		/** CALEB IS A GOD
		PieceIF king;
		int enemyNum;
		if(player == 1){
			king = findKing(board.getPlayerPieces(player), GameColor.WHITE);
			enemyNum = 2;
		}else{
			king = findKing(board.getPlayerPieces(player), GameColor.BLACK);
			enemyNum = 1;
		}
		for(PieceIF enemy : board.getPlayerPieces(enemyNum)) {
			for(Position option : enemy.showMoves()) {
				if(option.getSquare().getPiece() == king){
					System.out.println("Player " + player + "is in Check!");
					return true;
				}
			}
		}**/
		return false;
	}

	private boolean checkSafe(Position from, Position to, int player){
		boolean check = false;
		board.move(from, to);//Move the piece to that position to check if it's safe
		if(!isChecked(findKing(board.getPlayerPieces(player), player), player)){
			check = true;
		}
		board.move(to, from);//Move the piece back to its original position
		return check;
	}

	/**
	 * findKing- For any given, valid color and piece type, this will attempt to return that
	 * piece. If that piece is not on the board, this returns null.
	 * @param pieces: The pieces of a single person
	 * @param player:
	 * @return A piece on the board or null
	 */
	private PieceIF findKing(ArrayList<PieceIF> pieces, int player){
		GameColor color = (player == 1) ? GameColor.WHITE : GameColor.BLACK;
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

	public abstract PieceValidator clone(BoardIF board);

}

package Move_Validation;

/**
 * Move validator for pawns
 *
 * @author Dillon Ramsey
 * @version 1.0
 */

import Enums.Files;
import Enums.Rank;
import Interfaces.BoardIF;
import Interfaces.PieceIF;
import Interfaces.SquareIF;
import Model.Position;
import java.util.ArrayList;

public class PawnValidator extends PieceValidator{

	/**
	 * A linked list containing the valid positions for the selected
	 * pawn to move to
	 */
	ArrayList<Position> pos;
	/**A 2D array containing all the sqaure that make up the chess board*/
	SquareIF sq[][];

	/**
	 *Constructor for PawnValidator Decorator
	 *
	 * @param board - An instance of the board object
	 */
	public PawnValidator(BoardIF board) {
		super(board);
		pos = new ArrayList<>();
		sq = board.getSquares();
	}

	/**
	 * Method to check the moves available to the current pawn
	 *
	 * @param pPos - The position of the pawn currently selected
	 * @return send - An array containing the moves available to this pawn as position objects
	 */
	public Position[] showMoves(Position pPos) {

		pos = checkMoves(pPos);
		pos = super.checkForCheck(pos, pPos);

		/**An array containing the valid positions the pawn can move to*/
		Position[] send = new Position[pos.size()];

		//For loop to populate the valid positions array using the linked list
		for (int i = 0; i < pos.size(); i++){
			send[i] = pos.get(i);
		}

		return send;
	}

	@Override
	public ArrayList<Position> checkMoves(Position pPos) {
		/**The File position of the current piece*/
		Files f = pPos.getFile();
		/**The Rank position of the current piece*/
		Rank r = pPos.getRank();
		//Clears the linked list so that it can be re-populated
		pos.clear();

		/**The piece that is on the selected square*/
		PieceIF p = pPos.getSquare().getPiece();
		/**Boolean variable for if there is a piece ahead of the current piece*/
		Boolean check = CheckAhead(f, r, p);

		/*Checks the color, position and ahead of the piece to see if the pawn could
		move two spaces forwards
		*/
		if (p.getColor().getColor() == 'w' && r.getArrayp() == 1 && check){
			StartTwo(f, r, p);
		}else if (p.getColor().getColor() == 'b' && r.getArrayp() == 6 && check){
			StartTwo(f, r, p);
		}
		//Checks the diagonals of the pawn to see if it can take a piece
		CheckDiagonal(f, r, p);

		return pos;
	}

	/**
	 * A helper method that checks if a pawn can move two spaces forwards
	 *
	 * @param f - The file the pawn is currently at
	 * @param r - The rank the pawn is currently at
	 * @param curP - The piece currently being checked
	 */
	public void StartTwo(Files f, Rank r, PieceIF curP){
		/**A instance of the current square being worked with*/
		SquareIF curSquare;
		/*Checks the color of the current piece to determine the direction
		to look ahead at
		*/
		if (curP.getColor().getColor() == 'w'){
			curSquare = sq[f.getArrayp()][r.getArrayp()+2];
		}else{
			curSquare = sq[f.getArrayp()][r.getArrayp()-2];
		}
		/**The piece on the square two spaces ahead of the pawn*/
		PieceIF p = curSquare.getPiece();
		/*Checks if the piece is null and places it in the linked list if true
		*/
		if (p == null){
			pos.add(curSquare.getPosition());
		}else{
			return;
		}
	}

	/**
	 * A helper method to check if the pawn can move forwards one space
	 *
	 * @param f - The file the pawn is currently at
	 * @param r - The rank the pawn is currently at
	 * @param curP - The piece currently being checked
	 * @return Returs true if the piece can move forwards and false otherwise
	 */
	public Boolean CheckAhead(Files f, Rank r, PieceIF curP){
		/**A instance of the current square being worked with*/
		SquareIF curSquare;
		/*Checks the color of the current piece to determine the direction
		/to look ahead at
		*/
		if (curP.getColor().getColor() == 'w'){
			curSquare = sq[f.getArrayp()][r.getArrayp()+1];
		}else{
			curSquare = sq[f.getArrayp()][r.getArrayp()-1];
		}
		/**The piece on the square one space ahead of the pawn*/
		PieceIF p = curSquare.getPiece();
		/*Checks if there is a piece ahead of the pawn and adds the square to
		 the linked list if null
		*/
		if (p == null) {
			pos.add(curSquare.getPosition());
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Helper method to check if the pawn can take a piece diagonally
	 *
	 * @param f - The file the pawn is currently at
	 * @param r - The rank the pawn is currently at
	 * @param curP - The piece currently being checked
	 */
	public void CheckDiagonal(Files f, Rank r, PieceIF curP){
		/**A instance of the current square being worked with*/
		SquareIF curSquare;
		/**The piece currently being worked with*/
		PieceIF p;
		/*Checkes the color of the current piece and checks the diagonals
		from the piece to determine if there is a valid piece to take
		 */
		if (curP.getColor().getColor() == 'w'){
			if (!(f.getArrayp()-1 < 0)){
				curSquare = sq[f.getArrayp()-1][r.getArrayp()+1];
				p = curSquare.getPiece();
				if (p != null && p.getColor() != curP.getColor()){
					pos.add(curSquare.getPosition());
				}
			}
			if (!(f.getArrayp()+1 > 7)){
				curSquare = sq[f.getArrayp()+1][r.getArrayp()+1];
				p = curSquare.getPiece();
				if (p != null && p.getColor() != curP.getColor()){
					pos.add(curSquare.getPosition());
				}
			}
		}else{
			if (!(f.getArrayp()-1 < 0)){
				curSquare = sq[f.getArrayp()-1][r.getArrayp()-1];
				p = curSquare.getPiece();
				if (p != null && p.getColor() != curP.getColor()){
					pos.add(curSquare.getPosition());
				}
			}
			if (!(f.getArrayp()+1 > 7)){
				curSquare = sq[f.getArrayp()+1][r.getArrayp()-1];
				p = curSquare.getPiece();
				if (p != null && p.getColor() != curP.getColor()){
					pos.add(curSquare.getPosition());
				}
			}
		}
		return;
	}

	/**
	 * Clones this validator
	 *
	 * @param board - The game board
	 * @return Returns a clone of this validator using a new board
	 */
	public PawnValidator clone(BoardIF board){
		PawnValidator PV = new PawnValidator(board);
		return PV;
	}
}

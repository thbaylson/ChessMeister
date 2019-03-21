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
import java.util.LinkedList;

public class PawnValidator extends PieceValidator{

	LinkedList<Position> pos;
	SquareIF sq[][];

	/**
	 *Constructor for PawnValidator Decorator
	 *
	 * @param board - An instance of the board object
	 */
	public PawnValidator(BoardIF board) {
		super(board);
		pos = new LinkedList<>();
		sq = board.getSquares();
	}

	/**
	 * Method to check the moves available to the current pawn
	 *
	 * @param pPos - The position of the pawn currently selected
	 * @return send - An array containing the moves available to this pawn as position objects
	 */
	public Position[] showMoves(Position pPos) {
		Files f = pPos.getFile();
		Rank r = pPos.getRank();
		pos.clear();
		PieceIF p = pPos.getSquare().getPiece();
		Boolean check = CheckAhead(f, r, p);
		if (p.getColor().getColor() == 'w' && r.getArrayp() == 1 && check){
			StartTwo(f, r, p);
		}else if (p.getColor().getColor() == 'b' && r.getArrayp() == 6 && check){
			StartTwo(f, r, p);
		}
		CheckDiagonal(f, r, p);
		Position[] send = new Position[pos.size()];
		for (int i = 0; i < pos.size(); i++){
			send[i] = pos.get(i);
		}
		return send;
	}

	/**
	 * A helper method that checks if a pawn can move two spaces forwards
	 *
	 * @param f - The file the pawn is currently at
	 * @param r - The rank the pawn is currently at
	 * @param curP - The piece currently being checked
	 */
	public void StartTwo(Files f, Rank r, PieceIF curP){
		SquareIF curSquare;
		if (curP.getColor().getColor() == 'w'){
			curSquare = sq[f.getArrayp()][r.getArrayp()+2];
		}else{
			curSquare = sq[f.getArrayp()][r.getArrayp()-2];
		}
		PieceIF p = curSquare.getPiece();
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
		SquareIF curSquare;
		if (curP.getColor().getColor() == 'w'){
			curSquare = sq[f.getArrayp()][r.getArrayp()+1];
		}else{
			curSquare = sq[f.getArrayp()][r.getArrayp()-1];
		}
		PieceIF p = curSquare.getPiece();
		if (p == null){
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
		SquareIF curSquare;
		PieceIF p;
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
}

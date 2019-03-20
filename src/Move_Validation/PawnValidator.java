package Move_Validation;

import Enums.Files;
import Enums.GameColor;
import Enums.Rank;
import Interfaces.BoardIF;
import Interfaces.PieceIF;
import Interfaces.SquareIF;
import Model.Position;
import Model.Square;

import java.util.ArrayList;
import java.util.LinkedList;

public class PawnValidator extends PieceValidator{

	LinkedList<Position> pos;
	SquareIF sq[][];

	public PawnValidator(BoardIF board) {
		super(board);
		pos = new LinkedList<>();
		sq = board.getSquares();
	}

	public Position[] showMoves(Position pPos) {
		Files f = pPos.getFile();
		Rank r = pPos.getRank();
		
		System.out.println(pPos.getSquare());
		
		PieceIF p = pPos.getSquare().getPiece();
		Boolean check = CheckAhead(f, r, p);;
		if (p.getColor().getColor() == 'w' && f.getArrayp() == 1 && check){
			StartTwo(f, r, p);
		}else if (p.getColor().getColor() == 'b' && f.getArrayp() == 6 && check){
			StartTwo(f, r, p);
		}
		CheckDiagonal(f, r, p);
		return (Position[])pos.toArray();
	}

	public void StartTwo(Files f, Rank r, PieceIF curP){
		SquareIF curSquare;
		if (curP.getColor().getColor() == 'w'){
			curSquare = sq[f.getArrayp()][r.getArrayp()+2];
		}else{
			curSquare = sq[f.getArrayp()][r.getArrayp()-2];
		}
		PieceIF p = curSquare.getPiece();
		if (p != null){
			pos.add(curSquare.getPosition());
		}else{
		}
	}

	public Boolean CheckAhead(Files f, Rank r, PieceIF curP){
		SquareIF curSquare;
		if (curP.getColor().getColor() == 'w'){
			curSquare = sq[f.getArrayp()][r.getArrayp()+1];
		}else{
			curSquare = sq[f.getArrayp()][r.getArrayp()-1];
		}
		PieceIF p = curSquare.getPiece();
		if (p != null){
			pos.add(curSquare.getPosition());
			return true;
		}else{
			return false;
		}
	}

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

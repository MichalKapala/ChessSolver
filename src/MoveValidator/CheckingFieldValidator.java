package MoveValidator;

import Pieces.Piece;
import edu.uj.po.interfaces.Move;
import Board.Board;
import Board.Field;
import edu.uj.po.interfaces.Color;
public class CheckingFieldValidator extends MoveValidatorChain {
    public CheckingFieldValidator(MoveValidator nextValidator, Board board) {
        super(nextValidator, board);
    }



    public boolean validateMove(Move move) {

        if (validateField(move) && nextValidator != null) {
            return nextValidator.validateMove(move);
        } else if (validateField(move) && nextValidator == null) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean validateField(Move move) {
        Piece initialPiece = board.GetFieldByPosition(move.initialPosition()).GetPiece();
        Piece finalPiece = board.GetFieldByPosition(move.finalPosition()).GetPiece();
        
        if(finalPiece == null || initialPiece.GetColor() != finalPiece.GetColor())
        {
            return true;
        }

        return false;
        
    }
}
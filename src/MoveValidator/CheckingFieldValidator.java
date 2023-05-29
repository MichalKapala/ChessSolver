package MoveValidator;

import Pieces.Piece;
import edu.uj.po.interfaces.Move;
import Board.IBoard;
;
public class CheckingFieldValidator extends MoveValidatorChain {
    public CheckingFieldValidator(MoveValidator nextValidator, IBoard board) {
        super(nextValidator, board);
    }

    public boolean validateMove(Move move) {

        if (validateField(move) && nextValidator != null) {
            return nextValidator.validateMove(move);
        } else return validateField(move) && nextValidator == null;
    }
    
    private boolean validateField(Move move) {
        Piece initialPiece = board.getFieldByPosition(move.initialPosition()).getPiece();
        Piece finalPiece = board.getFieldByPosition(move.finalPosition()).getPiece();

        return finalPiece == null || initialPiece.getColor() != finalPiece.getColor();

    }
}
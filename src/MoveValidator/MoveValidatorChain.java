package MoveValidator;

import edu.uj.po.interfaces.Move;
import Board.Board;

public abstract class MoveValidatorChain implements MoveValidator {
    protected MoveValidator nextValidator;
    protected Board board;

    public MoveValidatorChain(MoveValidator nextValidator, Board board) {
        this.nextValidator = nextValidator;
        this.board = board;
    }

    public boolean validateMove(Move move) {
        if (nextValidator != null) {
            return nextValidator.validateMove(move);
        }
        return true;
    }
}

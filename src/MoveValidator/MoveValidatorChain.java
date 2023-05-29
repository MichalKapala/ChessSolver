package MoveValidator;

import edu.uj.po.interfaces.Move;
import Board.IBoard;

public abstract class MoveValidatorChain implements MoveValidator {
    protected MoveValidator nextValidator;
    protected IBoard board;

    public MoveValidatorChain(MoveValidator nextValidator, IBoard board) {
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

package MoveValidator;

import Board.IBoard;
import WinningStrategy.Judge;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import Move.MoveCommand;
import Move.Command;
import Board.Field;
public class CheckingKingSafetyValidator extends MoveValidatorChain {
    public CheckingKingSafetyValidator(MoveValidator nextValidator, IBoard board) {
        super(nextValidator, board);
    }

    public boolean validateMove(Move move) {

    boolean isKingSafe = validateKingSafety(move);
        if (isKingSafe && nextValidator != null) {
            return nextValidator.validateMove(move);
        }else return isKingSafe;
    }

    private boolean validateKingSafety(Move move) {
        Field initalField = board.getFieldByPosition(move.initialPosition());
        Color currentColor = initalField.getPiece().getColor();

        Command moveCommand = new MoveCommand(board, move);
        moveCommand.execute();
        Judge judge = new Judge(board);
        boolean isChecked = judge.isColorUnderCheck(currentColor);
        moveCommand.undo();

        return !isChecked;
    }
}
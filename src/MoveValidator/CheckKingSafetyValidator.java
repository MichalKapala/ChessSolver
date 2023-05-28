package MoveValidator;

import Board.Board;
import WinningStrategy.Judge;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import Move.MoveCommand;
import Move.Command;
import Board.Field;
public class CheckKingSafetyValidator extends MoveValidatorChain {
    public CheckKingSafetyValidator(MoveValidator nextValidator, Board board) {
        super(nextValidator, board);
    }

    public boolean validateMove(Move move) {

    boolean isKingSafe = validateKingSafety(move);
        if (isKingSafe && nextValidator != null) {
            return nextValidator.validateMove(move);
        }else if (!isKingSafe) {
            return false;
        }

        return true;
    }

    private boolean validateKingSafety(Move move) {
        Field initalField = board.GetFieldByPosition(move.initialPosition());
        Color currentColor = initalField.GetPiece().GetColor();

        Command moveCommand = new MoveCommand(board, move);
        moveCommand.execute();
        Judge judge = new Judge(board);
        boolean isChecked = judge.IsColorUnderCheck(currentColor);
        moveCommand.undo();

        return !isChecked;
    }
}
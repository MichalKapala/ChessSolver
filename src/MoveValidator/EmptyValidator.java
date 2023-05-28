package MoveValidator;

import edu.uj.po.interfaces.Move;
public class EmptyValidator extends MoveValidatorChain {
    public EmptyValidator(MoveValidator nextValidator) {
        super( nextValidator, null);
    }

    public boolean validateMove(Move move) {
        if (nextValidator != null) {
            return nextValidator.validateMove(move);
        }

        return true;
    }
}

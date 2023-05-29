package MoveValidator;

import edu.uj.po.interfaces.Move;
public class EmptyValidator extends MoveValidatorChain {
    public EmptyValidator(MoveValidator nextValidator) {
        super( nextValidator, null);
    }

}

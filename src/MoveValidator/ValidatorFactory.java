package MoveValidator;


import Pieces.Piece;

public interface ValidatorFactory {

    public MoveValidator getValidator(Piece piece);
}

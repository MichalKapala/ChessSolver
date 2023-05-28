package MoveValidator;


import Pieces.Piece;

public interface ValidatorFactory {

    public MoveValidator GetValidator(Piece piece);
}

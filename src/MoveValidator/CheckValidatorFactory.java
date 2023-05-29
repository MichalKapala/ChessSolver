package MoveValidator;

import Board.IBoard;
import Pieces.*;

public class CheckValidatorFactory implements ValidatorFactory
{
    private final IBoard board;

    public CheckValidatorFactory(IBoard board)
    {
        this.board = board;
    }

    @Override
    public MoveValidator getValidator(Piece piece) {
        if(piece instanceof King ||piece instanceof Queen || piece instanceof Bishop || piece instanceof Rook) {
            return new CheckingObstructionValidator( new CheckingFieldValidator(null, board), board);
        }else if(piece instanceof Pawn)
        {
            return new CheckingObstructionValidator(new CheckingPawnWeirdMoves(new CheckingFieldValidator(null, board), board), board);
        }else if(piece instanceof Knight) {
            return new EmptyValidator(new CheckingFieldValidator(null, board));
        }else{
            throw new IllegalArgumentException("Unknown piece: " + piece);
        }
    }
}

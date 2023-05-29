package MoveValidator;

import Board.IBoard;
import Pieces.*;

public class StandardValidatorFactory implements ValidatorFactory
{
    private final IBoard board;

    public StandardValidatorFactory(IBoard board)
    {
        this.board = board;
    }
    @Override
    public MoveValidator getValidator(Piece piece) {
        if(piece instanceof King ||piece instanceof Queen || piece instanceof Bishop || piece instanceof Rook)
        {
            return new CheckingFieldValidator(new CheckingObstructionValidator(new CheckingKingSafetyValidator(null, board), board), board);
        }else if(piece instanceof Knight) {
            return new CheckingFieldValidator(new CheckingKingSafetyValidator(null, board), board);
        }else if(piece instanceof Pawn)
        {
            return new CheckingObstructionValidator(new CheckingKingSafetyValidator(new CheckingPawnWeirdMoves(null, board), board), board);
        } else{
            throw new IllegalArgumentException("Unknown piece: " + piece);
        }
    }
}

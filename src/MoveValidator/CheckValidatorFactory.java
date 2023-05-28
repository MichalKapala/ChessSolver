package MoveValidator;

import Board.Board;
import Pieces.*;

public class CheckValidatorFactory implements ValidatorFactory
{
    private Board board;

    public CheckValidatorFactory(Board board)
    {
        this.board = board;
    }

    // Validator will return moves needed to check if sombeody atacks the king
    @Override
    public MoveValidator GetValidator(Piece piece) {
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

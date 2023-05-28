package MoveValidator;

import Board.Board;
import Pieces.*;

public class StandardValidatorFactory implements ValidatorFactory
{
    private Board board;

    public StandardValidatorFactory(Board board)
    {
        this.board = board;
    }
    @Override
    public MoveValidator GetValidator(Piece piece) {
        if(piece instanceof King ||piece instanceof Queen || piece instanceof Bishop || piece instanceof Rook)
        {
            return new CheckingFieldValidator(new CheckingObstructionValidator(new CheckKingSafetyValidator(null, board), board), board);
        }else if(piece instanceof Knight) {
            return new CheckingFieldValidator(new CheckKingSafetyValidator(null, board), board);
        }else if(piece instanceof Pawn)
        {
            return new CheckingObstructionValidator(new CheckKingSafetyValidator(new CheckingPawnWeirdMoves(null, board), board), board);
        } else{
            throw new IllegalArgumentException("Unknown piece: " + piece);
        }
    }
}

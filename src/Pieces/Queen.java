package Pieces;

import MoveValidator.MoveValidator;
import MovesGenerator.MovesGeneratorImpl;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import MoveValidator.ValidatorFactory;
import java.util.List;
import java.util.stream.Collectors;

public class Queen extends BasePiece{
    public Queen(Position position, Color color) {
        super(position, color);
    }


    @Override
    public List<Move> GetLegalMoves(ValidatorFactory validator) {
        List<Move> allMoves = MovesGeneratorImpl.GenerateStraightMoves(currentPosition);
        allMoves.addAll(MovesGeneratorImpl.GenerateDiagonalMoves(currentPosition));
        allMoves = allMoves.stream().filter(validator.GetValidator(this)::validateMove).collect(Collectors.toList());

        return allMoves;
    }

}

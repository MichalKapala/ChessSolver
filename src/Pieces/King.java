package Pieces;

import MoveValidator.MoveValidator;
import MovesGenerator.MovesFilter;
import MovesGenerator.MovesGeneratorImpl;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import MoveValidator.ValidatorFactory;
public class King extends BasePiece{
    public King(Position position, Color color) {
        super(position, color);
    }


    @Override
    public List<Move> GetLegalMoves(ValidatorFactory validator) {
        List<Move> allMoves = MovesGeneratorImpl.GenerateStraightMoves(currentPosition);
        allMoves.addAll(MovesGeneratorImpl.GenerateDiagonalMoves(currentPosition));
        allMoves = MovesFilter.KingRangeFilter(allMoves);
        allMoves = allMoves.stream().filter(validator.GetValidator(this)::validateMove).collect(Collectors.toList());

        return allMoves;
    }


}

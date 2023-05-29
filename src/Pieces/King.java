package Pieces;

import MovesGenerator.MovesFilter;
import MovesGenerator.MovesGenerator;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;

import java.util.List;
import java.util.stream.Collectors;
import MoveValidator.ValidatorFactory;
public class King extends BasePiece{
    public King(Position position, Color color) {
        super(position, color);
    }

    @Override
    public List<Move> getLegalMoves(ValidatorFactory validator) {
        List<Move> allMoves = MovesGenerator.generateStraightMoves(currentPosition);
        allMoves.addAll(MovesGenerator.generateDiagonalMoves(currentPosition));
        allMoves = MovesFilter.kingRangeFilter(allMoves);
        allMoves = allMoves.stream().filter(validator.getValidator(this)::validateMove).collect(Collectors.toList());

        return allMoves;
    }


}

package Pieces;

import MovesGenerator.MovesGenerator;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import MoveValidator.ValidatorFactory;
import java.util.List;
import java.util.stream.Collectors;

public class Rook extends BasePiece{
    public Rook(Position position, Color color) {
        super(position, color);
    }

    @Override
    public List<Move> getLegalMoves(ValidatorFactory validator) {
        List<Move> allMoves = MovesGenerator.generateStraightMoves(currentPosition);
        allMoves = allMoves.stream().filter(validator.getValidator(this)::validateMove).collect(Collectors.toList());

        return allMoves;
    }
}

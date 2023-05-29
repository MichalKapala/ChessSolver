package Pieces;

import MovesGenerator.MovesGenerator;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;

import java.util.List;
import java.util.stream.Collectors;
import MoveValidator.ValidatorFactory;

public class Bishop extends BasePiece{
    public Bishop(Position position, Color color) {
        super(position, color);
    }

    @Override
    public List<Move> getLegalMoves(ValidatorFactory validator) {
        List<Move> allMoves = MovesGenerator.generateDiagonalMoves(currentPosition);
        allMoves = allMoves.stream().filter(validator.getValidator(this)::validateMove).collect(Collectors.toList());

        return allMoves;
    }

}

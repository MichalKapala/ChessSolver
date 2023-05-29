package Pieces;

import MoveValidator.ValidatorFactory;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;

import java.util.List;

public interface Piece {
    public void setPosition(Position position);

    public Position getPosition();
    public Color getColor();

    public List<Move> getLegalMoves(ValidatorFactory validator);

}

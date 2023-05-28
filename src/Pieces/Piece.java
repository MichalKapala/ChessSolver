package Pieces;

import MoveValidator.MoveValidator;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import MoveValidator.ValidatorFactory;
import java.util.List;

public interface Piece {
    public void SetPosition(Position position);

    public Position GetPosition();
    public Color GetColor();

    public List<Move> GetLegalMoves(ValidatorFactory validator);

}

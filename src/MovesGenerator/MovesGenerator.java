package MovesGenerator;

import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;

import java.util.List;

public interface MovesGenerator {
    public List<Move> GenerateDiagonalMoves(Position position);
    public List<Move> GenerateStraightMoves(Position position);
    public List<Move> GenerateLMoves(Position position);

}

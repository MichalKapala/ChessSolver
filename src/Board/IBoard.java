package Board;
import Move.MovesHistory;
import edu.uj.po.interfaces.Position;

import java.util.List;

public interface IBoard {

    public List<Field> getFields();
    public Field getFieldByPosition(Position position);

    public MovesHistory getMovesHistory();
}

package Board;

import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;
import Move.MovesHistory;
import java.util.ArrayList;
import java.util.List;


public class Board implements IBoard {
    private final List<Field> fields = new ArrayList(64);
    MovesHistory movesHistory = new MovesHistory();

    public Board()
    {
        Rank[] ranks = Rank.values();
        File[] files = File.values();

        for (File file : files) {
            for (Rank rank : ranks) {
                fields.add(new Field(new Position(file, rank)));
            }
        }
    }
    @Override
    public Field getFieldByPosition(Position position) {
        return fields.stream().filter(item -> item.getPosition().equals(position)).findFirst().get();
    }

    @Override
    public List<Field> getFields() {
        return fields;
    }

    @Override
    public MovesHistory getMovesHistory() {
        return movesHistory;
    }

}

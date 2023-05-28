package Board;

import Pieces.Piece;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;
import edu.uj.po.interfaces.Move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Board implements IBoard {
    private List<Field> fields = new ArrayList(64);
    public List<Move> moveHistory = new ArrayList<>();

    public Board()
    {
        List<Rank> ranks = Arrays.asList(Rank.values());
        List<File> files = Arrays.asList(File.values());

        for (File file : files) {
            for (Rank rank : ranks) {
                fields.add(new Field(new Position(file, rank)));
            }
        }
    }
    @Override
    public Field GetFieldByPosition(Position position) {
        return fields.stream().filter(item -> item.GetPosition().equals(position)).findFirst().get();
    }

    @Override
    public void SetFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public BoardMemento createMemento() {
        return null;
    }

    @Override
    public void restoreFromMemento(BoardMemento memento) {

    }
    @Override
    public List<Field> GetFields() {
        return fields;
    }

}

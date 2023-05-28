package Board;

import Pieces.Piece;
import edu.uj.po.interfaces.Position;

import java.util.List;

public interface IBoard {

    public List<Field> GetFields();
    public Field GetFieldByPosition(Position position);

    public void SetFields(List<Field> fields);

    public BoardMemento createMemento();

    public void restoreFromMemento(BoardMemento memento);

}

package Board;

import java.util.ArrayList;
import java.util.List;

class BoardMemento {
    private List<Field> fields;

    public BoardMemento(List<Field> fields) {
        this.fields = fields;
    }

    public List<Field>  getPieces() {
        return fields;
    }
}
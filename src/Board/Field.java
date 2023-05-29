package Board;

import Pieces.Piece;
import edu.uj.po.interfaces.Position;

public class Field {

    final private Position position;
    private Piece currentPiece = null;
    public Field (Position position)
    {
        this.position = position;
    }

    public void setPiece(Piece piece)
    {
        currentPiece = piece;
        if(piece != null)
        {
            currentPiece.setPosition(position);
        }
    }

    public Position getPosition() {
        return position;
    }
    public Piece getPiece() {
        return currentPiece;
    }

}

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

    public void SetPiece(Piece piece)
    {
        currentPiece = piece;

        if(piece != null)
        {
            currentPiece.SetPosition(position);
        }

    }

    public Position GetPosition() {
        return position;
    }
    public Piece GetPiece() {
        return currentPiece;
    }

}

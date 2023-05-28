package Board;

import Pieces.King;
import Pieces.Piece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

import java.util.ArrayList;
import java.util.List;

public class PieceGetter {

    private Board board;

    public PieceGetter(Board board)
    {
        this.board = board;
    }

    public List<Piece> GetAllPiecesByColor(Color color)
    {
        List<Piece> colorPieces = new ArrayList<>();
        List<Field> allFields = board.GetFields();

        for(var field : allFields)
        {
            Piece piece = field.GetPiece();
            if(piece != null && piece.GetColor() == color)
            {
                colorPieces.add(field.GetPiece());
            }
        }

        return colorPieces;
    }

    public Position GetKingPosition(Color color) {
        List<Field> allFields = board.GetFields();
        for(var field : allFields)
        {
            Piece piece = field.GetPiece();
            if(piece != null && piece.GetColor() == color && piece instanceof King)
            {
                return field.GetPosition();
            }
        }
        return null;
    }


}

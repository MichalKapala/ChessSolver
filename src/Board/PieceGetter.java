package Board;

import Pieces.King;
import Pieces.Piece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

import java.util.ArrayList;
import java.util.List;

public class PieceGetter {

    private final IBoard board;

    public PieceGetter(IBoard board)
    {
        this.board = board;
    }

    public List<Piece> getAllPiecesByColor(Color color)
    {
        List<Piece> colorPieces = new ArrayList<>();

        for(Field field : board.getFields())
        {
            Piece piece = field.getPiece();
            if(piece != null && piece.getColor() == color)
            {
                colorPieces.add(field.getPiece());
            }
        }

        return colorPieces;
    }

    public Position getKingPosition(Color color) {
        List<Field> allFields = board.getFields();
        for(Field field : allFields)
        {
            Piece piece = field.getPiece();
            if(piece != null && piece.getColor() == color && piece instanceof King)
            {
                return field.getPosition();
            }
        }
        return null;
    }

    public Piece getKing(Color color) {
        List<Field> allFields = board.getFields();
        for(Field field : allFields)
        {
            Piece piece = field.getPiece();
            if(piece != null && piece.getColor() == color && piece instanceof King)
            {
                return piece;
            }
        }
        return null;
    }


}

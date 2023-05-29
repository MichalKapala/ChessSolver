package Pieces;

import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

public class PieceFactory {
    public static Piece CreatePiece(ChessPiece piece, Position position, Color color)
    {
        return switch (piece) {
            case BISHOP -> new Bishop(position, color);
            case KING -> new King(position, color);
            case KNIGHT -> new Knight(position, color);
            case PAWN -> new Pawn(position, color);
            case QUEEN -> new Queen(position, color);
            case ROOK -> new Rook(position, color);
            default -> throw new IllegalArgumentException("Unknown chess piece: " + piece);
        };

    }
}

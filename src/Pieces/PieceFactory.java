package Pieces;

import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

public class PieceFactory {
    public static Piece CreatePiece(ChessPiece piece, Position position, Color color)
    {
        switch(piece) {
            case BISHOP:
                return new Bishop(position, color);
            case KING:
                return new King(position, color);
            case KNIGHT:
                return new Knight(position, color);
            case PAWN:
                return new Pawn(position, color);
            case QUEEN:
                return new Queen(position, color);
            case ROOK:
                return new Rook(position, color);
            default:
                throw new IllegalArgumentException("Unknown chess piece: " + piece);
        }

    }
}

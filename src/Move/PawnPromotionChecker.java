package Move;

import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

import javax.swing.*;

public class PawnPromotionChecker  {

    public static boolean CheckForPromotion(Piece piece, Position finalPosition) {

            return piece instanceof Pawn && ((piece.GetColor() == Color.WHITE && finalPosition.rank() == Rank.EIGHTH) ||
                    (piece.GetColor() == Color.BLACK && finalPosition.rank() == Rank.FIRST));
    }

    public static void PromotePiece(Piece piece) {
        piece = new Queen(piece.GetPosition(), piece.GetColor());
    }

    public static void DemotePiece(Piece piece) {
        piece = new Pawn(piece.GetPosition(), piece.GetColor());
    }
}

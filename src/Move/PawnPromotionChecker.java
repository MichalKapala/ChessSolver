package Move;

import Pieces.Pawn;
import Pieces.Piece;;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

public class PawnPromotionChecker  {

    public static boolean checkForPromotion(Piece piece, Position finalPosition) {
            return piece instanceof Pawn && ((piece.getColor() == Color.WHITE && finalPosition.rank() == Rank.EIGHTH) ||
                    (piece.getColor() == Color.BLACK && finalPosition.rank() == Rank.FIRST));
    }
}

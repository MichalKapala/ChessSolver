package MovesGenerator;

import java.util.ArrayList;
import java.util.List;
import Utils.Vector2D;
import edu.uj.po.interfaces.Move;

public class MovesFilter {
    public static List<Move> kingRangeFilter(List<Move> moves)
    {
        final int maxXKingRange = 1;
        final int maxYKingRange = 1;
        List<Move> legalMoves = new ArrayList<>();

        for(Move move : moves)
        {
            Vector2D moveVector =  new Vector2D(Math.abs(move.initialPosition().file().ordinal() - move.finalPosition().file().ordinal()),
                    Math.abs(move.initialPosition().rank().ordinal() - move.finalPosition().rank().ordinal()));
            if(moveVector.x <= maxXKingRange && moveVector.y <= maxYKingRange)
            {
                legalMoves.add(move);
            }
        }
        return legalMoves;
    }
}

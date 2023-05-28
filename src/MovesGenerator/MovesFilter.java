package MovesGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Utils.Vector2D;
import edu.uj.po.interfaces.Move;
public class MovesFilter {
    public static List<Move> KingRangeFilter(List<Move> moves)
    {
        List<Move> legalMoves = new ArrayList<>();

        for(Move move : moves)
        {
            Vector2D moveVector =  new Vector2D(Math.abs(move.initialPosition().file().ordinal() - move.finalPosition().file().ordinal()),
                    Math.abs(move.initialPosition().rank().ordinal() - move.finalPosition().rank().ordinal()));
            if(moveVector.x <= 1 && moveVector.y <= 1)
            {
                legalMoves.add(move);
            }
        }

        return legalMoves;
    }
}

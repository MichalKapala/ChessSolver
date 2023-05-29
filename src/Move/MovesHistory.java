package Move;

import edu.uj.po.interfaces.Move;

import java.util.ArrayList;
import java.util.List;

public class MovesHistory {
    private final List<Move> moveHistory = new ArrayList<>();

    List<Move> getMoveHistory() {
        return moveHistory;
    }

    public Move popLastMove() {
        Move lastMove = moveHistory.get(moveHistory.size() - 1);
        moveHistory.remove(moveHistory.size() - 1);
        return lastMove;
    }
    public Move getLastMove() {
        return moveHistory.get(moveHistory.size() - 1);
    }

    public void addMove(Move move) {
        moveHistory.add(move);
    }
    public boolean isEmpty() {
        return moveHistory.isEmpty();
    }
}

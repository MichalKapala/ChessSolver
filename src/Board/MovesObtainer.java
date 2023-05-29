package Board;

import MoveValidator.ValidatorFactory;
import Pieces.Piece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;

import java.util.ArrayList;
import java.util.List;

public class MovesObtainer {

    private final IBoard board;
    private final ValidatorFactory validatorFactory;

    public MovesObtainer(IBoard board, ValidatorFactory validatorFactory) {
        this.board = board;
        this.validatorFactory = validatorFactory;
    }
    public List<Move> getMovesByColor(Color color) {
        PieceGetter pieceGetter = new PieceGetter(board);
        List<Move> allPossibleMoves = new ArrayList<>();
        List<Piece> pieces = pieceGetter.getAllPiecesByColor(color);

        for (Piece piece : pieces) {
            allPossibleMoves.addAll(piece.getLegalMoves(validatorFactory));
        }

        return allPossibleMoves;
    }
}

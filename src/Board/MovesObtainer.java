package Board;

import MoveValidator.StandardValidatorFactory;
import MoveValidator.ValidatorFactory;
import Pieces.Piece;
import Utils.ChessBoardPrinter;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import Board.PieceGetter;

import java.util.ArrayList;
import java.util.List;

public class MovesObtainer {

    private Board board;
    private ValidatorFactory validatorFactory;

    public MovesObtainer(Board board, ValidatorFactory validatorFactory) {
        this.board = board;
        this.validatorFactory = validatorFactory;
    }
    public List<Move> GetMovesByColor(Color color) {
        PieceGetter pieceGetter = new PieceGetter(board);
        List<Move> allPossibleMoves = new ArrayList<>();
        List<Piece> firstColorPieces = pieceGetter.GetAllPiecesByColor(color);

        for (Piece piece : firstColorPieces) {
            allPossibleMoves.addAll(piece.GetLegalMoves(validatorFactory));
        }

        return allPossibleMoves;
    }
}

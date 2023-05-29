package Move;

import Board.IBoard;
import Pieces.Pawn;
import Pieces.Queen;
import Pieces.Piece;
import edu.uj.po.interfaces.Move;
import Board.Field;

public class MoveCommand implements Command {
    private final IBoard board;
    private final Move moveForward;
    private Piece initialPiece;
    private final Piece finalPiece;
    private boolean werePiecePromoted = false;

    public MoveCommand(IBoard board, Move move)
    {
        this.board = board;
        this.moveForward = move;
        this.initialPiece = board.getFieldByPosition(move.initialPosition()).getPiece();
        this.finalPiece = board.getFieldByPosition(move.finalPosition()).getPiece();
    }
    @Override
    public void execute() {
        Field initialField = board.getFieldByPosition(moveForward.initialPosition());
        Field targetField = board.getFieldByPosition(moveForward.finalPosition());

        promotePawn(targetField);
        board.getMovesHistory().addMove(moveForward);
        targetField.setPiece(initialPiece);
        initialField.setPiece(null);
    }

    @Override
    public void undo() {
        Field initialField = board.getFieldByPosition(moveForward.finalPosition());
        Field targetField = board.getFieldByPosition(moveForward.initialPosition());

        demotePawn(initialField, targetField);
        board.getMovesHistory().popLastMove();
        targetField.setPiece(initialPiece);
        initialField.setPiece(finalPiece);
    }

    private void promotePawn(Field targetField)
    {
        if(PawnPromotionChecker.checkForPromotion(initialPiece, targetField.getPosition()))
        {
            initialPiece = new Queen(initialPiece.getPosition(), initialPiece.getColor());
            werePiecePromoted = true;
        }
    }

    private void demotePawn(Field initialField, Field targetField)
    {
        if(werePiecePromoted)
        {
            initialPiece = new Pawn(initialPiece.getPosition(), initialPiece.getColor());
        }
    }
}

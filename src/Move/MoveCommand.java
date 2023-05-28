package Move;

import Board.Board;
import Pieces.Pawn;
import Pieces.Queen;
import edu.uj.po.interfaces.Move;
import Board.Field;
import Pieces.Piece;

public class MoveCommand implements Command {
    private Board board;
    private final Move moveForward;
    private Piece initialPiece;
    private Piece finalPiece;
    private boolean werePiecePromoted = false;

    public MoveCommand(Board board, Move move)
    {
        this.board = board;
        this.moveForward = move;
        this.initialPiece = board.GetFieldByPosition(move.initialPosition()).GetPiece();
        this.finalPiece = board.GetFieldByPosition(move.finalPosition()).GetPiece();
    }
    @Override
    public void execute() {
        Field initialField = board.GetFieldByPosition(moveForward.initialPosition());
        Field targetField = board.GetFieldByPosition(moveForward.finalPosition());

        if(PawnPromotionChecker.CheckForPromotion(initialPiece, targetField.GetPosition()))
        {
            initialPiece = new Queen(initialPiece.GetPosition(), initialPiece.GetColor());
            werePiecePromoted = true;
        }
        board.moveHistory.add(moveForward);
        targetField.SetPiece(initialPiece);
        initialField.SetPiece(null);
    }

    @Override
    public void undo() {
        Field initialField = board.GetFieldByPosition(moveForward.finalPosition());
        Field targetField = board.GetFieldByPosition(moveForward.initialPosition());

        if(werePiecePromoted)
        {
            initialPiece = new Pawn(initialPiece.GetPosition(), initialPiece.GetColor());
        }

        board.moveHistory.remove(moveForward);
        targetField.SetPiece(initialPiece);
        initialField.SetPiece(finalPiece);
    }
}

package MoveValidator;

import Pieces.Pawn;
import Pieces.Piece;
import Utils.Vector2D;
import edu.uj.po.interfaces.*;
import Board.IBoard;

public class CheckingPawnWeirdMoves extends MoveValidatorChain {
    public CheckingPawnWeirdMoves(MoveValidator nextValidator, IBoard board) {
        super(nextValidator, board);
    }

    public boolean validateMove(Move move) {

        if (validateField(move) && nextValidator != null) {
            return nextValidator.validateMove(move);
        } else return validateField(move) && nextValidator == null;
    }

    private boolean validateField(Move move) {
        Piece initialPiece = board.getFieldByPosition(move.initialPosition()).getPiece();
        Piece finalPiece = board.getFieldByPosition(move.finalPosition()).getPiece();
        Vector2D moveVector = new Vector2D(move.initialPosition(), move.finalPosition()).getAbsVector();

        if(moveVector.x == 1 && moveVector.y == 1 )
        {
            if(checkEnPassant(move))
            {
                return true;
            }else return finalPiece != null && initialPiece.getColor() != finalPiece.getColor();


        }else if(moveVector.x == 0 && moveVector.y == 2)
        {
            if(initialPiece.getColor() == Color.WHITE && initialPiece.getPosition().rank() != Rank.SECOND ||
               initialPiece.getColor() == Color.BLACK && initialPiece.getPosition().rank() != Rank.SEVENTH) {
                return false;
            }else return finalPiece == null;
        }else if(moveVector.x == 0 && moveVector.y == 1)
        {
            return finalPiece == null;
        }

        return true;

    }

    private boolean checkEnPassant(Move move)
    {
            Vector2D moveVector = new Vector2D(move.initialPosition(), move.finalPosition());
            Position pawnPosition = move.initialPosition();
            Color moveColor = board.getFieldByPosition(move.initialPosition()).getPiece().getColor();

            Position neighbourPosition = new Position(File.values()[pawnPosition.file().ordinal() + moveVector.x], pawnPosition.rank());
            Piece neighbourPiece = board.getFieldByPosition(neighbourPosition).getPiece();

            if(neighbourPiece instanceof Pawn && neighbourPiece.getColor() != moveColor && !board.getMovesHistory().isEmpty())
            {
                Move lastMove = board.getMovesHistory().getLastMove();
                Vector2D lastMoveVector = new Vector2D(lastMove.initialPosition(), lastMove.finalPosition()).getAbsVector();

                return lastMove.finalPosition().equals(neighbourPosition) && lastMoveVector.y == 2;
            }

        return false;
    }
}
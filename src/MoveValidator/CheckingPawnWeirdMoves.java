package MoveValidator;

import Pieces.Pawn;
import Pieces.Piece;
import Utils.Vector2D;
import edu.uj.po.interfaces.*;
import Board.Board;

public class CheckingPawnWeirdMoves extends MoveValidatorChain {
    public CheckingPawnWeirdMoves(MoveValidator nextValidator, Board board) {
        super(nextValidator, board);
    }

    public boolean validateMove(Move move) {

        if (validateField(move) && nextValidator != null) {
            return nextValidator.validateMove(move);
        } else if (validateField(move) && nextValidator == null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateField(Move move) {
        Piece initialPiece = board.GetFieldByPosition(move.initialPosition()).GetPiece();
        Piece finalPiece = board.GetFieldByPosition(move.finalPosition()).GetPiece();

        Vector2D moveVector = new Vector2D(move.initialPosition(), move.finalPosition()).getAbsVector();

        if(moveVector.x == 1 && moveVector.y == 1 )
        {
            if(CheckEnPassant(move))
            {
                return true;
            }else if(finalPiece == null || initialPiece.GetColor() == finalPiece.GetColor())
            {
                return false;
            }


        }else if(moveVector.x == 0 && moveVector.y == 2)
        {
            if(initialPiece.GetColor() == Color.WHITE && initialPiece.GetPosition().rank() != Rank.SECOND ||
               initialPiece.GetColor() == Color.BLACK && initialPiece.GetPosition().rank() != Rank.SEVENTH) {
                return false;
            }else if(finalPiece != null)
            {
                return false;
            }
        }else if(moveVector.x == 0 && moveVector.y == 1)
        {
            return finalPiece == null;
        }

        return true;

    }

    private boolean CheckEnPassant(Move move)
    {
            Vector2D moveVector = new Vector2D(move.initialPosition(), move.finalPosition());
            Position pawnPosition = move.initialPosition();
            Color moveColor = board.GetFieldByPosition(move.initialPosition()).GetPiece().GetColor();

            Position neighbourPosition = new Position(File.values()[pawnPosition.file().ordinal() + moveVector.x], pawnPosition.rank());
            Piece neighbourPiece = board.GetFieldByPosition(neighbourPosition).GetPiece();

            if(neighbourPiece != null && neighbourPiece instanceof Pawn && neighbourPiece.GetColor() != moveColor && !board.moveHistory.isEmpty())
            {
                Move lastMove = board.moveHistory.get(board.moveHistory.size() - 1);
                Vector2D lastMoveVector = new Vector2D(lastMove.initialPosition(), lastMove.finalPosition()).getAbsVector();

                if(lastMove.finalPosition().equals(neighbourPosition) && lastMoveVector.y == 2)
                {
                    return true;
                }
            }

        return false;
    }
}
package MoveValidator;

import Board.IBoard;
import Utils.Vector2D;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

public class CheckingObstructionValidator extends MoveValidatorChain {


    public CheckingObstructionValidator(MoveValidator nextValidator, IBoard board) {
        super(nextValidator, board);
    }

    public boolean validateMove(Move move) {
        if (validateObstruction(move) && nextValidator != null) {
            return nextValidator.validateMove(move);
        } else return validateObstruction(move) && nextValidator == null;
    }

    private boolean validateObstruction(Move move) {
        Position initialPosition = move.initialPosition();
        Position finalPosition = move.finalPosition();
        Vector2D moveVector = obtainOneFieldMoveVector(initialPosition, finalPosition);

        Position currentPosition = obtainPositionMovedByVector(initialPosition, moveVector);

        while((currentPosition.file() != finalPosition.file() ) || (currentPosition.rank() != finalPosition.rank())) {

            if (board.getFieldByPosition(currentPosition).getPiece() != null) {
                return false;
            }
            currentPosition = obtainPositionMovedByVector(currentPosition, moveVector);
        }

        return true;

    }

    private Position obtainPositionMovedByVector(Position initialPosition, Vector2D moveVector) {
        return new Position(File.values()[initialPosition.file().ordinal() + moveVector.x],
                Rank.values()[initialPosition.rank().ordinal() + moveVector.y]);
    }

    private Vector2D obtainOneFieldMoveVector(Position initialPosition, Position finalPosition) {
        int x = finalPosition.file().ordinal() - initialPosition.file().ordinal();
        int y = finalPosition.rank().ordinal() - initialPosition.rank().ordinal();

        if (x != 0) {
            x = x / Math.abs(x);
        }
        if (y != 0) {
            y = y / Math.abs(y);
        }

        return new Vector2D(x, y);
    }
}
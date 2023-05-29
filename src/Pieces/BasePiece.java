package Pieces;

import MoveValidator.ValidatorFactory;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;

import java.util.List;

public abstract class BasePiece implements Piece{

    protected Position currentPosition;
    final protected Color pieceColor;

    public BasePiece(Position position, Color color)
    {
        currentPosition = position;
        pieceColor = color;
    }

    @Override
    public void setPosition(Position position) {
        currentPosition = position;
    }
    @Override
    public Position getPosition()
    {
        return currentPosition;
    }

    @Override
    public Color getColor()
    {
        return pieceColor;
    }


    @Override
    public abstract List<Move> getLegalMoves(ValidatorFactory validator);
}

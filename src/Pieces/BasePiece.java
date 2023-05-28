package Pieces;

import MoveValidator.MoveValidator;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import java.util.List;
import MoveValidator.ValidatorFactory;

public abstract class BasePiece implements Piece{

    protected Position currentPosition;
    final protected Color pieceColor;

    public BasePiece(Position position, Color color)
    {
        currentPosition = position;
        pieceColor = color;
    }

    @Override
    public void SetPosition(Position position) {
        currentPosition = position;
    }
    @Override
    public Position GetPosition()
    {
        return currentPosition;
    }

    @Override
    public Color GetColor()
    {
        return pieceColor;
    }


    @Override
    public abstract List<Move> GetLegalMoves(ValidatorFactory validator);
}

package Game;

import Board.IBoard;
import Board.MovesObtainer;
import Move.Command;
import Move.MoveCommand;
import MoveValidator.StandardValidatorFactory;
import WinningStrategy.WinningStrategy;
import edu.uj.po.interfaces.*;

import java.util.List;

public class GameController {
    private final IBoard gameBoard;


    public GameController(IBoard board)
    {
        this.gameBoard = board;
    }

    public Move getWinningMove(Color color, WinningStrategy winCondition)
    {
        List<Move> possibleMoves = new MovesObtainer(gameBoard, new StandardValidatorFactory(gameBoard)).getMovesByColor(color);

        for(Move move : possibleMoves)
        {
                Command moveCommand = new MoveCommand(gameBoard, move);
                moveCommand.execute();
                if(winCondition.checkForWin(gameBoard))
                {
                    return move;
                }
                moveCommand.undo();
        }

        return null;
    }


}

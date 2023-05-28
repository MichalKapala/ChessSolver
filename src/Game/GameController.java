package Game;

import Board.Board;
import Board.MovesObtainer;
import Move.Command;
import Move.MoveCommand;
import MoveValidator.StandardValidatorFactory;
import WinningStrategy.WinningStrategy;
import edu.uj.po.interfaces.*;

import java.util.List;

public class GameController {
    private Board gameBoard;


    public GameController(Board board)
    {
        this.gameBoard = board;
    }

    public Move GetWinningMove(Color color, WinningStrategy winCondition)
    {
        Color firstColor = color;
        List<Move> possibleMoves = new MovesObtainer(gameBoard, new StandardValidatorFactory(gameBoard)).GetMovesByColor(firstColor);

        for(Move move : possibleMoves)
        {
                Command moveCommand = new MoveCommand(gameBoard, move);
                moveCommand.execute();
                if(winCondition.CheckForWin(gameBoard))
                {
                    return move;
                }
                moveCommand.undo();
        }

        return null;
    }


}

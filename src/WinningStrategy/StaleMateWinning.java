package WinningStrategy;

import Board.IBoard;
import MoveValidator.StandardValidatorFactory;
import edu.uj.po.interfaces.Color;
import Board.MovesObtainer;


public class StaleMateWinning implements WinningStrategy{

    private final Color winningColor;

    public StaleMateWinning(Color color)
    {
        this.winningColor = color;
    }


    @Override
    public boolean checkForWin(IBoard board) {
        Judge judge = new Judge(board);
        MovesObtainer movesObtainer = new MovesObtainer(board, new StandardValidatorFactory(board));
        Color oppositeColor = winningColor == Color.WHITE ? Color.BLACK : Color.WHITE;

        return (!judge.isColorUnderCheck(oppositeColor)) && movesObtainer.getMovesByColor(oppositeColor).isEmpty();
    }
}

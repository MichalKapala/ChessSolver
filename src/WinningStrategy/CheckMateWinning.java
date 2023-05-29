package WinningStrategy;

import Board.IBoard;
import edu.uj.po.interfaces.Color;
import MoveValidator.StandardValidatorFactory;
import Board.MovesObtainer;

public class CheckMateWinning implements WinningStrategy{
    private final Color winningColor;

    public CheckMateWinning(Color color)
    {
        this.winningColor = color;
    }

    @Override
    public boolean checkForWin(IBoard board) {
        Judge judge = new Judge(board);
        MovesObtainer movesObtainer = new MovesObtainer(board, new StandardValidatorFactory(board));
        Color oppositeColor = winningColor == Color.WHITE ? Color.BLACK : Color.WHITE;

        return movesObtainer.getMovesByColor(oppositeColor).isEmpty() && judge.isColorUnderCheck(oppositeColor);
    }
}

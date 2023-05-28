package WinningStrategy;

import Board.Board;
import MoveValidator.StandardValidatorFactory;
import edu.uj.po.interfaces.Color;
import Board.MovesObtainer;


public class StaleMateWinning implements WinningStrategy{

    private Color winningColor;

    public StaleMateWinning(Color color)
    {
        this.winningColor = color;
    }


    @Override
    public boolean CheckForWin(Board board) {
        Judge judge = new Judge(board);
        MovesObtainer movesObtainer = new MovesObtainer(board, new StandardValidatorFactory(board));
        Color oppositeColor = winningColor == Color.WHITE ? Color.BLACK : Color.WHITE;

        return (!judge.IsColorUnderCheck(oppositeColor)) && movesObtainer.GetMovesByColor(oppositeColor).isEmpty();
    }
}

package WinningStrategy;

import Board.Board;
import Utils.ChessBoardPrinter;
import edu.uj.po.interfaces.Color;
import MoveValidator.StandardValidatorFactory;
import Board.MovesObtainer;

public class CheckMateWinning implements WinningStrategy{
    private Color winningColor;

    public CheckMateWinning(Color color)
    {
        this.winningColor = color;
    }

    @Override
    public boolean CheckForWin(Board board) {
        Judge judge = new Judge(board);
        MovesObtainer movesObtainer = new MovesObtainer(board, new StandardValidatorFactory(board));
        Color oppositeColor = winningColor == Color.WHITE ? Color.BLACK : Color.WHITE;

        return movesObtainer.GetMovesByColor(oppositeColor).isEmpty() && judge.IsColorUnderCheck(oppositeColor);
    }
}

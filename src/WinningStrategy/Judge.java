package WinningStrategy;
import Board.MovesObtainer;
import Board.IBoard;
import MoveValidator.CheckValidatorFactory;
import Pieces.Piece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;
import Board.PieceGetter;

public class Judge {
    private final IBoard board;
    public Judge (IBoard board){
        this.board = board;
    }
    public boolean isColorUnderCheck(Color color) {
        Piece king = new PieceGetter(board).getKing(color);

        if(king != null) {
            Position kingPosition = king.getPosition();
            Color oppositeColor = color == Color.WHITE ? Color.BLACK : Color.WHITE;
            MovesObtainer movesObtainer = new MovesObtainer(board, new CheckValidatorFactory(board));

            for (var move : movesObtainer.getMovesByColor(oppositeColor)) {
                if (move.finalPosition().equals(kingPosition)) {
                    return true;
                }
            }
        }
            return false;

    }

}

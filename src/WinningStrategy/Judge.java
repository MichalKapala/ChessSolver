package WinningStrategy;
import Board.MovesObtainer;
import Board.Board;
import MoveValidator.CheckValidatorFactory;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;
import Board.PieceGetter;

public class Judge {
    private  Board board;
    public Judge (Board board){
        this.board = board;
    }
    public boolean IsColorUnderCheck(Color color) {
        Position kingPosition = new PieceGetter(board).GetKingPosition(color);
        Color oppositeColor = color == Color.WHITE ? Color.BLACK : Color.WHITE;
        MovesObtainer movesObtainer = new MovesObtainer(board, new CheckValidatorFactory(board));

        for(var move : movesObtainer.GetMovesByColor(oppositeColor)){
            if(move.finalPosition().equals(kingPosition)){
                return true;
            }
        }

        return false;
    }
}

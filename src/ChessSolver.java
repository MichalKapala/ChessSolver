import Board.IBoard;
import Board.Board;
import Game.GameController;
import Pieces.PieceFactory;
import WinningStrategy.CheckMateWinning;
import WinningStrategy.StaleMateWinning;
import edu.uj.po.interfaces.*;

import java.util.Optional;

public class ChessSolver implements Solver, Setup {
    public IBoard board;
    private GameController controller;

    public ChessSolver()
    {
        board = new Board();
    }
    @Override
    public Optional<Move> findMateInOneMove(Color color) {
        controller = new GameController(board);
        return Optional.ofNullable(controller.getWinningMove(color, new CheckMateWinning(color)));
    }

    @Override
    public Optional<Move> findStalemateInOneMove(Color color) {
        controller = new GameController(board);
        return Optional.ofNullable(controller.getWinningMove(color, new StaleMateWinning(color)));

    }

    @Override
    public void reset() {
        board = new Board();
        controller = new GameController(board);
    }

    @Override
    public void addChessPiece(Position position, Color color, ChessPiece piece) {
        board.getFieldByPosition(position).setPiece(PieceFactory.CreatePiece(piece, position,color));
    }
}

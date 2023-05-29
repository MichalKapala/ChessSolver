import edu.uj.po.interfaces.*;

public class TestMain {
    public static void setup1(ChessSolver solver) {
        solver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        solver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.WHITE, ChessPiece.ROOK);
        solver.addChessPiece(new Position(File.a, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
    }

    public static void setup2(ChessSolver solver) {
        solver.addChessPiece(new Position(File.h, Rank.FOURTH), Color.WHITE, ChessPiece.KING);
        solver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.c, Rank.SIXTH), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.g, Rank.FOURTH), Color.WHITE, ChessPiece.BISHOP);

        solver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        solver.addChessPiece(new Position(File.b, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        solver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
    }

    public static void setup3(ChessSolver solver) {
        solver.addChessPiece(new Position(File.a, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        solver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.a, Rank.THIRD), Color.WHITE, ChessPiece.QUEEN);
        solver.addChessPiece(new Position(File.b, Rank.FIRST), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.b, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.BISHOP);
        solver.addChessPiece(new Position(File.h, Rank.FOURTH), Color.WHITE, ChessPiece.ROOK);

        solver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.BLACK, ChessPiece.KING);
    }

    public static void setup4(ChessSolver solver) {
        solver.addChessPiece(new Position(File.h, Rank.FIRST), Color.BLACK, ChessPiece.KING);
        solver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.WHITE, ChessPiece.KING);
        solver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.WHITE, ChessPiece.QUEEN);

    }

    public static void setup5(ChessSolver solver) {
        solver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);

    }

    public static void setup6(ChessSolver solver) {
        solver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        solver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.f, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.d, Rank.SIXTH), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.a, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.WHITE, ChessPiece.QUEEN);

//        solver.addChessPiece(new Position(File.g, Rank.SIXTH), Color.BLACK, ChessPiece.ROOK);
        solver.addChessPiece(new Position(File.f, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.c, Rank.SIXTH), Color.BLACK, ChessPiece.BISHOP);
        solver.addChessPiece(new Position(File.d, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        ChessBoardPrinter.printChessBoard(solver.board);

    }

    public static void setup7(ChessSolver solver) {
        solver.addChessPiece(new Position(File.c, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        solver.addChessPiece(new Position(File.f, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.WHITE, ChessPiece.QUEEN);

        solver.addChessPiece(new Position(File.h, Rank.SECOND), Color.BLACK, ChessPiece.ROOK);
        solver.addChessPiece(new Position(File.f, Rank.FOURTH), Color.BLACK, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.a, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        solver.addChessPiece(new Position(File.c, Rank.THIRD), Color.BLACK, ChessPiece.KNIGHT);
        solver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.BISHOP);
        solver.addChessPiece(new Position(File.e, Rank.SEVENTH), Color.BLACK, ChessPiece.QUEEN);
        solver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
        ChessBoardPrinter.printChessBoard(solver.board);

    }

    public static void setup8(ChessSolver solver) {
        FenParser parser = new FenParser();
        parser.parseFEN("r1bqkb1r/pppp1ppp/2n2n2/3Q4/2B1P3/8/PB3PPP/RN2K1NR", solver);
        ChessBoardPrinter.printChessBoard(solver.board);
    }

    public static void setup9(ChessSolver solver) {
        FenParser parser = new FenParser();
        parser.parseFEN("6k1/5ppp/p7/P7/5b2/7P/1r3PP1/3R2K1", solver);
        ChessBoardPrinter.printChessBoard(solver.board);

    }

    public static void setup10(ChessSolver solver) {
        FenParser parser = new FenParser();
        parser.parseFEN("3r2rk/p5pp/1p4n1/3p2N1/2pP4/2P1R3/qPBQ1PPP/6K1", solver);
        ChessBoardPrinter.printChessBoard(solver.board);

    }

    public static void setup11(ChessSolver solver) {
        FenParser parser = new FenParser();
        parser.parseFEN("r1b2b1r/pp3Qp1/2nkn2p/3ppP1p/P1p5/1NP1NB2/1PP1PPR1/1K1R3q", solver);
        ChessBoardPrinter.printChessBoard(solver.board);

    }

    public static void setup12(ChessSolver solver) {
        FenParser parser = new FenParser();
        parser.parseFEN("r2k1n2/ppp4p/3p4/1B5n/5pb1/5N2/PPPP1qPP/RNBKR3", solver);
        ChessBoardPrinter.printChessBoard(solver.board);

    }
    public static void setup13(ChessSolver solver) {
        FenParser parser = new FenParser();
        parser.parseFEN("4k2r/1p2rqpp/p7/2pp4/6Q1/8/PPP2PPP/3RR1K1", solver);
        ChessBoardPrinter.printChessBoard(solver.board);

    }

    // Potencjalny mat ale z odslonieciem króla
    public static void setup14(ChessSolver solver) {
        FenParser parser = new FenParser();
        parser.parseFEN("1nbqkbnr/ppppp2p/4rp2/8/3P4/8/PPP1QPPP/RNB1KBNR", solver);
        ChessBoardPrinter.printChessBoard(solver.board);

    }

    public static void setup15(ChessSolver solver) {
        FenParser parser = new FenParser();
        parser.parseFEN("rnbqkbnr/ppppp2p/5p2/8/8/4P3/PPPP1PPP/RNBQKBNR", solver);
        ChessBoardPrinter.printChessBoard(solver.board);

    }

    public static void setup16(ChessSolver solver) {
        FenParser parser = new FenParser();
        parser.parseFEN("k7/8/8/8/3p4/3K4/8/8", solver);
        ChessBoardPrinter.printChessBoard(solver.board);

    }




    public static void main(String[] args) {
        ChessSolver solver = new ChessSolver();
        solver.reset();


        setup1(solver);
        Move winningMove = solver.findMateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.a, Rank.SEVENTH), new Position(File.a, Rank.EIGHTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();


        setup2(solver);
        winningMove = solver.findMateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.c, Rank.SIXTH), new Position(File.c, Rank.SEVENTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        setup3(solver);
        winningMove = solver.findMateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.a, Rank.THIRD), new Position(File.d, Rank.SIXTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        setup4(solver);
        winningMove = solver.findStalemateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.f, Rank.EIGHTH), new Position(File.f, Rank.SECOND)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        setup4(solver);
        assert solver.findMateInOneMove(Color.WHITE).isEmpty();
        System.out.println("No winning move");
        solver.reset();

        setup5(solver);
        assert solver.findMateInOneMove(Color.BLACK).isEmpty();
        System.out.println("No winning move");
        solver.reset();

        setup6(solver);
        winningMove = solver.findStalemateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.c, Rank.FIFTH), new Position(File.c, Rank.SIXTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        setup7(solver);
        winningMove = solver.findStalemateInOneMove(Color.BLACK).get();
        assert winningMove.equals(new Move(new Position(File.a, Rank.SEVENTH), new Position(File.a, Rank.EIGHTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        //Does not work in release???
        setup8(solver);
        winningMove = solver.findMateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.d, Rank.FIFTH), new Position(File.f, Rank.SEVENTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        setup9(solver);
        winningMove = solver.findMateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.d, Rank.FIRST), new Position(File.d, Rank.EIGHTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        setup10(solver);
        winningMove = solver.findMateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.g, Rank.FIFTH), new Position(File.f, Rank.SEVENTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        setup12(solver);
        winningMove = solver.findMateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.EIGHTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        setup13(solver);
        winningMove = solver.findMateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.g, Rank.FOURTH), new Position(File.c, Rank.EIGHTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

        setup14(solver);
        assert solver.findMateInOneMove(Color.WHITE).isEmpty();
        System.out.println("Winning move does not exists");
        solver.reset();


        setup15(solver);
        winningMove = solver.findMateInOneMove(Color.WHITE).get();
        assert winningMove.equals(new Move(new Position(File.d, Rank.FIRST), new Position(File.h, Rank.FIFTH)));
        System.out.println("Winning move " + winningMove);
        solver.reset();

//        setup16(solver);
//        winningMove = solver.findStalemateInOneMove(Color.WHITE).get();
//        assert winningMove.equals(new Move(new Position(File.d, Rank.FIRST), new Position(File.h, Rank.FIFTH)));
//        System.out.println("Winning move " + winningMove);
//        solver.reset();
    }

}

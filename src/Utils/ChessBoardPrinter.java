package Utils;

import Board.Board;
import Board.Field;
import Pieces.Piece;
import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Rank;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.ChessPieceAsUnicode;

public class ChessBoardPrinter {

    public static void printChessBoard(Board board) {
        System.out.println("   A  B  C  D  E  F  G  H");
        System.out.println("  +-----------------+");

        for (int i = 7; i >= 0; i--) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < 8; j++) {
                Field field = board.GetFieldByPosition(new Position(File.values()[j], Rank.values()[i]));

                if (field.GetPiece() == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(ChessPieceAsUnicode.getSymbol(MapPiece(field.GetPiece()), field.GetPiece().GetColor()));
                }
                System.out.print(" ");
            }
            System.out.println("| " + (i + 1));
        }

        System.out.println("  +-----------------+");
        System.out.println("   A  B  C  D  E  F  G  H");
    }



    private static ChessPiece MapPiece(Piece piece) {
        if (piece instanceof Pieces.King) {
            return ChessPiece.KING;
        } else if (piece instanceof Pieces.Queen) {
            return ChessPiece.QUEEN;
        } else if (piece instanceof Pieces.Rook) {
            return ChessPiece.ROOK;
        } else if (piece instanceof Pieces.Bishop) {
            return ChessPiece.BISHOP;
        } else if (piece instanceof Pieces.Knight) {
            return ChessPiece.KNIGHT;
        } else if (piece instanceof Pieces.Pawn) {
            return ChessPiece.PAWN;
        } else {
            return null;
        }
    }
}
package MovesGenerator;

import edu.uj.po.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class MovesGeneratorImpl
{

    public static List<Move> GenerateDiagonalMoves(Position position) {
        List<Move> moves = new ArrayList<>();
        int row = position.file().ordinal();
        int col = position.rank().ordinal();

        for (int i = 1; row + i < 8 && col + i < 8; i++) {
            moves.add(new Move(position, new Position(File.values()[row + i], Rank.values()[col + i])));
        }

        for (int i = 1; row - i >= 0 && col + i < 8; i++) {
            moves.add(new Move(position, new Position(File.values()[row - i], Rank.values()[col + i])));
        }

        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            moves.add(new Move(position, new Position(File.values()[row - i], Rank.values()[col - i])));
        }

        for (int i = 1; row + i < 8 && col - i >= 0; i++) {
            moves.add(new Move(position, new Position(File.values()[row + i], Rank.values()[col - i])));
        }

        return moves;
    }

    public static List<Move> GenerateStraightMoves(Position position) {
        List<Move> moves = new ArrayList<>();
        int row = position.file().ordinal();
        int col = position.rank().ordinal();

        for (int i = 1; row + i < 8; i++) {
            moves.add(new Move(position, new Position(File.values()[row + i], Rank.values()[col])));
        }

        for (int i = 1; row - i >= 0; i++) {
            moves.add(new Move(position, new Position(File.values()[row - i], Rank.values()[col])));
        }

        for (int i = 1; col + i < 8; i++) {
            moves.add(new Move(position, new Position(File.values()[row], Rank.values()[col + i])));
        }

        for (int i = 1; col - i >= 0; i++) {
            moves.add(new Move(position, new Position(File.values()[row], Rank.values()[col - i])));
        }

        return moves;
    }

    public static List<Move> GenerateLMoves(Position position) {
        List<Move> moves = new ArrayList<>();
        int row = position.file().ordinal();
        int col = position.rank().ordinal();

        if (row + 2 < 8 && col + 1 < 8) {
            moves.add(new Move(position, new Position(File.values()[row + 2], Rank.values()[col + 1])));
        }

        if (row + 2 < 8 && col - 1 >= 0) {
            moves.add(new Move(position, new Position(File.values()[row + 2], Rank.values()[col - 1])));
        }

        if (row - 2 >= 0 && col + 1 < 8) {
            moves.add(new Move(position, new Position(File.values()[row - 2], Rank.values()[col + 1])));
        }

        if (row - 2 >= 0 && col - 1 >= 0) {
            moves.add(new Move(position, new Position(File.values()[row - 2], Rank.values()[col - 1])));
        }

        if (row + 1 < 8 && col + 2 < 8) {
            moves.add(new Move(position, new Position(File.values()[row + 1], Rank.values()[col + 2])));
        }

        if (row + 1 < 8 && col - 2 >= 0) {
            moves.add(new Move(position, new Position(File.values()[row + 1], Rank.values()[col - 2])));
        }

        if (row - 1 >= 0 && col + 2 < 8) {
            moves.add(new Move(position, new Position(File.values()[row - 1], Rank.values()[col + 2])));
        }

        if (row - 1 >= 0 && col - 2 >= 0) {
            moves.add(new Move(position, new Position(File.values()[row - 1], Rank.values()[col - 2])));
        }

        return moves;
    }


    // Add simple coefficent instead of two functions
    public static List<Move> GeneratePawnMoves (Position position, Color color)
    {
        if (color == Color.WHITE) {
            return GenerateWhitePawnMoves(position);
        } else {
            return GenerateBlackPawnMoves(position);
        }
    }

    private static List<Move> GenerateWhitePawnMoves(Position position)
    {
        List<Move> moves = new ArrayList<>();
        int row = position.rank().ordinal();
        int col = position.file().ordinal();

        if (row + 1 < 8) {
            moves.add(new Move(position, new Position(File.values()[col], Rank.values()[row + 1 ])));
        }

        if(row + 2 < 8) {
            moves.add(new Move(position, new Position(File.values()[col], Rank.values()[row + 2])));
        }

        if(row + 1 < 8 && col + 1 < 8) {
            moves.add(new Move(position, new Position(File.values()[col + 1], Rank.values()[row + 1])));
        }

        if(row + 1 < 8 && col - 1 >= 0) {
            moves.add(new Move(position, new Position(File.values()[col - 1], Rank.values()[row + 1])));
        }

        return moves;
    }

    private static List<Move> GenerateBlackPawnMoves(Position position)
    {
        List<Move> moves = new ArrayList<>();
        int row = position.rank().ordinal();
        int col = position.file().ordinal();

        if (row - 1 >= 0) {
            moves.add(new Move(position, new Position(File.values()[col], Rank.values()[row - 1])));
        }

        if(row - 2 >= 0) {
            moves.add(new Move(position, new Position(File.values()[col], Rank.values()[row - 2])));
        }

        if(row - 1 >= 0 && col + 1 < 8) {
            moves.add(new Move(position, new Position(File.values()[col + 1], Rank.values()[row - 1])));
        }

        if(row - 1 >= 0 && col - 1 >= 0) {
            moves.add(new Move(position, new Position(File.values()[col - 1], Rank.values()[row - 1])));
        }

        return moves;
    }
}
import edu.uj.po.interfaces.*;
import edu.uj.po.interfaces.Setup;

public class FenParser {
    public void parseFEN(String fen, Setup solver) {
        // Split the FEN string into its components
        String[] fenParts = fen.split(" ");

        // Parse the position component
        String fenPosition = fenParts[0];
        String[] fenRows = fenPosition.split("/");

        // Loop through each row of the FEN position
        for (int rankIndex = 0; rankIndex < fenRows.length; rankIndex++) {
            String fenRow = fenRows[rankIndex];
            int fileIndex = 0;

            // Loop through each character in the FEN row
            for (int i = 0; i < fenRow.length(); i++) {
                char fenChar = fenRow.charAt(i);

                // If the character represents a piece
                if (Character.isLetter(fenChar)) {
                    Color color = Character.isUpperCase(fenChar) ? Color.WHITE : Color.BLACK;
                    ChessPiece piece = getChessPieceFromFENChar(Character.toLowerCase(fenChar));

                    // Calculate the position coordinates
                    File file = File.values()[fileIndex];
                    Rank rank = Rank.values()[7 - rankIndex];

                    // Set the chess piece at the given position
                    Position position = new Position(file, rank);
                    solver.addChessPiece(position, color, piece);

                    fileIndex++;
                } else if (Character.isDigit(fenChar)) {
                    // If the character represents an empty square(s)
                    int emptySquares = Character.getNumericValue(fenChar);
                    fileIndex += emptySquares;
                }
            }
        }
    }

    private ChessPiece getChessPieceFromFENChar(char fenChar) {
        switch (fenChar) {
            case 'k':
                return ChessPiece.KING;
            case 'q':
                return ChessPiece.QUEEN;
            case 'r':
                return ChessPiece.ROOK;
            case 'b':
                return ChessPiece.BISHOP;
            case 'n':
                return ChessPiece.KNIGHT;
            case 'p':
                return ChessPiece.PAWN;
            default:
                throw new IllegalArgumentException("Invalid FEN character: " + fenChar);
        }
    }
}

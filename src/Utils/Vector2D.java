package Utils;

import edu.uj.po.interfaces.Position;

public class Vector2D {
    public int x;
    public int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Position initialPosition, Position finalPosition) {
        this.x = finalPosition.file().ordinal() - initialPosition.file().ordinal();
        this.y = finalPosition.rank().ordinal() - initialPosition.rank().ordinal();
    }

    public Vector2D getAbsVector() {
        return new Vector2D(Math.abs(x), Math.abs(y));
    }

}
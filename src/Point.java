/**
 * Point class represents a position on the board using x and y coordinates.
 */
public class Point {
    private short x;
    private short y;

    /**
     * Constructs a Point with given x and y coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(short x, short y) {
        this.x = x;
        this.y = y;
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }
}

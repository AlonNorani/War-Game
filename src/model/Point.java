package model;
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

    short getX() {
        return x;
    }

    void setX(short x) {
        this.x = x;
    }

    short getY() {
        return y;
    }

    void setY(short y) {
        this.y = y;
    }
}

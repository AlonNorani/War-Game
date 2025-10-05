package model;

/**
 * Abstract base class for all entities on the board.
 * Each Piece has a position.
 */
public abstract class Piece {
    protected Point position;

    /**
     * Constructs a Piece at the given position.
     * @param position the position of the piece
     */
    public Piece(Point position) {
        this.position = position;
    }

    Point getPosition() {
        return position;
    }

    void setPosition(Point position) {
        this.position = position;
    }

    public abstract String toString();
}

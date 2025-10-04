/**
 * Tree class represents a tree entity on the board.
 * Trees are obstacles and cannot be moved.
 */
public class Tree extends Piece {
    /**
     * Constructs a Tree at the given position.
     * @param position the position of the tree
     */
    public Tree(Point position) {
        super(position);
    }
}

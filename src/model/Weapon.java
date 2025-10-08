package model;
/**
 * Abstract class for all weapons on the board.
 * Each weapon is a Piece and must implement isStronger.
 */
public abstract class Weapon extends Piece {
    /**
     * Constructs a Weapon at the given position.
     * @param position the position of the weapon
     */
    public Weapon(Point position) {
        super(position);
    }

    /**
     * Determines if this weapon is stronger than another weapon.
     * @param other the other weapon to compare
     * @return true if this weapon is stronger, false otherwise
     */
    abstract boolean isStronger(Weapon other);
    public abstract String toString();
}

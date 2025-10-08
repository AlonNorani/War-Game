package model;

/**
 * Fireball class represents a fireball weapon on the board.
 * Implements isStronger logic for fireball vs other weapons.
 */
public class Fireball extends Weapon {
    /**
     * Constructs a Fireball at the given position.
     * @param position the position of the fireball
     */
    public Fireball(Point position) {
        super(position);
    }

    /**
     * Determines if this fireball is stronger than another weapon.
     * If other is Fireball, lottery (50% chance). If other is Sword, fireball wins.
     * @param other the other weapon to compare
     * @return true if this fireball is stronger, false otherwise
     */
    @Override
    boolean isStronger(Weapon other) {
        if (other instanceof Fireball) {
            // Lottery: 50% chance to win
            return Math.random() < 0.5;
        }
        return other instanceof Sword;
    }
    @Override
    public String toString() {
        return "🔥"; // Unicode for fire emoji
    }
}

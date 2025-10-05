package model;
/**
 * Sword class represents a sword weapon on the board.
 * Implements isStronger logic for sword vs other weapons.
 */
public class Sword extends Weapon {
    /**
     * Constructs a Sword at the given position.
     * @param position the position of the sword
     */
    public Sword(Point position) {
        super(position);
    }

    /**
     * Determines if this sword is stronger than another weapon.
     * If other is Sword, lottery (50% chance). If other is MagicRing, sword wins.
     * @param other the other weapon to compare
     * @return true if this sword is stronger, false otherwise
     */
    @Override
    boolean isStronger(Weapon other) {
        if (other instanceof Sword) {
            // Lottery: 50% chance to win
            return Math.random() < 0.5;
        }
        return other instanceof MagicRing;
    }

    @Override
    public String toString() {
        return "🗡"; // Unicode for sword emoji
    }
}

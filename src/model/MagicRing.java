package model;
/**
 * MagicRing class represents a magic ring weapon on the board.
 * Implements isStronger logic for magic ring vs other weapons.
 */
public class MagicRing extends Weapon {
    /**
     * Constructs a MagicRing at the given position.
     * @param position the position of the magic ring
     */
    public MagicRing(Point position) {
        super(position);
    }

    /**
     * Determines if this magic ring is stronger than another weapon.
     * If other is MagicRing, lottery (50% chance). If other is Fireball, magic ring wins.
     * @param other the other weapon to compare
     * @return true if this magic ring is stronger, false otherwise
     */
    @Override
    boolean isStronger(Weapon other) {
        if (other instanceof MagicRing) {
            // Lottery: 50% chance to win
            return Math.random() < 0.5;
        }
        return other instanceof Fireball;
    }

    @Override
    public String toString() {
        return "💍"; // Unicode for ring emoji
    }
}

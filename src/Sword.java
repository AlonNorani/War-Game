public class Sword extends Weapon{
    public Sword(Point position) {
        super(position);
    }

    @Override
    public boolean isStronger(Weapon other) {
        if (other instanceof Sword) {
            // Lottery: 50% chance to win
            return Math.random() < 0.5;
        }
        return other instanceof MagicRing;
    }
}

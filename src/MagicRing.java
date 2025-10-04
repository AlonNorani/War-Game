public class MagicRing extends Weapon{
    public MagicRing(Point position) {
        super(position);
    }

    @Override
    public boolean isStronger(Weapon other) {
        if (other instanceof MagicRing) {
            // Lottery: 50% chance to win
            return Math.random() < 0.5;
        }
        return other instanceof Fireball;
    }
}

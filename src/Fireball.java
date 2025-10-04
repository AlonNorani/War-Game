public class Fireball extends Weapon {
    public Fireball(Point position) {
        super(position);
    }

    @Override
    public boolean isStronger(Weapon other) {
        if (other instanceof Fireball) {
            // Lottery: 50% chance to win
            return Math.random() < 0.5;
        }
        return other instanceof Sword;
    }
}

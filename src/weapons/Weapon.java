public abstract class Weapon extends Piece {
    public Weapon(Point position) {
        super(position);
    }
    public abstract boolean isStronger(Weapon other);
}

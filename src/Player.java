import java.util.LinkedList;
import java.util.Queue;

public class Player extends Piece{
    protected Queue<Weapon> weapons;

    public Player(Point position) {
        super(position);
        weapons = new LinkedList<>(); // Initialize queue to be empty
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }
    public Weapon getWeapon() {
        return weapons.element();
    }
}

package model;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Player class represents a player entity on the board.
 * Each player has a queue of weapons, a player number, and a name.
 */
public class Player extends Piece {
    protected Queue<Weapon> weapons; // Queue of weapons held by the player
    private int playerNumber;
    private String name;

    /**
     * Constructs a Player at the given position with a player number and name.
     * Initializes the weapon queue to be empty.
     * @param position the position of the player
     * @param playerNumber the player's number
     * @param name the player's name
     */
    public Player(Point position, int playerNumber, String name) {
        super(position);
        this.playerNumber = playerNumber;
        this.name = name;
        weapons = new LinkedList<>(); // Initialize queue to be empty
    }


    void setPosition(Point position) {
        this.position = position;
    }
    void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    /**
     * Gets the first weapon in the player's queue.
     * @return the weapon at the front of the queue
     */
    Weapon getWeapon() {
        return weapons.element();
    }

    int getPlayerNumber() {
        return playerNumber;
    }

    String getName() {
        return name;
    }
    void killOtherPlayer(Player other) {
        for(Weapon weapon : other.weapons) {
            this.addWeapon(weapon);
        }
        other.weapons.clear();
    }
    @Override
    public String toString() {
        return "P" + playerNumber;
    }
}

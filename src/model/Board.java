package model;
import java.security.InvalidParameterException;
import java.util.*;

/**
 * Board class represents the game board and manages entities on it.
 */
public class Board {
    public enum ReturnCode {
        SUCCESS,
        WIN,
    }

    // Board dimensions
    public static final int ROWS = 10;
    public static final int COLS = 10;
    // Player limits
    private final int MIN_PLAYERS = 2;
    private final int MAX_PLAYERS = 5;


    private Piece[][] board; // 2D array representing the board grid
    private ArrayList<Player> players; // List of players on the board
    private Queue<Player> playerQueue;

    /**
     * Constructs a Board with empty grid and no players.
     */
    public Board() {

        board = new Piece[ROWS][COLS];
        players = new ArrayList<>(); // Initialize the players list

    }
    public void initializeBoard(Map<Integer, String> playersInfo) {
        // validate players amount
        if (playersInfo.size() < MIN_PLAYERS || playersInfo.size() > MAX_PLAYERS) {
            throw new IllegalArgumentException("Players amount must be between" + MIN_PLAYERS + " and " + MAX_PLAYERS);
        }

        // Place players randomly on the board
        for (Map.Entry<Integer, String> entry : playersInfo.entrySet()) {
            Point p = getEmptyRandomPosition();
            Player newPlayer = new Player(p, entry.getKey(), entry.getValue());
            addEntity(newPlayer);
            players.add(newPlayer);
        }

        // shuffle players to randomize turn order
        Collections.shuffle(players);
        playerQueue = new LinkedList<>(players);

        // place 3 trees randomly on the board
        for (int i = 0; i < 3; i++) {
            Point p = getEmptyRandomPosition();
            addEntity(new Tree(p));
        }
        // place 2 of each weapon randomly on the board
        for (int i = 0; i < 2; i++) {
            Point p1 = getEmptyRandomPosition();
            addEntity(new MagicRing(p1));
            Point p2 = getEmptyRandomPosition();
            addEntity(new Sword(p2));
            Point p3 = getEmptyRandomPosition();
            addEntity(new Fireball(p3));
        }

    }
    private void addEntity(Piece piece) {
        Point position = piece.getPosition();
        board[position.getX()][position.getY()] = piece;
    }

    private void removeEntity(Point position) {
        board[position.getX()][position.getY()] = null;
    }

    private Piece getEntity(Point position) {
        return board[position.getX()][position.getY()];
    }

    private boolean isEmpty(Point position) {
        return board[position.getX()][position.getY()] == null;
    }

    private boolean isInBoard(Point position) {
        return position.getX() >= 0 && position.getX() < ROWS && position.getY() >= 0 && position.getY() < COLS;
    }

    private Point getEmptyRandomPosition() {
        Point p;
        do {
            // generate random x and y between 0 and 9
            short x = (short) (Math.random() * 10);
            short y = (short) (Math.random() * 10);
            p = new Point(x, y);
        } while (!isEmpty(p));
        return p;
    }

    public ReturnCode movePlayer(char direction) {
        Player currentPlayer = playerQueue.element();
        Point currentPosition = currentPlayer.getPosition();
        Point newPosition = new Point(currentPosition.getX(), currentPosition.getY());
        switch (Character.toUpperCase(direction)) {
            case 'U':
                newPosition.setY((short) (newPosition.getY() - 1));
                break;
            case 'D':
                newPosition.setY((short) (newPosition.getY() + 1));
                break;
            case 'L':
                newPosition.setX((short) (newPosition.getX() - 1));
                break;
            case 'R':
                newPosition.setX((short) (newPosition.getX() + 1));
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        // check if new position is in board
        if (!isInBoard(newPosition)) {
            // invalid move, throw exception
            throw new InvalidParameterException("Move out of board bounds, try again");
        }
        // check if new position is empty
        if (isEmpty(newPosition)) {
            // move player to new position
            movePlayer(newPosition);
            return ReturnCode.SUCCESS;
        }
        Piece entityAtNewPos = getEntity(newPosition);
        if (entityAtNewPos instanceof Tree) {
            // invalid move, throw exception
            throw new InvalidParameterException("Move blocked by tree, try again");
        }
        if (entityAtNewPos instanceof Weapon) {
            // pick up weapon
            Weapon weaponAtNewPos = (Weapon) entityAtNewPos;
            currentPlayer.addWeapon(weaponAtNewPos);
            movePlayer(newPosition);
            return ReturnCode.SUCCESS;
        }
        if (entityAtNewPos instanceof Player) {
            // fight
            Player otherPlayer = (Player) entityAtNewPos;
            Weapon currentWeapon = currentPlayer.getWeapon();
            Weapon otherWeapon = otherPlayer.getWeapon();
            boolean currentWins = currentWeapon.isStronger(otherWeapon);
            if (currentWins) {
                // current player wins, remove other player from the game
                currentPlayer.killOtherPlayer(otherPlayer); // take other player's weapons
                if (players.size() == 2) {
                    return ReturnCode.WIN; // current player wins the game
                }
                playerQueue.remove(otherPlayer);
                players.remove(otherPlayer); // move current player to new position
                movePlayer(newPosition);
            }
            else  {
                // other player wins, remove current player from the game
                otherPlayer.killOtherPlayer(currentPlayer); // take current player's weapons
                if (players.size() == 2) {
                    return ReturnCode.WIN; // other player wins the game
                }

                playerQueue.remove(currentPlayer);
                players.remove(currentPlayer);
            }
        }
        return ReturnCode.SUCCESS;
    }
    private void movePlayer(Point newPosition) {
        Player currentPlayer = playerQueue.element();
        Point currentPosition = currentPlayer.getPosition();
        removeEntity(currentPosition);
        currentPlayer.setPosition(newPosition);
        addEntity(currentPlayer);
        // advance to next player's turn
        playerQueue.add(playerQueue.remove());
    }
    public String getCurrentPlayerName() {
        return "Player number " + playerQueue.element().getPlayerNumber() + " (" + playerQueue.element().getName() + ")";
    }
    public Piece[][] getBoardState() {
        return board;
    }

}
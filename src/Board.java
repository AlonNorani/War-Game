import java.util.Map;
public class Board {
    public static final int ROWS  = 10;
    public static final int COLS  = 10;
    private Piece[][] board;
    public Board(Map<Integer, String> playersInfo) {
        board = new Piece[ROWS][COLS];
        // place players randomly on the board
        for (Map.Entry<Integer, String> entry : playersInfo.entrySet()) {
            Point p = getEmptyRandomPosition();
            Player newPlayer = new Player(p, entry.getKey(), entry.getValue());
            addEntity(newPlayer);
        }

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
    public void addEntity(Piece piece) {
        Point position = piece.getPosition();
        board[position.getX()][position.getY()] = piece;
    }
    public void removeEntity(Point position) {
        board[position.getX()][position.getY()] = null;
    }
    public Piece getEntity(Point position) {
        return board[position.getX()][position.getY()];
    }
    public boolean isEmpty(Point position) {
        return board[position.getX()][position.getY()] == null;
    }
    public boolean isInBoard(Point position) {
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

}


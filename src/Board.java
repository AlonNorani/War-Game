public class Board {
    public static final int ROWS  = 10;
    public static final int COLS  = 10;
    private Piece[][] board;
    public Board() {
        board = new Piece[ROWS][COLS];
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

}

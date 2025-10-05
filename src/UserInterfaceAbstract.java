public abstract class UserInterfaceAbstract {
    private Board board;
    public abstract void displayBoard();
    public abstract void startGame();

    public UserInterfaceAbstract(Board gameBoard) {
        this.board = gameBoard;
    }
}

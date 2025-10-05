package view;
import model.Board;
public abstract class UserInterfaceAbstract {
    protected Board board;
    public abstract void displayBoard();
    public abstract void startGame();

    public UserInterfaceAbstract(Board gameBoard) {
        this.board = gameBoard;
    }
}

import model.Board;
import view.UserInterfaceAbstract;
import view.GameConsole;
public class Main {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        UserInterfaceAbstract consoleUI = new GameConsole(gameBoard);
        consoleUI.startGame();
    }
}
import model.Board;
import view.GameConsole;
public class Main {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        GameConsole consoleUI = new GameConsole(gameBoard);
        consoleUI.startGame();
    }
}
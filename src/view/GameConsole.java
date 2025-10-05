package view;
import model.Board;
import model.Piece;

public class GameConsole extends UserInterfaceAbstract{
    public GameConsole(Board gameBoard) {
        super(gameBoard);
    }

    @Override
    public void displayBoard() {
        Piece[][] grid = board.getBoardState();
        for(int i = 0; i < board.ROWS; i++) {
            for(int j = 0; j < board.COLS; j++) {
                if(grid[i][j] == null) {
                    System.out.print("[  ] ");
                } else {
                    System.out.print(grid[i][j].toString() + " ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void startGame() {
        System.out.println("Starting game in console mode.");
        // Implementation to start the game in console
    }
}

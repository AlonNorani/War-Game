public class GameConsole extends UserInterfaceAbstract{
    public GameConsole(Board gameBoard) {
        super(gameBoard);
    }

    @Override
    public void displayBoard() {
        System.out.println("Displaying board in console mode.");
        // Implementation to display the board in console
    }

    @Override
    public void startGame() {
        System.out.println("Starting game in console mode.");
        // Implementation to start the game in console
    }
}

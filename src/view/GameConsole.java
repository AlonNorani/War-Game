package view;
import model.Board;
import model.Piece;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;


public class GameConsole extends UserInterfaceAbstract{
    public GameConsole(Board gameBoard) {
        super(gameBoard);
    }

    private void displayBoard() {
        Piece[][] grid = board.getBoardState();
        for (int i = 0; i < board.ROWS; i++) {
            for (int j = 0; j < board.COLS; j++) {
                String content;
                if (grid[i][j] == null) {
                    content = " "; // empty space
                } else {
                    content = grid[i][j].toString();
                }

                // pad to width 2 (emoji or short text gets aligned)
                System.out.printf("[%-2s] ", content);
            }
            System.out.println();
        }
    }


    private int getValidPlayerCount(Scanner scanner) {
        int playersAmount = 0;
        while (true) {
            System.out.println("Please enter how many players will be playing (" + board.MIN_PLAYERS + "-" + board.MAX_PLAYERS + "): ");
            try {
                playersAmount = scanner.nextInt();
                if (playersAmount >= board.MIN_PLAYERS && playersAmount <= board.MAX_PLAYERS) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter a number between " + board.MIN_PLAYERS + " and " + board.MAX_PLAYERS + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between " + board.MIN_PLAYERS + " and " + board.MAX_PLAYERS + ".");
                scanner.next(); // Clear the invalid input
            }
        }
        return playersAmount;
    }

    private Map<Integer, String> getPlayersInfo(Scanner scanner, int playersAmount) {
        Map<Integer, String> playersInfo = new HashMap<>();
        for (int i = 1; i <= playersAmount; i++) {
            System.out.println("Enter name for Player " + i + ": ");
            String name = scanner.next();
            playersInfo.put(i, name);
        }
        return playersInfo;
    }

    private char getValidChar(Scanner scanner) {
        while (true) {
            String input = scanner.next();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter a single character.");
            }
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void startGame() {
        // setup game
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the War Game!!");
        int playersAmount = getValidPlayerCount(scanner);
        Map<Integer, String> playersInfo = getPlayersInfo(scanner, playersAmount);
        board.initializeBoard(playersInfo);

        // start game loop
        Board.ReturnCode code = Board.ReturnCode.SUCCESS;
        while(code != Board.ReturnCode.WIN) {
            clearConsole();
            displayBoard();
            System.out.println("It's the turn of " + board.getCurrentPlayerName());
            System.out.println("Enter move direction (U/D/R/L): ");
            char direction = getValidChar(scanner);
            try {
                code = board.movePlayer(direction);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (code == Board.ReturnCode.WIN) {
                displayBoard();
                System.out.println("Player " + board.getCurrentPlayerName() + " wins!");
            }
        }
        scanner.close();
    }
}

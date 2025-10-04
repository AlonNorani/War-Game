import java.util.HashMap;
import java.util.Map;
public class Game {
    private final int MIN_PLAYERS = 2;
    private final int MAX_PLAYERS = 5;
    private Board board;
    public Game(Map<Integer, String> playersInfo) {
        // validate players amount
        if (playersInfo.size() < MIN_PLAYERS || playersInfo.size() > MAX_PLAYERS) {
            throw new IllegalArgumentException("Players amount must be between" + MIN_PLAYERS + " and " + MAX_PLAYERS);
        }
        // init board with players info
        board = new Board(playersInfo);


    }
}

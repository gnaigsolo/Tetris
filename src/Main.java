import game.Game;

import java.awt.event.KeyEvent;


public class Main {
    public static void main(String[] args) {
        Game tetris = new Game();
        tetris.newGame();
        tetris.gameLoop();

    }
}

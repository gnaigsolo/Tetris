package game;

import cordinate.Vector2;
import tetrimino.Shape;
import tetrimino.ShapeFactory;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Game implements KeyListener {
    private Shape shape;
    private Ground ground;
    private ShapeFactory shapeFactory;
    private GraphicController graphicController;
    private GameConfig gameConfig;
    private boolean pause;
    private InputController inputController;

    public Game() {
        inputController = new Input();
        pause = false;
        gameConfig = TetrisGameConfig.getInstance();
        shapeFactory = gameConfig.getShapeFactory();
        graphicController = gameConfig.getGraphicController();
        graphicController.addKeyListener(this);
//        graphicController.addKeyListener(inputController);

        ground = new Ground2D();
        startRender();

    }

    public void updateGameElements() {
        if(pause)
            return;
//        handleInput();
        handleEvent();

//        inputController.resetInput();
    }

    public void newGame() {
        ground.clear();
        createNewShape();
        gameConfig.restart();
    }


    private void handleEvent() {

        if(isHitedGround()) {
            addShapeToGround();
            ground.clearRowThatIsFull();
            if(ground.isReachHeightLimit()) {
                gameOver();
            }
            else createNewShape();
        }

        moveShape("down");
        try {
            Thread.sleep(gameConfig.getDelayTime());

        } catch (Exception e) {
        }
    }

    synchronized public void render() {
        if(shape != null && ground != null && graphicController != null) {
            shape.draw();// draw shape
            ground.draw();// draw ground
            graphicController.render(); // render
        }
    }


    public void gameLoop() {
        while(true) {
            updateGameElements();
        }
    }


    private boolean isHitedGround() {
        List<Vector2> blocksPosition = shape.getBlocksPosition(); // get all blocks position
        for(var position : blocksPosition) {
            int x = position.getX();
            int y = position.getY();
            Vector2 blockBelowPosition = new Vector2(x, y -1); // count the position of the below block
            if(ground.isHasBlockAt(blockBelowPosition))
                return true;
        }
        return false;
    }

    private void addShapeToGround() {
        List<Vector2> blocksPosition = shape.getBlocksPosition(); // get all blocks position
        for(var position : blocksPosition) {
            ground.addBlockAt(position); // add to ground
        }
    }

    private void gameOver() {

        newGame(); // create new game
        gameLoop();

    }

    private void createNewShape() {
        Shape shape = shapeFactory.getShape();
        shape.setNewPosition(new Vector2(gameConfig.getNumberOfColumn()/2-1, gameConfig.getNumberOfRow()-1));
        this.shape = shape;
    }


    synchronized private void moveShape(String direction) {
        int dx = 0;  // move offset
        int dy = 0;
        if(direction.equals("up"))
            dy = 1;
        if(direction.equals("down"))
            dy = -1;
        if(direction.equals("left"))
            dx = -1;
        if(direction.equals("right"))
            dx = 1;

        // check if can move?
            // if yes: move
        Vector2 directionVector = new Vector2(dx, dy);
        if(isMoveable(directionVector)) {
            Vector2 currentShapePosition = shape.getCurrentPosition();
            int newX = currentShapePosition.getX() + dx;
            int newY = currentShapePosition.getY() + dy;
            Vector2 newPosition = new Vector2(newX, newY);
            shape.setNewPosition(newPosition);
        }
    }

    private boolean isMoveable(Vector2 direction) {
        List<Vector2> blockPosition = shape.getBlocksPosition();
        for(var position : blockPosition) { // loop over all of the blocks position
            int newX = position.getX() + direction.getX();
            int newY = position.getY() + direction.getY();
            Vector2 newPosition = new Vector2(newX, newY); // get new position of the block according to direction vector
            if(!isSafeToPutBlock(newPosition)) {
                return false;
            }
        }
        return true; // return true

    }

    private void changeShape(String direction) {
        // check if next shape is safe or not
            // yes: change
            // no: return;
        if(isSafeToChangeShape(direction)) {
            shape.change(direction);
        }
    }

    private boolean isSafeToPutBlock(Vector2 position) {
        int x = position.getX();
        int y = position.getY();
        int numberOfRow = gameConfig.getNumberOfRow();
        int numberOfColumn = gameConfig.getNumberOfColumn();
        if(x < 0 || x >= numberOfColumn || y < 0) // if out of map
            return false;
        if(ground.isHasBlockAt(position)) // if already have block
            return false;
        return true;
    }

    private boolean isSafeToChangeShape(String direction) {
        // get all blocks position of next shape
        // loop through them
            // check if it is safe to put block there
                // no: return false
        List<Vector2> nextStateBlocksPosition = shape.getNextStateBlocksPosition(direction);
        for( var nextPosition : nextStateBlocksPosition ) {
            if(!isSafeToPutBlock(nextPosition)) {
                return false;
            }
        }
        return true;
    }

    void handleInput() {
        if(inputController.getKeyDown(KeyEvent.VK_LEFT))
            moveShape("left");
        if(inputController.getKeyDown(KeyEvent.VK_RIGHT))
            moveShape("right");
        if(inputController.getKeyDown(KeyEvent.VK_UP))
            changeShape("next");
        if(inputController.getKeyDown(KeyEvent.VK_DOWN))
            moveShape("down");
        if(inputController.getKeyDown(KeyEvent.VK_SPACE))
            setShape();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            pause = !pause;
        if(pause)
            return;
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            moveShape("left");
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            moveShape("right");
        if(e.getKeyCode() == KeyEvent.VK_UP)
            changeShape("next");
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            moveShape("down");
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            setShape();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    void startRender() {
        Runnable renderTask = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    render();
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        };
        Thread renderThread = new Thread(renderTask);
        renderThread.start();
    }

    void setShape() {
        Runnable renderTask = new Runnable() {
            @Override
            public void run() {
                while(isMoveable(new Vector2(0, -1))) {
                    moveShape("down");
                    try {
                        Thread.sleep(3);
                    } catch (Exception e) {

                    }
                }
                addShapeToGround();
            }
        };
        Thread renderThread = new Thread(renderTask);
        renderThread.start();

    }

    void shapeFall() {

    }

}

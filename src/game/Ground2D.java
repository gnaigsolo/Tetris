package game;

import cordinate.Vector2;

import java.awt.*;

public class Ground2D implements Ground {
    private boolean[][] groundMatrix;
    private GameConfig gameConfig;
    private int numberOfColumn;
    private int numberOfRow;
    private GraphicController graphicController;
    Ground2D() {
        gameConfig = TetrisGameConfig.getInstance();
        numberOfColumn = gameConfig.getNumberOfColumn();
        numberOfRow = gameConfig.getNumberOfRow();
        graphicController = gameConfig.getGraphicController();
        groundMatrix = new boolean[numberOfRow + 2][numberOfColumn];
    }



    @Override
    public boolean isHasBlockAt(Vector2 position) {
        int x = position.getX();
        int y = position.getY();
        if(x<0 || x>=gameConfig.getNumberOfColumn() || y<0)
            return true;
        return groundMatrix[position.getY()][position.getX()];
    }

    @Override
    public void addBlockAt(Vector2 position) {
        if(position.getY() >= numberOfRow + 2)
            return;
        groundMatrix[position.getY()][position.getX()] = true;
    }

    @Override
    public void clearRowThatIsFull() {
        // duyệt qua từng hàng từ trên xuống dưới
            // kiểm tra nếu full
                // yes: xóa hàng
        for(int row = 0; row < numberOfRow; ++row)
            while(isFull(row)) {
                deleteRow(row);
                gameConfig.addBreakLine();
            }
    }

    @Override
    public boolean isReachHeightLimit() {
        // loop over highest row
            // check if a column is set or no
        int highestRowIndex = numberOfRow ;
        for(int column = 0; column < numberOfColumn; ++column) {
            if(groundMatrix[highestRowIndex][column])
                return true;
        }
        return false;
    }

    @Override
    public void draw() {
        Color groundColor = gameConfig.getGroundColor();
        for(int row = 0; row < numberOfRow; ++row) {
            for(int column = 0; column < numberOfColumn; ++column) {
                if(groundMatrix[row][column]) {
                    Vector2 positionToDraw = new Vector2(row, column);
                    graphicController.draw(positionToDraw, groundColor);
                }
            }
        }
    }

    @Override
    public void clear() {
        for(int row = 0; row < numberOfRow + 2; ++row) {
            for(int column = 0; column < numberOfColumn; ++column) {
                groundMatrix[row][column] = false;
            }
        }
    }

    private boolean isFull(int row) {
        for(int column = 0; column < numberOfColumn; ++column)
            if(!groundMatrix[row][column])
                return false;
        return true;
    }

    private void deleteRow(int rowToDelete) {
        // duyệt từ hàng cần xóa đến hàng sát cuối
            // copy hàng bên trên cho hàng hiện tại
        // xóa hàng cuối
        slowlyErase(rowToDelete);
        int lastRowIndex = numberOfRow + 2 - 1;
        for(int row = rowToDelete; row <= lastRowIndex - 1; ++row) {
            for(int col = 0; col < numberOfColumn; ++col)
                groundMatrix[row][col] = groundMatrix[row + 1][col];
        }
        for(int col = 0; col < numberOfColumn; col ++)
            groundMatrix[lastRowIndex][col] = false;

    }

    private void slowlyErase(int row ) {
        int midLeft = numberOfColumn/2;
        int midRight = (numberOfColumn + 1)/2;
        while(true) {
            groundMatrix[row][midLeft] = false;
            groundMatrix[row][midRight] = false;
            midLeft--;
            midRight++;
            if(midLeft == 0)
                break;
            try {
                Thread.sleep(gameConfig.getDelayTime() / 20);
            } catch (Exception e) {
            }
        }

    }
}

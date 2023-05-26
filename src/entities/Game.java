/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import entities.Cell;
import entities.enums.CellType;

/**
 *
 * @author Cert
 */
public class Game {
    public static final int DIRECTION_NONE = 0,
                            DIRECTION_RIGHT = 1,
                            DIRECTION_LEFT = -1,
                            DIRECTION_UP = 2,
                            DIRECTION_DOWN = -2;
    
    private Snake snake;
    public Board board;
    
    private Cell cell;
    
    public int direction;
    public boolean gameOver;
    
    public Game(Snake snake, Board board){
        this.snake = snake;
        this.board = board;
        
    }
    public void setGameOver(boolean status){
        this.gameOver = status;
    }
    
    public void setDirection(int str){
        this.direction = str;
    }
    
    public Snake getSnake(){
        return snake;
    }
    public void setSnake(Snake snake){
        this.snake = snake;
    }
    
    public Board getBoard(){
        return board;
    }
    
    public void setBoard(Board board){
        this.board = board;
    }
    
    public boolean isGameOver(){
        return gameOver;
    }
    

    private Cell getNextCell(Cell currentPosition)
    {
        System.out.println("Going to find next cell");
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();
 
        if (direction == DIRECTION_RIGHT) {
            col++;
        }
        else if (direction == DIRECTION_LEFT) {
            col--;
        }
        else if (direction == DIRECTION_UP) {
            row--;
        }
        else if (direction == DIRECTION_DOWN) {
            row++;
        }
 
        Cell nextCell = board.getCells()[row][col];
 
        return nextCell;
    }
    
    public void update(){
        System.out.println("Atualizando o game!");
        if (!gameOver) {
            if (direction != DIRECTION_NONE) {
                Cell nextCell
                    = getNextCell(snake.getHead());
 
                if (snake.checkCrash(nextCell)) {
                    setDirection(DIRECTION_NONE);
                    gameOver = true;
                }
                else {
                    snake.move(nextCell);
                    if (nextCell.getCellType()
                        == CellType.FOOD) {
                        snake.grow();
                        board.generatedFood();
                    }
                }
            }
        }
    }
    
}

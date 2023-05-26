/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import entities.Board;
import entities.Cell;
import entities.Game;
import static entities.Game.DIRECTION_RIGHT;
import entities.Snake;

/**
 *
 * @author Cert
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("O jogo vai iniciar.");
        
        Cell initPos = new Cell(0, 0);
        Snake initSnake = new Snake(initPos);
        Board board = new Board(10, 10);
        Game newGame = new Game(initSnake, board);
        newGame.setGameOver(false);
        newGame.setDirection(1);
        
        for(int i = 0; i<5 ; i++){
            if(i == 2){
                newGame.board.generatedFood();
                newGame.update();
            }
            if (i == 3)
                newGame.direction = DIRECTION_RIGHT;
            if (newGame.gameOver == true)
                break;
        }
    }
    
}

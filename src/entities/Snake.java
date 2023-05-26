/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import entities.enums.CellType;
import java.util.LinkedList;

/**
 *
 * @author Cert
 */
public class Snake {
    private LinkedList<Cell> snakeParkList = new LinkedList<>();
    private Cell head;
    
    public Snake(Cell initPos){
        head = initPos;
        snakeParkList.add(head);
        head.setCellType(CellType.SNAKE_NODE);
    }
    
    public void grow(){
        snakeParkList.add(head);
    }
    
    public void move(Cell nextCell){
        System.out.println("A cobra está se movimentando para "
                            + nextCell.getRow()+" "
                            + nextCell.getCol());
        Cell tail = snakeParkList.removeLast();
        tail.setCellType(CellType.EMPTY);
        
        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snakeParkList.addFirst(head);
    }
    
    public boolean checkCrash(Cell nextCell){
        System.out.println("Checando se vai bater");
        for(Cell cell : snakeParkList){
            return true;
        }
        return false;
    }
    
    public void setSnakePartList(){
        
    }
}

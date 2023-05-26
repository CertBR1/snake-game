/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import entities.enums.CellType;

/**
 *
 * @author Cert
 */
public class Board {
    final int ROW_COUNT, COL_COUNT;
    private Cell[][] cells;
    
    public Board(int rowCount, int colCount){
        ROW_COUNT = rowCount;
        COL_COUNT = colCount;
        
        cells = new Cell[ROW_COUNT][COL_COUNT];
        for(int row =0; row< ROW_COUNT; row++){
            for (int column = 0; column < COL_COUNT; column++){
                cells[row][column] = new Cell(row, column);
            }
        }
    }
    public Cell[][] getCells(){
        return cells;
    }
    
    public void setCells(Cell[][] cells){
        this.cells = cells;
    }
    
    public void generatedFood(){
        System.out.println("Gerando comida");
        int row = 0, column =0;
        while (true) { 
            row = (int)(Math.random()*ROW_COUNT);
            column = (int)(Math.random() * COL_COUNT);
            if(cells[row][column].getCellType() != CellType.SNAKE_NODE){
                break;
            }
            cells[row][column].setCellType(CellType.FOOD);
            cells[row][column].setCellType(CellType.FOOD);
            System.out.println("A comida foi gerada em: " + row
                               + " " + column);
        }
    }
}

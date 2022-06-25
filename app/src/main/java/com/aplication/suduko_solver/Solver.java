package com.aplication.suduko_solver;

import java.util.Random;

public class Solver {
    private int current_Row , current_Column ;
    private int [][]board ;
    public Solver ( ){

        this.current_Column = -1;
        this.current_Row = -1;
        this.board = new int[9][9];
        this.setBoardZERO();
    }

    public int getCurrent_Row() { return current_Row; }
    public void setCurrent_Row(int current_Row) {
        this.current_Row = current_Row;
    }
    public int getCurrent_Column() {
        return current_Column;
    }
    public void setCurrent_Column(int current_Column) {
        this.current_Column = current_Column;
    }


    public void setBoardZERO( ) {
        for ( int y =0 ; y<9 ; y++ ) {
            for (int x = 0 ; x<9 ; x++ ){
                this.board[y][x] = 0;
            }
        }
    }
    public void showBoard( ) {
        System.out.print(" { ");
        for ( int y =0 ; y<9 ; y++ ) {
            for (int x = 0 ; x<9 ; x++ ){
                System.out.print( this.board[y][x]  + ",");
            }
            System.out.println("");
        }
        System.out.print("{ ");
    }
    public void setValueAt(int x , int y , int value) {
        this.board[x][y] = value;
    }
    public void setZeroAt(int x , int y) {
        this.board[x][y] = 0;
    }

    public int getValueAt(int x , int y) {
        return this.board[x][y] = 0;
    }
    public  int getCurrentValue( ) {
        return (this.current_Column >-1 && this.current_Row>-1)?this.board[this.current_Column] [this.current_Row] : 0;
    }


    public void fill_withRandomNumber( ) {
        Random random = new Random();
        for (int y=0 ; y<9 ; y++) {
            for (int x = 0 ; x<9 ; x++ ){

                this.board[y][x] = Math.abs(random.nextInt() % 10 );
            }
        }
    }
}

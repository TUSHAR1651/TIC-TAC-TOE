package org.example.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellstate;
    private Player player;

    public Cell(int row, int col ) {
        this.row = row;
        this.col = col;
        this.cellstate = CellState.EMPTY;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setCellstate(CellState cellstate) {
        this.cellstate = cellstate;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    public CellState getCellstate() {
        return cellstate;
    }

    public Player getPlayer() {
        return player;
    }
}

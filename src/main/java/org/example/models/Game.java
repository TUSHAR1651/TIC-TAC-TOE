package org.example.models;
import org.example.Exception.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;
public class Game {
    private Board board;
    private List<Player> player;
    private List<Move> move;
    private GameState gameState;
    private Player winner;
    private int nextPlayerMoveIndex;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public List<Move> getMove() {
        return move;
    }

    public void setMove(List<Move> move) {
        this.move = move;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }
    public void printBoard(){
        this.board.printBoard();
    }
    private boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        if(row < 0 || row > board.getSize() || col<0 ||  col >= board.getSize()){
            return false;
        }
        return board.getBoard().get(row).get(col).getCellstate().equals(CellState.EMPTY);
    }
    public void makeMove() throws  InvalidMoveException{
        Player currentPlayer = player.get(nextPlayerMoveIndex);

        // Move the current player wants to make
        Move move = currentPlayer.makeMove(board);

        // Game will validate before excuting
        if(!validateMove(move)){
            throw new InvalidMoveException("Invalid move made by "+currentPlayer.getName());
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellstate(CellState.FILLED);

        Move finalMove = new Move(cellToChange,currentPlayer);
        nextPlayerMoveIndex=(nextPlayerMoveIndex+1)%player.size();
        return;
    }

    public Game(int dimensions, List<Player> players){
        this.board = new Board(dimensions);
        this.player = players;
        this.move = new ArrayList<>();
        this.gameState = GameState.In_PROGRESS;
        this.winner = null;
        this.nextPlayerMoveIndex = 0;
    }

}

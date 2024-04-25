package org.example;

import org.example.Controller.GameController;
import org.example.Exception.InvalidMoveException;
import org.example.models.*;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner s = new Scanner(System.in);
        GameController gameController = new GameController();

        System.out.println("Please enter the game Dimensions");
        int dimensions = s.nextInt();
        List<Player> players = List.of(
                new Player("Tushar",new Symbol('X'), PlayerType.HUMAN),
                new Bot("Ronit" , new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.Easy)
    );
        Game game = gameController.startGame(dimensions,players);
//        gameController.printBoard(game);
        while(game.getGameState().equals(GameState.In_PROGRESS)){
            gameController.printBoard(game);

            gameController.makeMove(game);

        }
        if(!gameController.checkState(game).equals(GameState.Ended)){
            game.setGameState(GameState.DRAW);
            System.out.println("Game Drawn");
        }
        else{
            gameController.printBoard(game);
            System.out.println("Player "+ gameController.getWinner(game).getName()+ " is the winner");
        }
    }
}
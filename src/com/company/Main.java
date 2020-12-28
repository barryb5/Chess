package com.company;

public class Main {

    public static void main(String[] args) {

        ChessBoard cb = new ChessBoard();
        Player pb = new Player(Player.PlayerType.Black);
        Player pw = new Player(Player.PlayerType.White);

        cb.resetBoard();
        cb.printBoard();
        cb.move(new Coordinates(0, 1), new Coordinates(0, 2), pb);
        cb.printBoard();
    }
}

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
        cb.move(new Coordinates(0, 2), new Coordinates(0, 3), pb);
        cb.printBoard();
        cb.move(new Coordinates(0, 3), new Coordinates(0, 4), pb);
        cb.printBoard();
        cb.move(new Coordinates(0, 4), new Coordinates(0, 5), pb);
        cb.printBoard();
        cb.move(new Coordinates(0, 5), new Coordinates(1, 6), pb);
        cb.printBoard();
        cb.move(new Coordinates(1, 6), new Coordinates(0, 7), pb);
        cb.printBoard();
        cb.move(new Coordinates(0, 0), new Coordinates(0, 4), pb);
        cb.printBoard();
        cb.move(new Coordinates(1, 0), new Coordinates(0, 2), pb);
        cb.printBoard();
        cb.move(new Coordinates(0, 2), new Coordinates(2, 3), pb);
        cb.printBoard();
        cb.move(new Coordinates(1, 1), new Coordinates(1, 2), pb);
        cb.printBoard();
        cb.move(new Coordinates(2, 0), new Coordinates(0, 2), pb);
        cb.printBoard();
    }
}

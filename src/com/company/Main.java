package com.company;

public class Main {

    public static void main(String[] args) {

        ChessBoard cb = new ChessBoard();
        Player pb = new Player(Player.PlayerType.Black);
        Player pw = new Player(Player.PlayerType.White);

        cb.resetBoard();

        Piece[][] grid = new Piece[8][8];

        grid[0][0] = new Pawn(cb, Player.PlayerType.Black);

        cb.printBoard();


    }
}

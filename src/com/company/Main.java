package com.company;

public class Main {

    public static void main(String[] args) {

        ChessBoard cb = new ChessBoard();
        Player pb = new Player(Player.PlayerType.Black);
        Player pw = new Player(Player.PlayerType.White);

        Piece[] grid = new Piece[8];

        grid[0] = new Pawn(cb, pb.getPlayerType());
        grid[1] = new Pawn(cb, pw.getPlayerType());
        grid[2] = new King(cb, pb.getPlayerType());
        grid[3] = new King(cb, pw.getPlayerType());


        System.out.println(grid[0].getPlayerType() + " " + grid[0].print());
        System.out.println(grid[1].getPlayerType() + " " + grid[1].print());
        System.out.println(grid[2].getPlayerType() + " " + grid[2].print());
        System.out.println(grid[3].getPlayerType() + " " + grid[3].print());


    }
}

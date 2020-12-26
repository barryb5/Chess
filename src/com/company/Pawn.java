package com.company;

public class Pawn extends Piece {
    Pawn(ChessBoard board, Player.PlayerType type)
    {
        super(board, type);
    }

    @Override
    public boolean move(Coordinates beg, Coordinates end)
    {
        /**
         * mult will tell me if the player is white or black
         * isKilling tells me if the player is taking an enemy piece
         */
        int mult = Player.PlayerType.White == type ? 1 : -1;
        boolean isKilling = false;

        if (board.grid[end.r][end.c] != null) {
            isKilling = true;
        }

        if (isKilling = true) {
            System.out.println("Murder is possible");
            // Checks color and adjusts for it
            if (mult == 1) {
                // Pawn is white
                // Checks if enemy is diagonal to pawn
                if (Math.abs(end.r - beg.r) != 1 || Math.abs(end.c - beg.c) != 1) {
                    System.out.println("Enemy is not in killing sight");
                    return false;
                } else {
                    System.out.println("Enemy is correct distance away");
                }
                // Checks if enemy is ahead of pawn


                board.grid[end.r][end.c] = null;
                board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
                System.out.println("Murder Successful");
            } else {

                System.out.println("Murder Successful");
            }


        } else {
            // Pawn is black
            // Checks if enemy is diagonal to pawn
            if (Math.abs(end.r - beg.r) != 1 || Math.abs(end.c - beg.c) != 1) {
                System.out.println("Enemy is not in killing sight");
                return false;
            } else {
                System.out.println("Enemy is correct distance away");
            }
            // Checks if enemy is ahead of pawn

            board.grid[end.r][end.c] = null;
            board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
            return true;
        }

        return true;
    }

    @Override
    public String print()
    {
        if (this.type == Player.PlayerType.White)
            return "WP";
        else
            return "BP";
    }
}
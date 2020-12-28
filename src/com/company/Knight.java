package com.company;

public class Knight extends Piece{
    Knight(ChessBoard board, Player.PlayerType type)
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

        // If end coordinates have an enemy in sight, set isKilling to true
        if (board.grid[end.r][end.c] != null)
            isKilling = true;

        // Checks if movement makes the "L" shape
        if (Math.abs(end.c - beg.c) == 1 && Math.abs(end.r - beg.r) == 2
            || Math.abs(end.c - beg.c) == 2 && Math.abs(end.r - beg.r) == 1) {
            System.out.println("Movement amount is correct");
        } else {
            System.out.println("Movement amount is incorrect");
            return false;
        }
        // If killing
        if (isKilling == true) {
            System.out.println("Murder is possible");
            board.grid[end.r][end.c] = null;
            board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
            board.grid[beg.r][beg.c] = null;
            System.out.println("Murder Successful");
        } else {
            // If not killing
            board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
            board.grid[beg.r][beg.c] = null;
            System.out.println("Movement successful");
            return true;
        }

        return true;
    }

    @Override
    public String print()
    {
        if (this.type == Player.PlayerType.White)
            return "Wk";
        else
            return "Bk";
    }
}

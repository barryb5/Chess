package com.company;

public class King extends Piece {
    King(ChessBoard board, Player.PlayerType type) {
        super(board, type);
    }

    @Override
    public boolean move(Coordinates beg, Coordinates end) {
        /**
         * mult will tell me if the player is white or black
         * isKilling tells me if the player is taking an enemy piece
         */
        int mult = Player.PlayerType.White == this.type ? 1 : -1;
        boolean isKilling = false;

        if (board.grid[end.r][end.c] != null) {
            isKilling = true;
        }
        // Check that king is moving correct amount
        if((Math.abs(end.c - beg.c) == 1 && Math.abs(end.r - beg.r) == 1)
                || (Math.abs(end.r - beg.r) == 1 && Math.abs(end.c - beg.c) == 0)
                || (Math.abs(end.r - beg.r) == 0 && Math.abs(end.c - beg.c) == 1)
                || (Math.abs(end.r - beg.r) == 0 && Math.abs(end.c - beg.c) == 0)) {
            System.out.println("King is moving correct amount");
        } else {
            System.out.println("King isn't moving the correct amount");
        }
        // If killing
        if (true == isKilling) {
            System.out.println("Murder by king is possible");
            board.grid[end.r][end.c] = null;
            board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
            board.grid[beg.r][beg.c] = null;
            System.out.println("Murder by king is successful");
        } else {
            // If not killing
            board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
            board.grid[beg.r][beg.c] = null;
            System.out.println("King movement successful");
            return true;
        }

        return true;
    }

    @Override
    public String print()
    {
        if (this.type == Player.PlayerType.White)
            return "WK";
        else
            return "BK";
    }
}

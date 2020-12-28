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
            System.out.println("Moving correct amount");
        } else {
            System.out.println("Not moving correct amount");
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

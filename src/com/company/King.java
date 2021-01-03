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
         * isCastling decides if the King is castling
         */
        int mult = Player.PlayerType.White == this.type ? 1 : -1;
        boolean isKilling = false;

        if (mult == 1 && beg.r == 3 && beg.c == end.c && end.r == 1 && board.grid[1][0] == null/* King is trying to castle */ && board.grid[0][0] != null/* Rook is in correct position */) {
            // King is White
            if (board.grid[2][0] == null) {
                // Check if knight and bishop spaces are free
                board.grid[2][0] = board.grid[0][0];
                board.grid[1][0] = board.grid[3][0];
                board.grid[0][0] = null;
                board.grid[3][0] = null;
                return true;

            }
        } else if (mult == -1 && beg.r == 4 && end.r == 6 && beg.c == end.c && board.grid[6][7] == null/* King is trying to castle */ && board.grid[7][7] != null/* Rook is in correct position */) {
            // King is Black
            if (board.grid[5][7] == null) {
                // Check if knight and bishop spaces are free
                board.grid[6][7] = board.grid[4][7];
                board.grid[5][7] = board.grid[7][7];
                board.grid[4][7] = null;
                board.grid[7][7] = null;
                return true;

            }
        }

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

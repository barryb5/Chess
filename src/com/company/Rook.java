package com.company;

public class Rook extends Piece {
    Rook(ChessBoard board, Player.PlayerType type)
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

        if ((Math.abs(end.r - beg.r) != 0 && Math.abs(end.c - beg.c) == 0)
            || (Math.abs(end.r - beg.r) == 0 && Math.abs(end.c - beg.c) != 0)) {
            System.out.println("Moving direction is correct");
        } else {
            System.out.println("Rook cannot move diagonally");
            return false;
        }

        if (Math.abs(end.r - beg.r) != 0 && Math.abs(end.c - beg.c) == 0) {
            // Checks that nothing is in the way rook movement for the row

            if (beg.r < end.r) {
                for (int i = beg.r + 1; i < end.r; i++) {
                    if (board.grid[i][end.c] != null) {
                        System.out.println("There is an object in the way");
                        return false;
                    }
                }
            } else {
                for (int i = end.r + 1; i < beg.r; i++) {
                    if (board.grid[i][beg.c] != null) {
                        System.out.println("There is an object in the way");
                        return false;
                    }
                }
            }

        } else if (Math.abs(end.r - beg.r) == 0 && Math.abs(end.c - beg.c)!= 0) {
            // Checks that nothing is in the way rook movement for the column
            if (beg.c < end.c) {
                for (int i = beg.c + 1; i < end.c; i++) {
                    if (board.grid[end.r][i] != null) {
                        System.out.println("There is an object in the way");
                        return false;
                    }
                }
            } else {
                for (int i = beg.c + 1; i < end.c; i++) {
                    if (board.grid[end.r][i] != null) {
                        System.out.println("There is an object in the way");
                        return false;
                    }
                }
            }

        } else {
            System.out.println("There is an object in the way");
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
            return true;
        }
        return true;
    }

    @Override
    public String print()
    {
        if (this.type == Player.PlayerType.White)
            return "WR";
        else
            return "BR";
    }
}

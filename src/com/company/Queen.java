package com.company;

public class Queen extends Piece{
    Queen(ChessBoard board, Player.PlayerType type)
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

        if ((Math.abs(end.r - beg.r) != 0 && Math.abs(end.c - beg.c) == 0)
                || (Math.abs(end.r - beg.r) == 0 && Math.abs(end.c - beg.c) != 0)) {
            // Queen movement is vertical/horizontal
            if (beg.r < end.r) {
                for (int i = beg.r + 1; i < end.r; i++) {
                    if (board.grid[i][end.c] != null) {
                        System.out.println("There is an object in the way of the Queen vertical movement");
                        return false;
                    }
                }
            } else {
                for (int i = end.r + 1; i < beg.r; i++) {
                    if (board.grid[i][beg.c] != null) {
                        System.out.println("There is an object in the way of the Queen horizontal movement");
                        return false;
                    }
                }
            }
        } else if (Math.abs(end.r - beg.r) == Math.abs(end.c - beg.c)) {
            // Diagonal queen movement
            if (beg.c > end.c) {
                if (beg.r > end.r) {
                    for (int i = end.c; i < beg.c; i++) {
                        for (int j = end.r; j < beg.r; j++) {
                            if (board.grid[i][j] != null) {
                                System.out.println("Something is in the way of the Queen diagonal movement");
                                return false;
                            }
                        }
                    }
                } else {
                    for (int i = beg.c; i > end.c; i--) {
                        for (int j = beg.r; j > end.r; j--) {
                            if (board.grid[i][j] != null) {
                                System.out.println("Something is in the way of the Queen diagonal movement");
                                return false;
                            }
                        }
                    }
                }
            } else {
                if (beg.r > end.r) {
                    for (int i = beg.c; i < end.c; i++) {
                        for (int j = end.r; j > beg.r; j--) {
                            if (board.grid[i][j] != null) {
                                System.out.println("Something is in the way of the Queen diagonal movement");
                                return false;
                            }
                        }
                    }
                } else {
                    for (int i = beg.c; i < end.c; i++) {
                        for (int j = beg.r; j < beg.r; j++) {
                            if (board.grid[i][j] != null) {
                                System.out.println("Something is in the way of the Queen diagonal movement");
                                return false;
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Queen movement is not diagonal or horizontal/vertical");
            return false;
        }

            // If killing
        if (true == isKilling) {
            System.out.println("Murder is possible for bishop");
            board.grid[end.r][end.c] = null;
            board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
            board.grid[beg.r][beg.c] = null;
            System.out.println("Murder by bishop is successful");
        } else {
            // If not killing
            board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
            board.grid[beg.r][beg.c] = null;
            System.out.println("Bishop movement successful");
            return true;
        }
        return true;
    }

    @Override
    public String print()
    {
        if (this.type == Player.PlayerType.White)
            return "WQ";
        else
            return "BQ";
    }

}

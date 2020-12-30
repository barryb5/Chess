package com.company;

public class ChessBoard {
    final int size = 8;
    final public Piece[][] grid = new Piece[size][size];

    ChessBoard() {
        // when the board is created reset the board
        resetBoard();
    }

    // prints the board
    public void printBoard() {
        System.out.print(" j");
        for (int i = 0; i < size; ++i)
            System.out.print("   " + i + " ");
        System.out.println();
        System.out.print("  -");
        for (int i = 0; i < size + 2; ++i)
            System.out.print(" - -");
        System.out.println();
        for (int i = 0; i < size; ++i) {
            System.out.print(i + " | ");
            for (int j = 0; j < size; ++j) {
                if (grid[i][j] != null)
                    System.out.print(grid[i][j].print() + " | ");
                else
                    System.out.print("   | ");
            }
            System.out.println();
            if (i != size - 1)
                System.out.print("  |");
            else
                System.out.print("  -");
            for (int j = 0; j < size; ++j) {
                System.out.print(" -- ");
                if (i == size - 1)
                    System.out.print("-");
                else if (j == size - 1)
                    System.out.print("|");
                else
                    System.out.print("+");
            }
            System.out.println("");
        }
        System.out.println("i");
    }

    // resets the board
    public void resetBoard() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (j == 1) {
                    grid[i][j] = new Pawn(this, Player.PlayerType.Black);
                } else if (j == 6) {
                    grid[i][j] = new Pawn(this, Player.PlayerType.White);
                } else if (j == 0 && i == 0 || j == 0 && i == 7) {
                    grid[i][j] = new Rook(this, Player.PlayerType.Black);
                } else if (j == 7 && i == 0 || j == 7 && i == 7) {
                    grid[i][j] = new Rook(this, Player.PlayerType.White);
                } else if ((j == 0 && i == 1) || (j == 0 && i == 6)) {
                    grid[i][j] = new Knight(this, Player.PlayerType.Black);
                } else if ((j == 7 && i == 1) || (j == 7 && i == 6)) {
                    grid[i][j] = new Knight(this, Player.PlayerType.White);
                } else if ((j == 0 && i == 2) || (j == 0 && i == 5)) {
                    grid[i][j] = new Bishop(this, Player.PlayerType.Black);
                } else if ((j == 7 && i == 2) || (j == 7 && i == 5)) {
                    grid[i][j] = new Bishop(this, Player.PlayerType.White);
                }
            }
        }
    }

    public boolean checkWinner() {
        return false;
    }


    public boolean move(Coordinates beg, Coordinates end, Player player) {
        if ((beg.r < 0) ||
                (beg.c < 0) ||
                (beg.r > size - 1) ||
                (beg.c > size - 1) ||
                (end.r < 0) ||
                (end.c < 0) ||
                (end.r > size - 1) ||
                (end.c > size - 1) ||
                (grid[beg.r][beg.c] == null) ||
                (grid[beg.r][beg.c].type != player.getPlayerType()) ||
                (grid[end.r][end.c].type == player.getPlayerType()))
            return false;

        boolean success = grid[beg.r][beg.c].move(beg, end);

        if (!success) {
            System.out.format("Movement not possible for %s", grid[beg.r][beg.c].print());
        } else {
            grid[beg.r][beg.c].move(beg, end);
        }

        return true;
    }
}

package com.company;
import java.lang.*;

public class Board {
    final int size = 8;

    public enum BoardPiece {
        Empty {
            public String toString() {
                return "  ";
            }
        },
        WhitePawn {
            public String toString() {
                return "WP";
            }
        },
        BlackPawn {
            public String toString() {
                return "BP";
            }
        },
        WhiteRook {
            public String toString() {
                return "WR";
            }
        },
        BlackRook {
            public String toString() {
                return "BR";
            }
        },
        WhiteKnight {
            public String toString() {
                return "WN";
            }
        },
        BlackKnight {
            public String toString() {
                return "BN";
            }
        },
        WhiteBishop {
            public String toString() {
                return "WB";
            }
        },
        BlackBishop {
            public String toString() {
                return "BB";
            }
        },
        WhiteQueen {
            public String toString() {
                return "WQ";
            }
        },
        BlackQueen {
            public String toString() {
                return "BQ";
            }
        },
        WhiteKing {
            public String toString() {
                return "WK";
            }
        },
        BlackKing {
            public String toString() {
                return "BK";
            }
        }
    }

    Board() {
        // when the board is created reset the board
        resetBoard();
    }

    final private BoardPiece[][] grid = new BoardPiece[size][size];

    public void resetBoard() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                grid[i][j] = null;
            }
        }
    }

    public boolean move(Coordinates c1, Coordinates c2, Player player) {
        BoardPiece thisPiece = (player.getPlayerType() == Player.PlayerType.Black) ? BoardPiece.Black : BoardPiece.White; // Need to create a
        BoardPiece otherPiece = (player.getPlayerType() == Player.PlayerType.Black) ? BoardPiece.White : BoardPiece.Black;

        if ((c1.r < 0) ||
                (c1.c < 0) ||
                (c1.r > size - 1) ||
                (c1.c > size - 1) ||
                (c2.r < 0) ||
                (c2.c < 0) ||
                (c2.r > size - 1) ||
                (c2.c > size - 1) ||
                (grid[c1.r][c1.c] == otherPiece) ||
                (grid[c2.r][c2.c] != BoardPiece.Empty))
            return false;



        return true;
    }

    public boolean checkWinner() {
        boolean white = false;
        boolean black = false;
        // check if no more pieces are left of either black or white
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (grid[i][j] == BoardPiece.BlackBishop
                        || grid[i][j] == BoardPiece.BlackBishop
                        || grid[i][j] == BoardPiece.BlackKing
                        || grid[i][j] == BoardPiece.BlackKnight
                        || grid[i][j] == BoardPiece.BlackPawn
                        || grid[i][j] == BoardPiece.BlackQueen
                        || grid[i][j] == BoardPiece.BlackRook)
                    black = true;
                else if (grid[i][j] == BoardPiece.WhiteBishop
                        || grid[i][j] == BoardPiece.WhiteKing
                        || grid[i][j] == BoardPiece.WhiteKnight
                        || grid[i][j] == BoardPiece.WhitePawn
                        || grid[i][j] == BoardPiece.WhiteQueen
                        || grid[i][j] == BoardPiece.WhiteRook)
                    white = true;
            }
        }
        // if there aren't any white pieces left the black wins
        if (!white) {
            System.out.println("Black wins");
            return true;
        }
        // if there aren't any black pieces left white wins
        else if (!black) {
            System.out.println("White wins");
            return true;
        }
        return false;
    }
}

package com.company;

public class King extends Piece {
    King(ChessBoard board, Player.PlayerType type) {
        super(board, type);
    }

    @Override
    public boolean move(Coordinates beg, Coordinates end) {
        return true;
    }

    @Override
    public String print()
    {
        if (this.type == Player.PlayerType.White)
            return "wK";
        else
            return "bK";
    }
}

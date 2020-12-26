package com.company;

public class Rook extends Piece {
    Rook(ChessBoard board, Player.PlayerType type)
    {
        super(board, type);
    }

    @Override
    public boolean move(Coordinates beg, Coordinates end)
    {
        int mult = Player.PlayerType.White == type ? 1 : -1;
        boolean isKilling = false;
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

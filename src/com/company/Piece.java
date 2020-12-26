package com.company;

abstract public class Piece {
    ChessBoard board;
    Player.PlayerType type;

    public Piece(ChessBoard board, Player.PlayerType type)
    {
        this.board = board;
        this.type = type;
    }

    public String player()
    {
        if (this.type == Player.PlayerType.Black)
            return "black";
        else
            return "white";
    }

    public abstract boolean move(Coordinates beg, Coordinates end);
    public abstract String print();

    public Player.PlayerType getPlayerType()
    {
        return this.type;
    }
}

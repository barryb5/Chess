package com.company;

public class Piece {
    ChessBoard board;
    Player.PlayerType type;

    public Token(ChessBoard board, Player.PlayerType type)
    {
        this.board = board;
        this.type = type;
    }

    public abstract boolean move(Coordinates beg, Coordinates end);
    public abstract String print();

    public Player.PlayerType getPlayerType()
    {
        return this.type;
    }
}

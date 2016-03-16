package com.ske.snakebaddesign.models;

import android.util.Log;

import java.util.Random;

/**
 * Created by YukiReii on 16/3/2559.
 */
public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayer;
    public Game(int size){
        board = new Board(size);
        players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
        currentPlayer = 0;
    }

    public Board getBoard() {
        return board;
    }

    public int takeTurn(){
        int rolledNumber = movePiece();
        currentPlayer = (currentPlayer+1)%2;
        board.shuffle();
        return rolledNumber;
    }

    private int movePiece(){
        int rolledNumber = players[currentPlayer].rollDie();
        Log.w("Board Square",board.getSquare(currentPlayer).effect(rolledNumber)+"");
        int current = board.getPiece(currentPlayer).getPosition() + board.getSquare(currentPlayer).effect(rolledNumber);
        int maxSquare = board.getSize() * board.getSize() - 1;
        if(current > maxSquare) {
            current = maxSquare - (current - maxSquare);
        }else if (current<0){
            current = Math.abs(current);
        }
        board.getPiece(currentPlayer).moveTo(current);
        return rolledNumber;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
    public int checkWin(){
        if (board.getPiece(0).getPosition() == board.getSize() * board.getSize() - 1) {
            return 1;
        } else if (board.getPiece(1).getPosition() == board.getSize() * board.getSize() - 1) {
            return 2;
        } else {
            return 0;
        }
    }
    public void reset(){
        board = new Board(board.getSize());
        players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
        currentPlayer = 0;
    }
}

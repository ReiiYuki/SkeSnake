package com.ske.snakebaddesign.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by YukiReii on 16/3/2559.
 */
public class Board {
    private int size;
    private List<Square> squares;
    private Piece[] pieces;
    public Board(int size){
        this.size = size;
        initSquare();
        initPiece();
        shuffle();
    }
    private void initSquare(){
        squares = new ArrayList<Square>();
        for (int i = 0;i<size*size;i++){
            if (i%5==0) squares.add(new ReverseSquare());
            else if(i%7==0) squares.add(new TeleportSquare());
            else squares.add(new NormalSquare());
        }
    }
    public void shuffle(){
        Collections.shuffle(squares);
    }

    public int getSize() {
        return size;
    }

    public Square getSquare(int index){
        return squares.get(index);
    }

    public void initPiece(){
        pieces = new Piece[2];
        pieces[0] = new Piece();
        pieces[1] = new Piece();
    }

    public Piece getPiece(int index){
        return pieces[index];
    }

}

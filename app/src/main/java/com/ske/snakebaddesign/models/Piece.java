package com.ske.snakebaddesign.models;

/**
 * Created by YukiReii on 16/3/2559.
 */
public class Piece {
    private int position;
    public Piece(){
        position = 0;
    }
    public void moveTo(int position){
        this.position = position;
    }
    public int getPosition(){
        return position;
    }
}

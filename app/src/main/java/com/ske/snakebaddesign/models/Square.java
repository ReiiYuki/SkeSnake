package com.ske.snakebaddesign.models;

/**
 * Created by YukiReii on 16/3/2559.
 */
public abstract class Square implements Effective{
    private int color;
    public abstract int effect(int position);
    public Square(int color){
        this.color = color;
    }
    public int getColor() {
        return color;
    }
}

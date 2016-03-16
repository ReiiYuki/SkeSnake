package com.ske.snakebaddesign.models;

import android.graphics.Color;

/**
 * Created by YukiReii on 16/3/2559.
 */
public class NormalSquare extends Square {
    public NormalSquare(){
        super(Color.parseColor("#21F38A"));
    }
    public int effect(int position){
        return position;
    }
}

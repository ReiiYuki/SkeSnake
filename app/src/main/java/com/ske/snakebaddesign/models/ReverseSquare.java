package com.ske.snakebaddesign.models;

import android.graphics.Color;

/**
 * Created by YukiReii on 16/3/2559.
 */
public class ReverseSquare extends Square{
    public ReverseSquare(){
        super(Color.parseColor("#3CE194"));
    }
    @Override
    public int effect(int position) {
        return position*-1;
    }
}

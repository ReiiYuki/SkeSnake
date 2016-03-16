package com.ske.snakebaddesign.models;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by YukiReii on 16/3/2559.
 */
public class TeleportSquare extends Square{
    public TeleportSquare(){
        super(Color.parseColor("#C83CE1"));
    }
    @Override
    public int effect(int position) {
        return (1+new Random().nextInt(position));
    }
}

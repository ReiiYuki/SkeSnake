package com.ske.snakebaddesign.models;

import java.util.Random;

/**
 * Created by YukiReii on 16/3/2559.
 */
public class Die{
    private static Die die;
    private Die(){}
    public static Die getInstance(){
        if (die==null) die = new Die();
        return die;
    }
    public int getRolledNumber(){
        return 1 + new Random().nextInt(6);
    }
}

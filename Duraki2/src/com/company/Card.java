package com.company;

/**
 * Created by Teymur on 27.02.2018.
 */
public class Card {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String name;
    String type;
    /*
        name:{
                2
                3
                4
                5
                6
                7
                8
                9
                10
                J
                Q
                K
                A
        }
        type:{
                rh
                bh
                bc
                rr
        }
     */
    public Card(String name, String type) {
        this.name=name;
        this.type=type;
    }
    private int toint(Card card){
        String name = card.name;

        if (name == "2"){
            return 2;
        }
        if (name == "3"){
            return 3;
        }
        if (name == "4"){
            return 4;
        }
        if (name == "5"){
            return 5;
        }
        if (name == "6"){
            return 6;
        }
        if (name == "7"){
            return 7;
        }
        if (name == "8"){
            return 8;
        }
        if (name == "9"){
            return 9;
        }
        if (name == "10"){
            return 10;
        }
        if (name == "J"){
            return 11;
        }
        if (name == "Q"){
            return 12;
        }
        if (name == "K"){
            return 13;
        }
        if (name == "A"){
            return 14;
        }
        return 0;
    }

    public boolean comparebig(Card cardb, Card cards, Card trump){
        if(cardb.type == cards.type){
            return (toint(cardb)>toint(cards));
        }else if(cardb.type == trump.type){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return name+" "+type;
    }
}

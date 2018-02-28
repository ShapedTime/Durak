package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Teymur on 28.02.2018.
 */

public class Game {

    Card[] allcards = {
            new Card("2", "rh"),
            new Card("2", "bh"),
            new Card("2", "bc"),
            new Card("2", "rr"),
            new Card("3", "rh"),
            new Card("3", "bh"),
            new Card("3", "bc"),
            new Card("3", "rr"),
            new Card("4", "rh"),
            new Card("4", "bh"),
            new Card("4", "bc"),
            new Card("4", "rr"),
            new Card("5", "rh"),
            new Card("5", "bh"),
            new Card("5", "bc"),
            new Card("5", "rr"),
            new Card("6", "rh"),
            new Card("6", "bh"),
            new Card("6", "bc"),
            new Card("6", "rr"),
            new Card("7", "rh"),
            new Card("7", "bh"),
            new Card("7", "bc"),
            new Card("7", "rr"),
            new Card("8", "rh"),
            new Card("8", "bh"),
            new Card("8", "bc"),
            new Card("8", "rr"),
            new Card("9", "rh"),
            new Card("9", "bh"),
            new Card("9", "bc"),
            new Card("9", "rr"),
            new Card("10", "rh"),
            new Card("10", "bh"),
            new Card("10", "bc"),
            new Card("10", "rr"),
            new Card("J", "rh"),
            new Card("J", "bh"),
            new Card("J", "bc"),
            new Card("J", "rr"),
            new Card("Q", "rh"),
            new Card("Q", "bh"),
            new Card("Q", "bc"),
            new Card("Q", "rr"),
            new Card("K", "rh"),
            new Card("K", "bh"),
            new Card("K", "bc"),
            new Card("K", "rr"),
            new Card("A", "rh"),
            new Card("A", "bh"),
            new Card("A", "bc"),
            new Card("A", "rr")
    };


    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getHand1() {
        return hand1;
    }

    public void setHand1(ArrayList<Card> hand1) {
        this.hand1 = hand1;
    }

    public ArrayList<Card> getHand2() {
        return hand2;
    }

    public void setHand2(ArrayList<Card> hand2) {
        this.hand2 = hand2;
    }

    public Card getTrump() {
        return trump;
    }

    public void setTrump(Card trump) {
        this.trump = trump;
    }

    ArrayList<Card> deck;
    ArrayList<Card> hand1;
    ArrayList<Card> hand2;
    Card trump;

    public Game() {
        ArrayList<Card>[] cards = startnewgame();
        deck = cards[0];
        hand1 = cards[1];
        hand2 = cards[2];
        trump = cards[3].get(0);
    }

    public ArrayList<Card>[] startnewgame(){
        Random rnd= new Random();
        ArrayList<Card> deck = new ArrayList<Card>(Arrays.asList(allcards));
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        Card trump;

        int numberOfElements = 6;


        //HAND1
        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rnd.nextInt(deck.size());
            Card randomElement = deck.get(randomIndex);
            hand1.add(randomElement);
            deck.remove(randomIndex);
        }


        //HAND2
        for (int n = 0; n < numberOfElements; n++) {
            int rndmIndex = rnd.nextInt(deck.size());
            Card rndmElement = deck.get(rndmIndex);
            hand2.add(rndmElement);
            deck.remove(rndmIndex);
        }


        //TRUMP
        trump = deck.get(rnd.nextInt(deck.size()));
        ArrayList<Card> trumpArray = new ArrayList<Card>();
        trumpArray.add(trump);

        ArrayList<Card>[] rtrn = new ArrayList[4];
        rtrn[0] = deck;
        rtrn[1] = hand1;
        rtrn[2] = hand2;
        rtrn[3] = trumpArray;

        return rtrn;
    }
    
    public boolean okayToStart(){
        int it = 0;
        int ir = 0;
        int ib = 0;
        boolean tflag = false;

        //HAND1
        for (Card card: hand1
             ) {
               if(card.getType()==trump.getType()){
                   it++;
               }
               if(card.getType() == "rh" || card.getType() == "rr"){
                   ir++;
               }
               if(card.getType() == "bh" || card.getType() == "bc"){
                   ib++;
               }
        }

        if (it != 0){
            tflag = true;
        }

        if((it >= 5) || (ir==6) || (ib == 6)){
            return false;
        }
        it=0;
        ir=0;
        ib=0;

        //HAND2
        for (Card card: hand2
                ) {
            if(card.getType()==trump.getType()){
                it++;
            }
            if(card.getType() == "rh" || card.getType() == "rr"){
                ir++;
            }
            if(card.getType() == "bh" || card.getType() == "bc"){
                ib++;
            }
        }

        if (it != 0){
            tflag = true;
        }

        if((it >= 5) || (ir==6) || (ib == 6)){
            return false;
        }

        if (!tflag){
            return false;
        }
        return true;
    }
}

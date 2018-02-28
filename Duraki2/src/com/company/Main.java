package com.company;

import java.util.ArrayList;

import static com.company.Main.printGameStatus;

public class Main {

    public static void printGameStatus(Game game){


        ArrayList<Card> deck = game.getDeck();
        ArrayList<Card> hand1 = game.getHand1();
        ArrayList<Card> hand2 = game.getHand2();
        Card trump = game.getTrump();

        System.out.println(deck.toString());
        System.out.println();
        System.out.println(hand1.toString());
        System.out.println();
        System.out.println(hand2.toString());
        System.out.println();
        System.out.println(trump.toString());
    }

    public static void main(String[] args) {

        Game game = new Game();
        boolean gameOkay =  game.okayToStart();
        while(gameOkay == false){
            printGameStatus(game);
            System.out.println("NOT OKAY TO START");
            game = new Game();
            gameOkay = game.okayToStart();
        }

        ArrayList<Card> deck = game.getDeck();
        ArrayList<Card> hand1 = game.getHand1();
        ArrayList<Card> hand2 = game.getHand2();
        Card trump = game.getTrump();


        printGameStatus(game);

    }


}

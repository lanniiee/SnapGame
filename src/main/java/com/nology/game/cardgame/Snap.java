package com.nology.game.cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Card> deckOfCards;
    private Card currentCard;
    private Card previousCard;

    public Snap() {
        deckOfCards = getDeckOfCards();
        shuffleDeck();
    }


    public void runGame() {

        System.out.println(deckOfCards);
    }

    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.runGame();
    }

    // By Pressing enter in the command line, the user takes their turn


    // Each turn, a new card is dealt from the deck


    // The game continues until two cards in a row have the same symbol, at which point the 'player' wins and the game ends.




}

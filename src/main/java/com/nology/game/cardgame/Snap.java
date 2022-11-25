package com.nology.game.cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Card> deckOfCards;
    private Card currentCard;
    private ArrayList<Card> discardPile = new ArrayList<>();
    private String input;
    private boolean playingGame = false;

    public Snap() {
        deckOfCards = getDeckOfCards();
        discardPile = getDiscardPile();
        shuffleDeck();
    }


    public void runGame() {
        System.out.println("Press Enter to start!");
        playingGame = true;
        while (playingGame) {
            input = scanner.nextLine();
            currentCard = dealCard();
            System.out.println(currentCard);
            if (discardPile.size() > 1) {
                if (currentCard.getSymbol().equals(discardPile.get(discardPile.size()-2).getSymbol())) {
                    System.out.println("Well Done! You have won!");
                    playingGame = false;
                }
            }
            if (deckOfCards.size() == 0) {
                System.out.println("You did not win this time!");
                playingGame = false;
            }

        }
    }

    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.runGame();
    }

    // By Pressing enter in the command line, the user takes their turn


    // Each turn, a new card is dealt from the deck


    // The game continues until two cards in a row have the same symbol, at which point the 'player' wins and the game ends.




}

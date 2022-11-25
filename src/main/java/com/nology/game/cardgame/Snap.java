package com.nology.game.cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {

    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Card> deckOfCards;
    private final ArrayList<Card> discardPile;

    public Snap() {
        deckOfCards = getDeckOfCards();
        discardPile = getDiscardPile();
        shuffleDeck();
    }


    public void runGame() {
        System.out.println("Press Enter to start!");
        boolean playingGame = true;
        while (playingGame) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                Card currentCard = dealCard();
                System.out.println("Current card: " + currentCard);
                if (discardPile.size() > 1) {
                    if (currentCard.getSymbol().equals(discardPile.get(discardPile.size()-2).getSymbol())) {
                        System.out.println("\nWell Done! You have won!");
                        playingGame = false;
                    }
                }
                if (deckOfCards.size() == 0) {
                    System.out.println("\nYou did not win this time!");
                    playingGame = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.runGame();
    }


}

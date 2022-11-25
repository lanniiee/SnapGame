package com.nology.game.cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {

    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Card> deckOfCards;
    private final ArrayList<Card> discardPile;
    private ArrayList<String> players = new ArrayList<>();
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    private String input;
    private boolean playingGame = false;
    private Card currentCard;
    private String currentPlayer;

    public Snap() {
        deckOfCards = getDeckOfCards();
        discardPile = getDiscardPile();
        shuffleDeck();
    }

    public void playerTurn() {
        input = scanner.next();
        if (input.isEmpty()) {
            currentCard = dealCard();
            System.out.println("It is turn");
            System.out.println(currentCard);
        }
        if (discardPile.size() > 1) {
            if (currentCard.getSymbol().equals(discardPile.get(discardPile.size()-1).getSymbol())) {
                System.out.println("won!");
                playingGame = false;
            }
        }
    }


    public void runGame() {

        setUp();

        while (playingGame == true) {
            for (int i = 1; i < players.size() + 1; i++) {
                if(i%2 != 0 ) {
                    currentPlayer = playerOne.getPlayerName();
                } else {
                    currentPlayer = playerTwo.getPlayerName();
                }
                input = scanner.nextLine();
                if (input.isEmpty()) {
                    Card currentCard = dealCard();
                    System.out.println(currentPlayer + "'s turn.");
                    System.out.println("Current card: " + currentCard);
                    if (discardPile.size() > 1) {
                        if (currentCard.getSymbol().equals(discardPile.get(discardPile.size()-2).getSymbol())) {
                            System.out.println("\nGAME OVER! " +currentPlayer +" have won!");
                            playingGame = false;
                        }
                    }
                }
                if (deckOfCards.size() == 0) {
                    playingGame = false;
                }
            }
        }

    }

    public void setUp() {

        for (int i = 1; i < 3; i++) {
            System.out.println("Enter your name player " + i + ":");
            input = scanner.nextLine();
            players.add(input);
        }
        playerOne.setPlayerName(players.get(0));
        playerTwo.setPlayerName(players.get(1));
        System.out.println("\nSet up is ready. Press enter to start!");
        playingGame = true;
    }


    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.runGame();
    }

}

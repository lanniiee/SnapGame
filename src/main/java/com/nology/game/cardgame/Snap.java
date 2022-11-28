package com.nology.game.cardgame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Card> deckOfCards;
    private final ArrayList<Card> discardPile;
    private final ArrayList<String> players = new ArrayList<>();
    private final Player playerOne = new Player();
    private final Player playerTwo = new Player();
    private String input;
    private boolean playingGame = false;
    private final Timer timer = new Timer();
    private int interval = 5;

    private void setInterval() {
      if (interval == 0) {
          timer.cancel();
      }
      --interval;
    }


    public Snap() {
        deckOfCards = getDeckOfCards();
        discardPile = getDiscardPile();
        shuffleDeck();
    }


    public void runGame() {

        setUp();

        while (playingGame) {
            String currentPlayer;
            for (int i = 1; i < players.size() + 1; i++) {
                if(i%2 != 0 ) {
                    currentPlayer = playerOne.getPlayerName();
                } else {
                    currentPlayer = playerTwo.getPlayerName();
                }
                if (playingGame) {
                    System.out.println("\n" + currentPlayer + "'s turn. Press enter to deal the next card");
                    input = scanner.nextLine();
                }
                if (input.isEmpty()) {
                    Card currentCard = dealCard();
                    System.out.println("Current card: " + currentCard);
                    if (discardPile.size() > 1) {
                        if (currentCard.getSymbol().equals(discardPile.get(discardPile.size()-2).getSymbol())) {
                            System.out.println("You have 5 secs to type 'snap' and press enter to win!");
                            timer.scheduleAtFixedRate(new TimerTask() {
                                public void run() {
                                    setInterval();
                                }
                            }, 1000, 1000);
                            input = scanner.nextLine();
                            String inputToLowercase = input.toLowerCase();
                            if (interval > 0 && inputToLowercase.equals("snap")) {
                                System.out.println("\nSNAP! " +currentPlayer +" have won!");
                            }
                            else {
                                System.out.println(currentPlayer + " have failed to snap on time! Game Over! " +currentPlayer + " loses!");
                            }
                            playingGame = false;
                        }
                    }
                }
                else if (deckOfCards.size() == 1) {
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


}

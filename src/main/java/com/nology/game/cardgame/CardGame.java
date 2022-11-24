package com.nology.game.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

    private final char[] suit = new char[] {'\u2764', '\u2660', '\u2663', '\u2666'};
    private final String[] symbol = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q" , "K", "A"};

    // Contains an ArrayList<Card> for the deckOfCards that contains all 52 cards. This is created and populated when the game is constructed.
    private ArrayList<Card> deckOfCards = new ArrayList<>();

    // Has a name which is also defined in the constructor
    public CardGame() {

        for (int a = 0; a < suit.length; a++){
            for (int b = 0; b < symbol.length; b++) {
                Card card = new Card(suit[a], symbol[b], b + 2);
                deckOfCards.add(card);
            }
        }
    }

    // Has a getDeck method that lists out the cards in the deck
    public ArrayList<Card> getDeckOfCards() {
        return this.deckOfCards;
    }

    public Card dealCard() {
        return this.deckOfCards.get(51);
    }

    public ArrayList<Card> sortDeckByNumber() {
        Collections.sort(deckOfCards, (a, b) -> Integer.compare(a.getValue(), b.getValue()));
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(deckOfCards, (a, b) -> Character.compare(a.getSuit(), b.getSuit()));
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        //Shuffles the deck into a random order and stores the new shuffled deck back into the deckOfCards attribute.
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }


    public static void main(String[] args) {

        CardGame cards = new CardGame();
        System.out.println(cards.shuffleDeck());
        System.out.println(cards.dealCard());

    }
}

package com.nology.game.cardgame;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    private final String[] suit = new String[] {"\u2665", "\u2660", "\u2663", "\u2666"};
    private final String[] symbol = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q" , "K", "A"};

    // Contains an ArrayList<Card> for the deckOfCards that contains all 52 cards. This is created and populated when the game is constructed.
    private ArrayList<Card> deckOfCards = new ArrayList<>();
    private ArrayList<Card> discardPile = new ArrayList<>();
    private Card currentCard;

    // Has a name which is also defined in the constructor
    public CardGame() {

        for (String s : suit) {
            for (int b = 0; b < symbol.length; b++) {
                Card card = new Card(s, symbol[b], b + 2);
                deckOfCards.add(card);
            }
        }
    }

    // Has a getDeck method that lists out the cards in the deck
    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public Card dealCard() {
        currentCard = deckOfCards.get(deckOfCards.size()-1);
        deckOfCards.remove(deckOfCards.size()-1);
        discard();
        return currentCard;
    }

    public void discard() {
        discardPile.add(currentCard);
    }

    public ArrayList<Card> sortDeckByNumber() {
        Collections.sort(deckOfCards, (a, b) -> Integer.compare(a.getValue(), b.getValue()));
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(deckOfCards, (a, b) -> CharSequence.compare(a.getSuit(), b.getSuit()));
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        //Shuffles the deck into a random order and stores the new shuffled deck back into the deckOfCards attribute.
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }


    public static void main(String[] args) {

    }

}

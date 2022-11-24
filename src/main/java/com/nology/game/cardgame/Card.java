package com.nology.game.cardgame;

public class Card {

    // Has a String suit. Use the unicode characters of {heart, club, diamond, and spade}
    private String suit;

    // Has a string symbol {2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A }
    private String symbol;

    // Has an int value {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}
    private int value;


    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    // Has a toString method that describe the class
    @Override
    public String toString() {
        return this.suit + this.symbol;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }
}

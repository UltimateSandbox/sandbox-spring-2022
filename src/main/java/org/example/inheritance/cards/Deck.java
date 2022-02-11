package org.example.inheritance.cards;

/**
 * Defines the API for a deck of cards. Used for extensibility for other types of decks that you may want to add later.
 */
public interface Deck {

    void shuffle();

    void cut(int index);

    Card deal();

    Card turnOver();

    int search(Card card);

    void newOrder();

    int size();

}

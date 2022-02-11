package org.example.inheritance.cards;

import java.util.*;

/**
 * Created by Ray Hedgecock on 4/7/2017.
 * <p>
 * This could benefit from using an abstract class as there are a lot of common method implementations between deck
 * types.
 *
 * @author Ray Hedgecock
 * @since 1.0.0
 */
public class StandardDeck implements Deck {

    List<Card> cards;

    public StandardDeck() {
        this.cards = newDeck();
    }

    public List<Card> getDeck() {
        return this.cards;
    }

    /**
     * Shuffles this deck of cards.
     */
    @Override
    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(this.cards, new Random(seed));
    }

    /**
     * Quick and dirty way to do a split.  There are more elegant ways using partitions and generics.
     *
     * @param index
     */
    @Override
    public void cut(int index) {

        List<Card> top = new ArrayList<>();
        top.addAll(this.cards.subList(0, index));
        List<Card> bottom = new ArrayList<>();
        bottom.addAll(this.cards.subList(index, this.cards.size()));

        this.cards.clear();

        this.cards.addAll(bottom);
        this.cards.addAll(top);

    }

    /**
     * Removes the card at the top.
     *
     * @return
     */
    @Override
    public Card deal() {
        return this.cards.remove(0);
    }

    /**
     * Gets the card at the top without removing it.
     *
     * @return
     */
    @Override
    public Card turnOver() {
        return this.cards.get(0);
    }

    /**
     * Returns the index of the given card.
     *
     * @param card
     * @return
     */
    @Override
    public int search(Card card) {
        return this.cards.indexOf(card);
    }

    /**
     * This method works because the cards are comparable. Sort order is determined by the ordinality of the two enums
     * used for the cards suit and face values.
     */
    @Override
    public void newOrder() {
        Collections.sort(this.cards);
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    /**
     * Generates new unshuffled deck of cards.
     *
     * @return deck of cards
     */
    private List<Card> newDeck() {

        /*
        This is an example of an Anonymous Class
        This link has more info on this useful pattern
        https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
        */
        List<Card> newDeck = new ArrayList<>() {

            @Override
            public String toString() {

                final StringJoiner joiner = new StringJoiner(", ");
                joiner.add("Deck Size [" + this.size() + "]");
                this.stream()
                    .forEach(card -> {
                        joiner.add(card.toString());
                    });
                return joiner.toString();
            }
        };

        Arrays.stream(Suit.values())
              .forEach(suit -> {

                  Arrays.stream(FaceValue.values())
                        .map(faceValue -> new Card(suit, faceValue))
                        .forEach(newDeck::add);

              });

        return newDeck;
    }

    @Override
    public String toString() {

        return this.cards.toString();
    }
}

package org.example.inheritance.cards;

/**
 * Represents a single Card We make it Comparable so it's easier to sort. It's also immutable - we don't want the values
 * to change for any instance of the card.
 */
public class Card implements Comparable<Card> {

    private Suit suit;
    private FaceValue value;

    private Card() {
    }

    public Card(Suit suit, FaceValue value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public FaceValue getValue() {
        return this.value;
    }

    /**
     * This works because of the way ordinals are numbered in enum types. Quick and dirty way of doing a compareTo
     * method.
     *
     * @param card the card you're comparing to
     * @return -1, 1 or 0 depending on if it's greater, less than or equal to.
     */
    @Override
    public int compareTo(Card card) {

        if (this.getSuit()
                .ordinal() > card.getSuit()
                                 .ordinal()) {
            return 1;
        } else if (this.getSuit()
                       .ordinal() < card.getSuit()
                                        .ordinal()) {
            return -1;
        } else {

            if (this.suit == Suit.HEARTS || this.suit == Suit.CLUBS) {

                // ascending sort
                if (this.getValue()
                        .ordinal() > card.getValue()
                                         .ordinal()) {
                    return 1;
                } else if (this.getValue()
                               .ordinal() < card.getValue()
                                                .ordinal()) {
                    return -1;
                } else {
                    return 0;
                }

            } else {

                // descending sort
                if (this.getValue()
                        .ordinal() < card.getValue()
                                         .ordinal()) {
                    return 1;
                } else if (this.getValue()
                               .ordinal() > card.getValue()
                                                .ordinal()) {
                    return -1;
                } else {
                    return 0;
                }
            }

        }
    }

    /**
     * Implemented only because it's a good idea to do so when implementing equals (used with hash type collections,
     * HashMap, etc...)
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    /**
     * Used for some collections operations.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return value == card.value;
    }

    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer().append("[")
                                                  .append(value)
                                                  .append(" of ")
                                                  .append(suit)
                                                  .append("]");
        return sb.toString();
    }
}

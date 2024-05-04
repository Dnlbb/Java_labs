enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES
}

enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

class Card implements Comparable<Card> {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int compareTo(Card other) {
        int eqq = this.rank.compareTo(other.rank);
        if (eqq != 0) {
            return eqq;
        } else {
            return this.suit.compareTo(other.suit);
        }
    }


    public String toString() {
        return rank + " - " + suit;
    }
}
import java.util.Arrays;

class PokerHand {
    private Card[] cards;

    public PokerHand(Card[] cards) {
        this.cards = new Card[cards.length];
        System.arraycopy(cards, 0, this.cards, 0, cards.length);
    }

    public void printSortedHand() {
        Arrays.sort(cards);
        System.out.println(Arrays.toString(cards));
    }
}


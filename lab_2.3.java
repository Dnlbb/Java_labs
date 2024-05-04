public class Main {
    public static void main(String[] args) {
        Card[] cards = {
                new Card(Suit.HEARTS, Rank.TEN),
                new Card(Suit.CLUBS, Rank.ACE),
                new Card(Suit.SPADES, Rank.THREE),
                new Card(Suit.DIAMONDS, Rank.KING),
                new Card(Suit.HEARTS, Rank.JACK)
        };


        PokerHand pokerHand = new PokerHand(cards);
        pokerHand.printSortedHand();



        Universe universe = new Universe(3);
        universe.setCell(1, 1, true);
        universe.setCell(0, 1, true);
        universe.setCell(1, 0, true);

        universe.updateNeighbors();
        universe.So();
    }
}

package Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


/**
 * Deck of cards adds 52 cards. Shuffles the cards and has the option to print out all of the 52 cards.
 */
public class DeckOfCards {
    private final char[] suit = new char[]{'S', 'H', 'D', 'C'};
    private final Integer[] face = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private ArrayList<Card> deck;
    private Random random;


    /**
     * Instantiates a new Deck of cards and shuffels the cards.
     */
    public DeckOfCards() {
        this.deck = new ArrayList<>();
        random = new Random();
        addCards();
        shuffelCards();
    }

    /**
     * Get deck array list.
     *
     * @return the array list
     */
    public ArrayList<Card> getDeck(){
        return this.deck;
    }

    /**
     * Sets deck.
     *
     * @param deck the deck
     */
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }


    /**
     * Add cards to the deck.
     */
    public void addCards() {
        for(int i = 0; i < this.suit.length; ++i) {
            String value = String.valueOf(this.suit[i]);

            for(int x = 0; x < this.face.length; ++x) {
                this.deck.add(new Card(this.suit[i], this.face[x]));
            }
        }

    }

    /**
     * Deck info. Prints all of the cards, if needed.
     *
     * @return the string
     */
    public String deckInfo() {
        String output = "";

        for(int i = 0; i < this.deck.size(); ++i) {
            output = output + ((Card)this.deck.get(i)).getAsString() + "\n";
        }
        return output;
    }


    /**
     * Shuffel cards.
     */
    public void shuffelCards() {
        this.deck.forEach((card) -> {
            Collections.shuffle(this.deck);
        });
    }


    /**
     * Deal hand collection.
     *
     * @param card the card
     * @return the collection
     * @throws IllegalArgumentException the illegal argument exception
     */
    public Collection<Card> dealHand(int card) throws IllegalArgumentException {
        if (card > this.deck.size()) {
            throw new IllegalArgumentException();
        } else {
            ArrayList<Card> drawnCard = new ArrayList();

            for(int cardsDrawn = 0; cardsDrawn < card; ++cardsDrawn) {
                Card cardDrawn = this.deck.get(random.nextInt(deck.size()));
                drawnCard.add(cardDrawn);
                this.deck.remove(cardDrawn);
            }

            return drawnCard;
        }
    }
}
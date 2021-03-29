package Game;

import javafx.scene.image.Image;

public class Card {

    private final char suit;
    private final int face;
    private Image image;

    public Card(char suit, int face) {
        this.suit = suit;
        this.face = face;
    }

    public char getSuit() {
        return this.suit;
    }

    public int getFace() {
        return this.face;
    }

    public String asString() {
        return this.face + " of " + this.suit;
    }
}

package Game.Cards;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a playing card. A playing card has a number (face) between
 * 1 and 13, where 1 is called an Ace, 11 = Knight, 12 = Queen and 13 = King.
 * The card can also be one of 4 suits: Spade, Heart, Diamonds and Clubs.
 *
 * @author no.ntnu
 * @version 2020-01-10
 */
public class Card {

    private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    private final int face; // a number between 1 and 13


    /**
     * Creates an instance of a ntnu.PlayingCard with a given suit and face.
     *  @param suit The suit of the card, as a single character. 'S' for Spades,
     *             'H' for Heart, 'D' for Diamonds and 'C' for club
     * @param face The face value of the card, an integer between 1 and 13
     */
    public Card(char suit, int face) {

        List<Integer> validFaceNames = getValidFace();
        if (validFaceNames.contains(face)){
            this.face = face;
        } else {
            throw new IllegalArgumentException("The valid faceNames: "+ validFaceNames + "");
        }

        List<Character> validSuitNames = getValidSuits();
        if (validSuitNames.contains(suit)) {
            this.suit = suit;
        } else{
            throw new IllegalArgumentException("The valid suitNames; "+ validSuitNames + "");
        }
    }
    /**
     * Returns the suit and face of the card as a string.
     * A 4 of hearts is returned as the string "H4".
     *
     * @return the suit and face of the card as a string
     */

    public String getAsString() {
        return String.format("%s%s", suit, face);
    }

    public static List<Integer> getValidFace(){
        return Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
    }

    public static List<Character> getValidSuits(){
        return Arrays.asList('S','H','C','D');
    }



    /**
     * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for clubs
     *
     * @return the suit of the card
     */
    public char getSuit() {
        return suit;
    }
    /**
     * Returns the face of the card (value between 1 and 13).
     *
     * @return the face of the card
     */
    public int getFace() {
        return face;
    }


}
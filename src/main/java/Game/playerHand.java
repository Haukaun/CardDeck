package Game;


import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The class that make a new Playerhand nad has metohdes that checks what the hand contains. Playerhand contains different cards
 * added from the deck of cards class.
 */
public class playerHand {


    private ArrayList<Card> hand;

    /**
     * Gets hand.
     *
     * @return hand hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Instantiates a new Player hand.
     */
    public playerHand() {
        this.hand = new ArrayList<>();
    }

    /**
     * Add card.
     *
     * @param card the card
     * @throws NullPointerException the null pointer exception
     */
    public void addCard(Card card) throws NullPointerException{
        if(card != null){
            hand.add(card);
        } else {
            throw new NullPointerException();
        }
    }


    /**
     * The Sum of cards in hand using stream.
     *
     * @return integer
     */
    public Integer sumOfCards() throws IllegalArgumentException{
        return this.hand.stream().map(Card::getFace).mapToInt(Integer::intValue).sum();
    }

    /**
     * The Highest card in hand using stream.
     *
     * @return the integer
     */
    public Integer highCard() throws IllegalArgumentException{
       return this.hand.stream().map(Card::getFace).max(Integer::compare).get();
    }

    /**
     * Check is hand contains flush.
     *
     * @return returns true is hand contains flush or flase is not.
     * @throws IllegalArgumentException the illegal argument exception
     */
    public boolean checkFlush()throws IllegalArgumentException{
        //Creating an arraylist checkFlush that has filtered out the cards that don't have
        //the same suit as the first card in the hand.
        ArrayList<Card> checkFlush = getHand().stream()
                .filter(card -> card.getSuit() == getHand().get(0).getSuit())
                .collect(Collectors.toCollection(ArrayList::new));
        //Checking to see if a card has been removed, if card has been removed it will return false(no flush)
        //if a card hasn't been removed that means all the cards in the hand has the same suit(flush)*/
        if (checkFlush.size() == getHand().size()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Searches through hand and gets all heart as string.
     *
     * @return heart as string
     * @throws IllegalArgumentException the illegal argument exception
     */
    public String getHeartAsString() throws IllegalArgumentException{

        StringBuilder sb = new StringBuilder();

        getHand().stream()
                .filter(card -> card.getSuit() == 'H')
                .forEach(card -> sb.append(card.getAsString()).append(" "));

        if(sb.length() < 2)
            sb.append("No Hearts");

        return sb.toString().trim();
    }


    /**
     * Gets hand as string.
     *
     * @return the hand as string
     */
    public String getHandAsString() throws IllegalArgumentException {
        return getHand().stream().map(Card::getAsString).collect(Collectors.joining(" "));
    }

    /**
     * Check hand for queen of spade.
     *
     * @return the boolean
     */
    public boolean checkQueenOfSpade() throws IllegalArgumentException{


        ArrayList a = getHand().stream()
                .filter(card -> card.getAsString().equals("12S"))
                .collect(Collectors.toCollection(ArrayList::new));

        if (a.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

}

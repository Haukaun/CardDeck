package Game;


import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 */
public class playerHand {


    private ArrayList<Card> hand;

    /**
     *
     * @return
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     *
     */

    public playerHand() {
        this.hand = new ArrayList<>();
    }

    /**
     *
     * @param card
     * @throws NullPointerException
     */
    public void addCard(Card card) throws NullPointerException{
        if(card != null){
            hand.add(card);
        } else {
            throw new NullPointerException();
        }
    }



    /**
     *
     * @return
     */
    public Integer sumOfCards(){
        return this.hand.stream().map(Card::getFace).mapToInt(Integer::intValue).sum();
    }

    public Integer highCard(){
       return this.hand.stream().map(Card::getFace).mapToInt(Integer::intValue).sum();
    }

    /**
     *
     * @return
     * @throws IllegalArgumentException
     */
    public boolean checkFlush()throws IllegalArgumentException{

        ArrayList<Card> checkFlush = getHand().stream()
                .filter(card -> card.getSuit() == getHand().get(0).getSuit())
                .collect(Collectors.toCollection(ArrayList::new));

        if (checkFlush.size() == getHand().size()){
            return true;
        } else {
            throw new IllegalArgumentException("Something went wrong!");
        }
    }

    /**
     *
     * @return
     * @throws IllegalArgumentException
     */
    public String getHeartAsString() throws IllegalArgumentException{
        StringBuilder sb = new StringBuilder();
        getHand().stream()
                .filter(card -> card.getSuit() == 'H')
                .forEach(card -> sb.append(card.getAsString()).append(" "));

        if(sb.length() < 1)
            sb.append("No Hearts");

        return sb.toString().trim();
    }



    public String getHandAsString() {
        return getHand().stream().map(Card::getAsString).collect(Collectors.joining(""));
    }

}

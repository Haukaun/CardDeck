package Game;

import java.util.ArrayList;
import java.util.Optional;

public class playerHand {

    private ArrayList<Card> hand;


    public playerHand() {
        this.hand = new ArrayList<>();

    }

    public void addCard(Card card) throws NullPointerException{
        if(card != null){
            hand.add(card);
        } else {
            throw new NullPointerException();
        }
    }

    public Optional<Integer> sumOfCards(){
        return this.hand.stream().map(Card::getFace).reduce(Integer::sum);
    }

    public Optional<Integer> highCard(){
       return this.hand.stream().map(Card::getFace).reduce(Integer::max);
    }




}

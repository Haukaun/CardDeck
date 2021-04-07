package Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class playerHandTest {

    private playerHand hand;

    Card card1 = new Card('H', 13);
    Card card2 = new Card('H', 12);
    Card card3 = new Card('H', 3);
    Card card4 = new Card('H', 5);
    Card card5 = new Card('S', 12);


    @BeforeEach
    void setUp(){
        hand = new playerHand();
    }

    @Test
    void validAddCard(){
        try{
            hand.addCard(card1);
    } catch (NullPointerException e){
            fail();
        }
        assertEquals(true, hand.getHand().contains(card1));
    }


    @Test
    void unValidAddCard(){
        try{
            hand.addCard(null);
        }catch (NullPointerException e){
            assertEquals("Card added cant be null", e.getMessage());
        }
    }



}
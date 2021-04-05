package Game;



import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;


/**
 * The type Game client. Where all of the buttons and labels is controlled. The class that adds new cards to hand.
 */
public class GameClient {

    private final DeckOfCards deck = new DeckOfCards();
    private final playerHand hand = new playerHand();
    public TilePane deckImageView;
    public Button draw5CardsButton;
    public Label flushLabel;
    public Label heartLabel;
    public Label queenLabel;
    public Button highCard;
    public Button sumCard;


    /**
     * Gets sum of cards.
     */
    public void getSumofCards(){
        sumCard.setOnAction(actionEvent -> alertBox.display("Sum of Cards", "Sum of cards is:\n          "+hand.sumOfCards()+""));
    }

    /**
     * Get the highest card in hand.
     */
    public void getHighCard(){
        highCard.setOnAction(actionEvent -> alertBox.display("HighCard", "The highest Card:\n           "+hand.highCard()+""));
    }


    /**
     * Draw 5 cards button. Sets button to redraw, and clears hand and pane.
     */
    public void Draw5Button() {
        deck.dealHand(5).forEach(hand::addCard);
        draw5CardsButton.setText("ReDraw");
        draw5CardsButton.setOnAction(actionEvent -> ClearPane());
        updatePathImages();
        labelsUpdate();

        if(deck.getDeck().size() <= 5){
            deck.addCards();
        }

    }

    /**
     * Clear pane and hand.
     */
    public void ClearPane(){
        hand.getHand().clear();
        deckImageView.getChildren().clear();
    }

    /**
     * Check if hand contains flush.
     */
    public void checkFlush(){
        if(hand.checkFlush()){
            flushLabel.setText("Congrats, Flush!");
        } else {
            flushLabel.setText("No Flush! Keep trying!");
        }
    }

    /**
     * Check if hand contains queen.
     */
    public void checkQueen(){
        if(hand.checkQueenOfSpade()){
            queenLabel.setText("Queen of Spade in Display!");
        } else {
            queenLabel.setText("No Queen of Spade drawn!");
        }
    }

    /**
     * Labels update.
     */
    public void labelsUpdate(){
        checkFlush();
        checkQueen();

        heartLabel.setText(hand.getHeartAsString());
    }


    /**
     * Update path images.
     */
    public void updatePathImages() {

        ArrayList<Card> cards = hand.getHand();

        this.deckImageView.getChildren().clear();
        cards.forEach(c -> {

            String path = "/Game/Images/"+c.getFace()+""+c.getSuit()+".png";

            ImageView imageView = new ImageView(path);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(137);
            imageView.setFitHeight(246);
            this.deckImageView.getChildren().add(imageView);
        });
    }







}
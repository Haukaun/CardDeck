package Game;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;


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


    public void getSumofCards(){
        sumCard.setOnAction(actionEvent -> alertBox.display("Sum of Cards", "Sum of cards is:\n          "+hand.sumOfCards()+""));
    }

    public void getHighCard(){
        highCard.setOnAction(actionEvent -> alertBox.display("HighCard", "The highest Card:\n           "+hand.highCard()+""));
    }


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

    public void ClearPane(){
        hand.getHand().clear();
        deckImageView.getChildren().clear();
    }

    public void checkFlush(){
        if(hand.checkFlush()){
            flushLabel.setText("Congrats, you managed to draw a Flush!");
        } else {
            flushLabel.setText("No Flush! Keep trying!");
        }
    }

    public void checkQueen(){
        if(hand.checkQueenOfSpade()){
            queenLabel.setText("Queen of Spade in Display!");
        } else {
            queenLabel.setText("No Queen of Spade drawn!");
        }
    }




    public void labelsUpdate(){
        checkFlush();
        checkQueen();

        heartLabel.setText(hand.getHeartAsString());
    }








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
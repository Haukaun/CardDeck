package Game;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Button ShuffleButton;



    public void Draw5Button() {
        deck.dealHand(5).forEach(hand::addCard);
        draw5CardsButton.setText("Redraw");
        draw5CardsButton.setOnAction(actionEvent -> redrawButton());
        updateImages();

    }


    public void redrawButton(){
        hand.getHand().clear();
        deckImageView.getChildren().clear();
        deck.dealHand(5).forEach(hand::addCard);
    }


    public void updateImages() {

        ArrayList<Card> cards = hand.getHand();

        this.deckImageView.getChildren().clear();
        cards.forEach(c -> {

            String path = "/Game/Images/"+c.getFace()+""+c.getSuit()+".png";

            ImageView imageView = new ImageView(path);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(100);
            this.deckImageView.getChildren().add(imageView);
        });
    }



}
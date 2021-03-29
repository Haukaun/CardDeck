package Game;

import Game.DeckOfCards;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DeckViewController implements Initializable {

    @FXML private Button drawCardButton;
    @FXML private ImageView deckImageView;
    @FXML private ImageView activeCardImageView;
    private DeckOfCards deck;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deck = new DeckOfCards();
        deck.addCards();
        deck.shuffelCards();

        deckImageView.setImage(deck.getBackOfCardImage());
    }

    @FXML public void DrawButtonPushed()
    {

    }
}
module no.ntnu.idata2001 {
    requires javafx.controls;
    requires javafx.fxml;

    opens Game to javafx.fxml;
    exports Game;
}
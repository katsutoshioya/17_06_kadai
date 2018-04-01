import javafx.geometry.Pos;
import javafx.scene.control.Label;


public class MyLabel extends Label {

    public MyLabel() {
        super();
        this.setText("1");
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(100);
        this.setPrefHeight(100);
        this.setStyle( "-fx-border-radius: 1.0em;"+
                "-fx-border-color: black;"+
                "-fx-border-width: 1.3px;");
    }
}

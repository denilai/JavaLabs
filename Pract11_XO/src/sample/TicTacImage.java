package sample;

import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.InputStream;

public class TicTacImage extends ImageView {
    public static Image emptyCell = new Image(Main.class.getResourceAsStream("empty.png"));

    TicTacImage(int sizeOfImage){
        super(emptyCell);
        this.setFitHeight(sizeOfImage);
        this.setFitWidth(sizeOfImage);

        GridPane.setHgrow(this, Priority.NEVER);
        GridPane.setVgrow(this,Priority.NEVER);
    }

    public void clearImage(){
        this.setImage(emptyCell);
    }
}

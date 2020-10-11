package sample;

import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyButton extends Button {
    private Button btn;
    MyButton(){
        btn = this;
        this.setOnAction(actionEvent -> {
            //this.graphicProperty().setValue(new ImageView(new Image("xo.png")));
            System.out.println("fdf");
        });
    }
}

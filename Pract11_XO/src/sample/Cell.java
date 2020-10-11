package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class Cell {
    TicTacImage image;
    private Record record;
    sample.Point point;

    Cell(int sizeOfImage,Point point){

        record = Record.EMPTY;

        this.image = new TicTacImage(sizeOfImage);

        this.point = point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setImage(TicTacImage image) {
        this.image = image;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Record getRecord() {
        return record;
    }

    public void clearRecord(){
        setRecord(Record.EMPTY);
    }
}

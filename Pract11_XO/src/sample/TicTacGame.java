package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Vector;

public class TicTacGame {

    private Vector<Cell> canvas = new Vector<>();

    private boolean isXMove;

    public Label move;

    public Label score;

    private boolean gameOver;

    Record winner=Record.EMPTY;

    private int sizeOfCanvas = 0;
    private int sizeOfImage = 0;
    private int countOfXWins = 0;
    private int countOfOWins = 0;


    public TicTacGame(int sizeOfCanvas, int sizeOfCell, Label move, Label score) {

        isXMove = true;

        this.move = move;
        this.score = score;
        score.setAlignment(Pos.CENTER);


        setLabel();

        this.sizeOfCanvas = sizeOfCanvas;

        for (int i = 0; i < sizeOfCanvas * sizeOfCanvas; i++)
            canvas.add(
                    new Cell(sizeOfCell,new Point(i%sizeOfCanvas,i/sizeOfCanvas))
            );
        isXMove = true;

        setHandlers();

    }

    private void setLabel(){
        if(isXMove)
            move.setText("Ход: Крестики");
        else move.setText("Ход: Нолики");

        score.setText("Крестики  VS  Нолики\n\t\t" + countOfXWins + " : " + countOfOWins);
    }

    private void setHandlers(){
        canvas.forEach(cell -> {
            cell.image.setOnMouseClicked(mouseEvent -> {
                if(!gameOver) {
                    if (cell.getRecord() == Record.EMPTY) {
                        if (isXMove) {
                            cell.image.setImage(new Image(Main.class.getResourceAsStream("x.png")));
                            cell.setRecord(Record.X);
                            isXMove = false;
                        } else {
                            cell.image.setImage(new Image(Main.class.getResourceAsStream("o.png")));
                            cell.setRecord(Record.O);
                            isXMove = true;
                        }
                    }
                    setLabel();
                    // проверка статуса игры: Победа Х | Победа О | Ничья
                    gameStatus();
                    if (gameOver)
                        congratulations();
                }
            });
        });
    }

    public Vector<Cell> getCanvas() {
        return canvas;
    }

    public void gameStatus() {
        Record lastMove;
        if(isXMove)
             lastMove = Record.O;
        else lastMove = Record.X;

        for(int i =0;i<sizeOfCanvas;i++)
            if(isFiledColumn(lastMove,i)||isFiledLine(lastMove,i)) {
                winner = lastMove;
                gameOver = true;
            }

        if(isFieldFirstDiagonal(lastMove)||isFieldSecondDiagonal(lastMove)) {
            winner = lastMove;
            gameOver = true;
        }
        // поле заполнено
        if(isFieldCanvas())
            gameOver = true;
    }

    // проверка - заполнена ли вся строка символом record
    private boolean isFiledLine(Record record, int row) {
        for(int i=row*sizeOfCanvas;i<(row+1)*sizeOfCanvas;i++){
            if(canvas.get(i).getRecord()!=record)
                return false;
        }
        return true;
    }

    private boolean isFiledColumn(Record record, int col){

        for(int i=col;i<sizeOfCanvas*sizeOfCanvas;i+=sizeOfCanvas){
            if(canvas.get(i).getRecord()!=record)
            return false;
        }
        return true;
    }

    private boolean isFieldFirstDiagonal(Record record){
        for (int i = 0,j=0; i < sizeOfCanvas; i++) {
            if(canvas.get(i*sizeOfCanvas+j).getRecord()!=record)
                return false;
            j++;
        }
        return true;
    }

    private boolean isFieldSecondDiagonal(Record record){
        for (int i=0,j=sizeOfCanvas-1;i<sizeOfCanvas;i++){
            if(canvas.get(i*sizeOfCanvas+j).getRecord()!=record)
                return false;
            j--;
        }
        return true;
    }

    private boolean isFieldCanvas(){
        boolean isEmptyCells = false;
        for(Cell cell :canvas)
            if(cell.getRecord() == Record.EMPTY)
                isEmptyCells = true;
        return  !isEmptyCells;
    }

    public void congratulations(){
        Label label = new Label();
        if (winner == Record.O) {
            label.setText("Победили нолики!");
            countOfOWins++;
        }
        if(winner == Record.X){
            label.setText("Победили крестики!");
            countOfXWins++;
        }
        if(winner == Record.EMPTY)
            label.setText("Пока ничья. Давай по новой!");

        StackPane layout = new StackPane();
        layout.getChildren().add(label);

        Scene secondScene = new Scene(layout, 230, 100);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Результат");
        newWindow.setScene(secondScene);
        newWindow.getIcons().add(new Image(Main.class.getResourceAsStream("horn.png")));

        // Set position of second window, related to primary window.

        newWindow.show();
    }

    public int getCountOfOWins() {
        return countOfOWins;
    }

    public int getCountOfXWins() {
        return countOfXWins;
    }

    public void newGame(){
        isXMove = true;
        setLabel();
        canvas.forEach(cell->{
            cell.image.clearImage();
            cell.clearRecord();
        });
        winner = Record.EMPTY;
        gameOver = false;
    }
}
